package com.JonathanGzzBen.MarinePreservationApi.Config;

import com.JonathanGzzBen.MarinePreservationApi.Model.MarineSpecies;
import com.JonathanGzzBen.MarinePreservationApi.Repository.MarineSpeciesRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class MarineSpeciesConfig {
    private static List<MarineSpecies> parseResponse(String responseBody) {
        var marineSpeciesBelowTargetPopulation = new ArrayList<MarineSpecies>();
        JSONArray marineSpeciesJsonArray = new JSONArray(responseBody);
        for (int i = 0; i < marineSpeciesJsonArray.length(); i++) {
            try {
                JSONObject marineSpeciesJsonObject = marineSpeciesJsonArray.getJSONObject(i);
                var marineSpecies = new MarineSpecies();
                marineSpecies.setScientificName(marineSpeciesJsonObject.getString("Scientific Name"));
                marineSpecies.setAliases(marineSpeciesJsonObject.getString("Species Name"));
                marineSpecies.setBiology(marineSpeciesJsonObject.getString("Biology"));
                marineSpecies.setPopulation(marineSpeciesJsonObject.getString("Population"));
                marineSpecies.setImageUrl(marineSpeciesJsonObject.getJSONArray("Image Gallery").getJSONObject(0).getString("src"));
                if (marineSpecies.getPopulation().contains("below")) {
                    marineSpeciesBelowTargetPopulation.add(marineSpecies);
                }
            } catch (Exception ignored) {
            }
        }
        return marineSpeciesBelowTargetPopulation;
    }

    @Bean
    CommandLineRunner commandLineRunner(MarineSpeciesRepository marineSpeciesRepository) {
        BufferedReader reader;
        String line;
        StringBuilder responseContent = new StringBuilder();
        try {
            URL url = new URL("https://www.fishwatch.gov/api/species");
            var conn = (HttpURLConnection) url.openConnection();

            // Request setup
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);// 5000 milliseconds = 5 seconds
            conn.setReadTimeout(5000);

            // Test if the response from the server is successful
            int status = conn.getResponseCode();

            if (status >= 300) {
                reader = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            }
            while ((line = reader.readLine()) != null) {
                responseContent.append(line);
            }
            reader.close();
            var marineSpecies = parseResponse(responseContent.toString());
            return args -> marineSpeciesRepository.saveAll(marineSpecies);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
