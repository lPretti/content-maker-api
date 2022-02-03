package com.example.contentmakerapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    private String healthTest(){
        return "I'm alive";
    }
}
