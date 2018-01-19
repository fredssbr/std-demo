package com.std.demo.controller;

import com.std.demo.model.Country;
import com.std.demo.service.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(value="countries", description="Operations pertaining to weather")
@RequestMapping(value = "/weather")
public class WeatherController {

    @Autowired
    WeatherService service;

    @ApiOperation(value = "Gets a list of cities by country.", response = String.class)
    @RequestMapping(value = "/citiesByCountry", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public String getCitiesByCountry(@RequestBody Country country){
        return service.getCitiesByCountry(country);
    }
}
