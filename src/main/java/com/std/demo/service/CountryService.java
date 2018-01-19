package com.std.demo.service;

import com.std.demo.client.CountryClient;
import com.std.demo.model.Country;
import country.wsdl.GetCountriesResponse;
import country.wsdl.GetCurrenciesResponse;
import country.wsdl.GetCurrencyByCountryResponse;
import country.wsdl.GetISOCountryCodeByCountyNameResponse;
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

    public String getCurrencyByCountry(Country country) {
        GetCurrencyByCountryResponse currency = client.getCurrencyByCountry(country.getCountryName());
        return XML.toJSONObject(currency.getGetCurrencyByCountryResult()).toString();
    }

    public String getCurrencies() {
        GetCurrenciesResponse currency = client.getCurrencies();
        return XML.toJSONObject(currency.getGetCurrenciesResult()).toString();
    }

    public String getISOCodeByCountryName(Country country) {
        GetISOCountryCodeByCountyNameResponse isoCode = client.getISOCodeByCountryName(country.getCountryName());
        return XML.toJSONObject(isoCode.getGetISOCountryCodeByCountyNameResult()).toString();
    }

}
