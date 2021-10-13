/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.weather.service;

import com.google.gson.Gson;
import com.project.weather.model.Weather;
import com.project.weather.model.WeatherDTO;
import com.project.weather.repository.WeatherDTORepository;
import com.project.weather.repository.WeatherRepository;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author suzy
 */
@Service
@Slf4j
public class WeatherService {

    Double lat;
    Double lon;

    @Autowired
    private WeatherRepository weatherRepository;
    @Autowired
    private WeatherDTORepository weatherDTORepository;


    public List<Weather> findAll() {
        return weatherRepository.findAll();
    }

    public Optional<Weather> save(Weather weather) {
        Weather savedWeather = weatherRepository.save(weather);
        return Optional.ofNullable(savedWeather);
    }


    public Optional<?> findByCountryAndCity(String country, String cityName) throws MalformedURLException, IOException {
        log.info("FInd by country and city name");

        URL url = new URL("http://api.positionstack.com/v1/forward?access_key=b1e2295ac27998985d95b918a55ecdc3&query="+country+"%20"+cityName);

        log.info("url is " + url);
        
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        Gson gson = new Gson();
        WeatherDTO weather = gson.fromJson(content.toString(), WeatherDTO.class);
        final WeatherDTO savedWeather = weatherDTORepository.save(weather);

        in.close();
        con.disconnect();

        lat = savedWeather.getData().get(0).getLatitude();
        lon = savedWeather.getData().get(0).getLongitude();

        return Optional.ofNullable(savedWeather);
        
    }


    public Optional<?> findByCoord() throws MalformedURLException, IOException {
        log.info("Find object with coords from findByCountryAndCitiy");

        URL url = new URL("https://api.openweathermap.org/data/2.5/weather" + "?lat=" + lat + "&" + "lon=" + lon + "&appid=ecaab3ed209401f9c8ae66abcd392a7b");

        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        Gson gson = new Gson();
        Weather weather = gson.fromJson(content.toString(), Weather.class);
        final Weather savedWeatherByCoord = weatherRepository.save(weather);

        in.close();
        con.disconnect();

        return Optional.ofNullable(savedWeatherByCoord);

    }
    
    public void deleteAll() {
        weatherRepository.deleteAll();
    }

}
