package com.vishwa.restannotations.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // HTTP GET Request
    @GetMapping("/hello-world")
    public String helloWorld(){
        return "Hello World";
    }
}
