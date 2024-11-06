package com.fiap.checkpoint3.mapper;

import com.fiap.checkpoint3.dto.AddRaceTrackDTO;
import com.fiap.checkpoint3.dto.RaceTrackDTO;
import com.fiap.checkpoint3.model.RaceTrack;

public class RaceTrackMapper {

    public static RaceTrack toDomainObj(AddRaceTrackDTO dto){
        return new RaceTrack(
                null,
                dto.name(),
                dto.location()
        );
    }

    public static RaceTrackDTO toDto(RaceTrack domainObj){
        return new RaceTrackDTO(
            domainObj.getId(),
            domainObj.getName(),
            domainObj.getLocation()
        );
    }
}
