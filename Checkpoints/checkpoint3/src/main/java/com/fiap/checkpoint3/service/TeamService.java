package com.fiap.checkpoint3.service;

import com.fiap.checkpoint3.dto.AddTeamDTO;
import com.fiap.checkpoint3.dto.TeamDTO;
import com.fiap.checkpoint3.mapper.TeamMapper;
import com.fiap.checkpoint3.model.Team;
import com.fiap.checkpoint3.repository.TeamRepository;
import com.fiap.checkpoint3.validator.TeamValidator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {

    private TeamRepository teamRepository;

    private List<TeamValidator> teamValidatorList;

    public TeamService(TeamRepository teamRepository, List<TeamValidator> teamValidatorList) {
        this.teamRepository = teamRepository;
        this.teamValidatorList = teamValidatorList;
    }

    public TeamDTO createTeam(AddTeamDTO teamDTO) {
      Team team = TeamMapper.toDomainObj(teamDTO);
      teamValidatorList.forEach(teamValidator -> teamValidator.validate(team));
      return TeamMapper.toDTO(teamRepository.save(team));
    }


}
