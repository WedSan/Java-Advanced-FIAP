package com.project.wedsan.JavaCheckpoint4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthController {

    @GetMapping
    public String getLoginPage(){
        return "login";
    }
}
