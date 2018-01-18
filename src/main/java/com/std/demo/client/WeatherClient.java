package com.std.demo.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import weather.wsdl.GetCitiesByCountry;
import weather.wsdl.GetCitiesByCountryResponse;

public class WeatherClient extends WebServiceGatewaySupport{

    private static final Logger log = LoggerFactory.getLogger(WeatherClient.class);

    public GetCitiesByCountryResponse getCitiesByCountry(String countryName) {
        GetCitiesByCountry request = new GetCitiesByCountry();
        request.setCountryName(countryName);
        log.info("Requesting cities for " + countryName);
        GetCitiesByCountryResponse response = (GetCitiesByCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.webservicex.net/globalweather.asmx", request,
                        new SoapActionCallback("http://www.webserviceX.NET/GetCitiesByCountry"));
        return response;
    }

}
