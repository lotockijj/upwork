package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home"; // home.html in templates
    }

    @GetMapping("/healthy")
    public String healthCheck() {
        return "healthy"; // home.html in templates
    }
}
