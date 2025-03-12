package com.project.wedsan.JavaCheckpoint4.service.validator.user;

import com.project.wedsan.JavaCheckpoint4.controller.dto.CreateUserReq;

public interface UserValidator {

    void validate(CreateUserReq createUserReq);
}
