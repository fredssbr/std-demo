package com.std.demo.client;

import country.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountryClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

    public GetCountriesResponse getCountries() {
        GetCountries request = new GetCountries();
        log.info("Requesting countries");
        return (GetCountriesResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.webservicex.net/country.asmx", request,
                        new SoapActionCallback("http://www.webserviceX.NET/GetCountries"));
    }

    public GetISOCountryCodeByCountyNameResponse getISOCodeByCountryName(String countryName) {
        GetISOCountryCodeByCountyName request = new GetISOCountryCodeByCountyName();
        request.setCountryName(countryName);
        log.info("Requesting ISO code for " + countryName);
        return (GetISOCountryCodeByCountyNameResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.webservicex.net/country.asmx", request,
                        new SoapActionCallback("http://www.webserviceX.NET/GetISOCountryCodeByCountyName"));

    }

    public GetCurrenciesResponse getCurrencies() {
        GetCurrencies request = new GetCurrencies();
        log.info("Requesting currencies");
        return (GetCurrenciesResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.webservicex.net/country.asmx", request,
                        new SoapActionCallback("http://www.webserviceX.NET/GetCurrencies"));
    }

    public GetCurrencyByCountryResponse getCurrencyByCountry(String countryName) {
        GetCurrencyByCountry request = new GetCurrencyByCountry();
        request.setCountryName(countryName);
        log.info("Requesting currency for " + countryName);
        return (GetCurrencyByCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.webservicex.net/country.asmx", request,
                        new SoapActionCallback("http://www.webserviceX.NET/GetCurrencyByCountry"));
    }

}
