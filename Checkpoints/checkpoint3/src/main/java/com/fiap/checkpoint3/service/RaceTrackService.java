package com.fiap.checkpoint3.service;

import com.fiap.checkpoint3.dto.AddRaceTrackDTO;
import com.fiap.checkpoint3.dto.RaceTrackDTO;
import com.fiap.checkpoint3.mapper.RaceTrackMapper;
import com.fiap.checkpoint3.model.RaceTrack;
import com.fiap.checkpoint3.repository.RaceTrackRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RaceTrackService {

    private RaceTrackRepository raceTrackRepository;

    public RaceTrackService(RaceTrackRepository raceTrackRepository) {
        this.raceTrackRepository = raceTrackRepository;
    }

    public RaceTrackDTO createRaceTrack(AddRaceTrackDTO addRaceTrackDTO) {
        RaceTrack raceTrack = RaceTrackMapper.toDomainObj(addRaceTrackDTO);
        RaceTrack raceTrackSaved = raceTrackRepository.save(raceTrack);
        return RaceTrackMapper.toDto(raceTrackSaved);
    }

    public Page<RaceTrackDTO> getAll(int page, int size) {
        raceTrackRepository.findAll(PageRequest.of(page, size))
                .map(RaceTrackMapper::toDto);
    }
}
