package com.kgma.springboot_boilerplate.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HelloController {

    @GetMapping("/")
    public String hi(){
        return new String("hello");
    }
}
