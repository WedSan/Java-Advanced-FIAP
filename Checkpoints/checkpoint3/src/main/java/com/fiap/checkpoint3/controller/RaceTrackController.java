package com.fiap.checkpoint3.controller;

import com.fiap.checkpoint3.dto.AddRaceTrackDTO;
import com.fiap.checkpoint3.dto.RaceTrackDTO;
import com.fiap.checkpoint3.service.RaceTrackService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController("race-track")
public class RaceTrackController {

    private RaceTrackService raceTrackService;

    public RaceTrackController(RaceTrackService raceTrackService) {
        this.raceTrackService = raceTrackService;
    }

    //admin
    @PostMapping
    public ResponseEntity<RaceTrackDTO> createRaceTrack(@RequestBody @Validated AddRaceTrackDTO dto){
        RaceTrackDTO response = raceTrackService.createRaceTrack(dto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<RaceTrackDTO>> getAllRaceTrack(@RequestParam int page,
                                                              @RequestParam int size){
        Page<RaceTrackDTO> raceTrackDTOPage = raceTrackService.getAll(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(raceTrackDTOPage);
    }
}
