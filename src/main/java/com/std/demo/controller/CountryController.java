package com.std.demo.controller;

import com.std.demo.service.CountryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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

}
