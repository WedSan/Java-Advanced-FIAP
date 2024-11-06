package com.fiap.checkpoint3.controller;

import com.fiap.checkpoint3.dto.AddTeamDTO;
import com.fiap.checkpoint3.dto.TeamDTO;
import com.fiap.checkpoint3.dto.TestReservationDTO;
import com.fiap.checkpoint3.service.TeamService;
import com.fiap.checkpoint3.service.TestReservationService;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("team")
public class TeamController {

    private TeamService teamService;

    private TestReservationService testReservationService;

    @PostMapping
    public ResponseEntity<TeamDTO> createTeam(@RequestBody @Validated AddTeamDTO teamDTO) {
        TeamDTO response = teamService.createTeam(teamDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("{id};")
    public ResponseEntity<Page<TestReservationDTO>> getAllTeamsByReservation() {

    }

}
