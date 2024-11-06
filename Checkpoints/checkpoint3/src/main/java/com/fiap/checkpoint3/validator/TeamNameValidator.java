package com.fiap.checkpoint3.validator;

import com.fiap.checkpoint3.model.Team;
import com.fiap.checkpoint3.model.exception.EntityAlreadyExistsException;
import com.fiap.checkpoint3.repository.TeamRepository;
import org.springframework.stereotype.Component;

@Component
public class TeamNameValidator implements TeamValidator{

    private TeamRepository teamRepository;

    public TeamNameValidator(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void validate(Team team) {
       boolean existsByName = teamRepository.existsByName(team.getName());
       if(existsByName){
           throw new EntityAlreadyExistsException("Team already exists by name");
       }
    }
}
