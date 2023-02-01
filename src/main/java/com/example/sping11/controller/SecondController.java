package com.example.sping11.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guest")
public class SecondController {

    @GetMapping()
    public String returnPost(){
        return "Sevdiyor, Firdavs va Anvarjon";
    }
}
