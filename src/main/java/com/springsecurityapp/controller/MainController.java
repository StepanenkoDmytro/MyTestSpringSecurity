package com.springsecurityapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/api/v1")
public class MainController {

    @GetMapping
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }
}
