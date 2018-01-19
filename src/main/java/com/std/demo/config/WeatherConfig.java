package com.std.demo.config;

import com.std.demo.client.CountryClient;
import com.std.demo.client.WeatherClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WeatherConfig {
    @Bean
    public WeatherClient weatherClient() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified
        // in pom.xml
        marshaller.setContextPath("weather.wsdl");
        WeatherClient client = new WeatherClient();
        client.setDefaultUri("http://www.webservicex.net/globalweather.asmx");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
