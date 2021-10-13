/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.weather.controller;

import com.project.weather.model.Weather;
import com.project.weather.service.WeatherService;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author suzy
 */
@RestController
@RequestMapping("/api/weather")
@Slf4j

public class WeatherController {

    @Autowired
    WeatherService weatherService;

    @GetMapping(path = "/findAll/weathers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Weather> findAll() {
        return weatherService.findAll();
    }

    @PostMapping(path = "/save/weather", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity save(@RequestBody Weather weather) {
        Optional<Weather> savedWeather = weatherService.save(weather);
        if (savedWeather.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(savedWeather);
        }
        return ResponseEntity.status(400).body("Can't save weather info");
    }

    @GetMapping(path = "/pull/weatherInfo/byCountryAndCity", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findByCountryAndCity(@RequestParam String country, @RequestParam String cityName) throws IOException {
        Optional<?> findByCountryAndCity = weatherService.findByCountryAndCity(country, cityName);

        if (findByCountryAndCity.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(findByCountryAndCity);
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Something goes wrong");

    }

    @GetMapping(path = "/pull/weatherInfo/byCoord", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity findByCoord() throws IOException {
        Optional<?> findByCoord = weatherService.findByCoord();

        if (findByCoord.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(findByCoord);
        }
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("Something goes wrong");

    }
    
    @DeleteMapping("/deleteAll/weathers")
    public ResponseEntity deleteAll() {
        weatherService.deleteAll();
        return ResponseEntity.status(HttpStatus.OK).body("All weather infos successfullly have been deleted");
    }

}
