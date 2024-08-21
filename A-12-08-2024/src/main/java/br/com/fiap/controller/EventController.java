package br.com.fiap.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/event")
public class EventController {

    @GetMapping
    public ResponseEntity<String> searchEvents(){
        return ResponseEntity.ok("Hello World");
    }
}
