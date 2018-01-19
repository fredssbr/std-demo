package com.std.demo.service;

import com.std.demo.client.WeatherClient;
import com.std.demo.model.Country;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weather.wsdl.GetCitiesByCountryResponse;

@Service
public class WeatherService {

    @Autowired
    WeatherClient client;

    public String getCitiesByCountry(Country country) {
        GetCitiesByCountryResponse cities =  client.getCitiesByCountry(country.getCountryName());
        return XML.toJSONObject(cities.getGetCitiesByCountryResult()).toString();
    }

}
