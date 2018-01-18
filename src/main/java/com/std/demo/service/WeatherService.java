package com.std.demo.service;

import com.std.demo.client.WeatherClient;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weather.wsdl.GetCitiesByCountryResponse;

@Service
public class WeatherService {

    @Autowired
    WeatherClient client;

    public String getCitiesByCountry(String countryName) {
        GetCitiesByCountryResponse cities =  client.getCitiesByCountry(countryName);
        return XML.toJSONObject(cities.getGetCitiesByCountryResult()).toString();
    }

}
