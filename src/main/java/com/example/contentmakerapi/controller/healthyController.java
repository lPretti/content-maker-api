package com.example.contentmakerapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class healthyController {

    @GetMapping("/healthy")
    private String healthyTest(){
        return "I'm alive";
    }
}
