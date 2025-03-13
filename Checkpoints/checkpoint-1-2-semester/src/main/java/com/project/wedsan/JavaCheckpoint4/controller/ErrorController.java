package com.project.wedsan.JavaCheckpoint4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController {

    @GetMapping("/access-denied")
    public String getAccessDeniedPage(){
        return "access-denied";
    }

    @GetMapping("/admin")
    public String getAccessAdminPage(){
        return "admin";
    }
}
