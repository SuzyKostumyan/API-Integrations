/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.weather.repository;

import com.project.weather.model.WeatherDTO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author suzy
 */

@Repository
public interface WeatherDTORepository extends MongoRepository<WeatherDTO, String> {
    
}
