package com.fiap.checkpoint3.validator;

import com.fiap.checkpoint3.model.Team;
import com.fiap.checkpoint3.model.exception.EntityAlreadyExistsException;
import com.fiap.checkpoint3.repository.TeamRepository;
import org.springframework.stereotype.Component;

@Component
public class TeamEmailValidator implements TeamValidator{

    public TeamRepository teamRepository;

    public TeamEmailValidator(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void validate(Team team) {
        boolean existsByEmail = teamRepository.existsByEmail(team.getEmail());
        if(existsByEmail) {
            throw new EntityAlreadyExistsException("Team already exists by email");
        }
    }
}
