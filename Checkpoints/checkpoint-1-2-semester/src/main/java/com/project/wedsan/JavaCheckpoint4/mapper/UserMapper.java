package com.project.wedsan.JavaCheckpoint4.mapper;

import com.project.wedsan.JavaCheckpoint4.controller.dto.CreateUserReq;
import com.project.wedsan.JavaCheckpoint4.model.UserEntity;
import com.project.wedsan.JavaCheckpoint4.model.UserRole;

public class UserMapper {

    public static UserEntity transformDTOToDomainObj(CreateUserReq userReq){
        return new UserEntity(
                null,
                userReq.getName(),
                userReq.getEmail(),
                userReq.getPassword(),
                UserRole.USER
        );
    }
}
