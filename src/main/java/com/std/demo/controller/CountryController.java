package com.std.demo.controller;

import com.std.demo.model.Country;
import com.std.demo.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.json.Json;

@RestController
@RequestMapping("/country")
@Api(value="countries", description="Operations pertaining to countries")
public class CountryController {

    @Autowired
    CountryService service;

    @ApiOperation(value = "Gets all the countries", response = String.class)
    @RequestMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public String getCountries(){
        return service.getCountries();
    }

    @ApiOperation(value = "Gets currency by country name", response = String.class)
    @RequestMapping(value = "/currency", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public String getCurrencyByCountry(@RequestBody Country country){
        return service.getCurrencyByCountry(country);
    }

    @ApiOperation(value = "Gets ISO code by country name", response = String.class)
    @RequestMapping(value = "/iso", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public String getISOCodeByCountry(@RequestBody Country country){
        return service.getISOCodeByCountryName(country);
    }

    @ApiOperation(value = "Gets list of currency", response = String.class)
    @RequestMapping(value = "/currencies", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public String getCurrencies(){
        return service.getCurrencies();
    }

}
