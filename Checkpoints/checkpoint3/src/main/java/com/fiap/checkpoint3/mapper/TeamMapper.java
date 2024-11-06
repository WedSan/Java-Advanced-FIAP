package com.fiap.checkpoint3.mapper;

import com.fiap.checkpoint3.dto.AddTeamDTO;
import com.fiap.checkpoint3.dto.TeamDTO;
import com.fiap.checkpoint3.model.Team;

public class TeamMapper {

    public static Team toDomainObj(AddTeamDTO teamDTO){
        return new Team(
                null,
                teamDTO.name(),
                teamDTO.email(),
                teamDTO.code()
        );
    }

    public static Team toDomainObj(TeamDTO teamDTO){
        return new Team(
                teamDTO.id(),
                teamDTO.name(),
                teamDTO.email(),
                teamDTO.code()
        );
    }

    public static TeamDTO toDTO(Team team){
        return new TeamDTO(
                team.getId(),
                team.getName(),
                team.getEmail(),
                team.getCode()
        );
    }
}
