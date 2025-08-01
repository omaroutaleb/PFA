package com.example.pfa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/")
    public String index() {
        return "Hello PFA ";
    }
    @GetMapping("/hello")
        public String hello() {
        return " PFA ";
        }
}
