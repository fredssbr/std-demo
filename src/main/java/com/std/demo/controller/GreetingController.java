package com.std.demo.controller;

import com.std.demo.model.Greeting;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greeting")
@Api(value="greetings", description="A greeting operation")
public class GreetingController {

    @ApiOperation(value = "Shows a greeting message.", response = String.class)
    @RequestMapping(method = RequestMethod.GET)
    public Greeting greeting() {
        return new Greeting("Greetings from Planet Earth!");
    }

}
