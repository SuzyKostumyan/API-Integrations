/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.weather.model;

import com.google.gson.annotations.Expose;
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

public class WeatherDTOMain implements Serializable {

    @SerializedName("latitude")
    @Expose
    private Double latitude;

    @SerializedName("longitude")
    @Expose
    private Double longitude;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("number")
    @Expose
    private String number;

    @SerializedName("postal_code")
    @Expose
    private String postalCode;

    @SerializedName("street")
    @Expose
    private String street;

    @SerializedName("confidence")
    @Expose
    private Double confidence;

    @SerializedName("region")
    @Expose
    private String region;

    @SerializedName("region_code")
    @Expose
    private String regionCode;

    @SerializedName("county")
    @Expose
    private String county = null;

    @SerializedName("locality")
    @Expose
    private String locality = null;

    @SerializedName("administrative_area")
    @Expose
    private String administrativeArea = null;

    @SerializedName("neighbourhood")
    @Expose
    private String neighbourhood = null;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("country_code")
    @Expose
    private String countryCode;

    @SerializedName("continent")
    @Expose
    private String continent;
    
    @SerializedName("label")
    @Expose
    private String label;
    

}
