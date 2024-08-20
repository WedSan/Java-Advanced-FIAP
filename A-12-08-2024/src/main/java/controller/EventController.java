package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/event")
public class EventController {

    @GetMapping
    public ResponseEntity<String> searchEvents(){
        return ResponseEntity.ok("Hello World");
    }
}
