package com.example.fishinglicense.service;


import com.example.fishinglicense.config.WeatherApiConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;
    private final WeatherApiConfig weatherApiConfig;

    public WeatherService(RestTemplate restTemplate, WeatherApiConfig weatherApiConfig) {
        this.restTemplate = restTemplate;
        this.weatherApiConfig = weatherApiConfig;
    }

    public Map<String, Object> getWeatherForLocation(String location) {
        String url = UriComponentsBuilder.fromHttpUrl(weatherApiConfig.getApiUrl())
                .queryParam("q", location)
                .queryParam("appid", weatherApiConfig.getApiKey())
                .queryParam("units", "metric")
                .toUriString();

        try {
            return restTemplate.getForObject(url, Map.class);
        } catch (HttpClientErrorException e) {
            throw new RuntimeException("Failed to fetch weather data: " + e.getMessage());
        }
    }
}