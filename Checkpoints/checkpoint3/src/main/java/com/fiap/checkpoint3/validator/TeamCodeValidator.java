package com.fiap.checkpoint3.validator;

import com.fiap.checkpoint3.model.Team;
import com.fiap.checkpoint3.model.exception.EntityAlreadyExistsException;
import com.fiap.checkpoint3.repository.TeamRepository;
import org.springframework.stereotype.Component;

@Component
public class TeamCodeValidator implements TeamValidator {

    private TeamRepository teamRepository;

    public TeamCodeValidator(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void validate(Team team) {
        boolean teamExists = teamRepository.existsByCode(team.getCode());
        if(teamExists) {
            throw new EntityAlreadyExistsException("Team already exists by code");
        }
    }
}
