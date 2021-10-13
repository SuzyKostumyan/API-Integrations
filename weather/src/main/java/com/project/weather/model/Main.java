/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.weather.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author suzy
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class Main implements Serializable {

    @SerializedName("temp")
    private Double temp;

    @SerializedName("feels_like")
    private Double feelsLike;
    
    @SerializedName("temp_min")
    private Double tempMin;
    
    @SerializedName("temp_max")
    private Double tempMax;
    
    @SerializedName("pressure")
    private Double pressure;
    
    @SerializedName("humidity")
    private Double humidity;
    
}
