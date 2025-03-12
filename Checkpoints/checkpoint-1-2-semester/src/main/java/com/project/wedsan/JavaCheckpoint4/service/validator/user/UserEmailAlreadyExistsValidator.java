package com.project.wedsan.JavaCheckpoint4.service.validator.user;

import com.project.wedsan.JavaCheckpoint4.controller.dto.CreateUserReq;
import com.project.wedsan.JavaCheckpoint4.exception.UserEmailAlreadyExistsException;
import com.project.wedsan.JavaCheckpoint4.repository.UserRepository;
import org.springframework.stereotype.Component;

@Component
public class UserEmailAlreadyExistsValidator implements UserValidator{

    private UserRepository userRepository;

    public UserEmailAlreadyExistsValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void validate(CreateUserReq createUserReq) {
        boolean emailAlradyExists = userRepository.existsByEmail(createUserReq.getEmail());
        if(emailAlradyExists){
            throw new UserEmailAlreadyExistsException();
        }
    }
}
