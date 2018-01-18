package com.std.demo.service;

import com.std.demo.client.CountryClient;
import country.wsdl.GetCountriesResponse;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    CountryClient client;

    public String getCountries() {
        GetCountriesResponse countries = client.getCountries();
        return XML.toJSONObject(countries.getGetCountriesResult()).toString();
    }

}
