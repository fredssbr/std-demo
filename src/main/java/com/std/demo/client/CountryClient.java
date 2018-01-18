package com.std.demo.client;

import country.wsdl.GetCountries;
import country.wsdl.GetCountriesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CountryClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CountryClient.class);

    public GetCountriesResponse getCountries() {
        GetCountries request = new GetCountries();
        log.info("Requesting countries");
        GetCountriesResponse response = (GetCountriesResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.webservicex.net/country.asmx", request,
                        new SoapActionCallback("http://www.webserviceX.NET/GetCountries"));
        return response;
    }

}
