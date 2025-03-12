package com.project.wedsan.JavaCheckpoint4.service;

import com.project.wedsan.JavaCheckpoint4.controller.dto.CreateUserReq;
import com.project.wedsan.JavaCheckpoint4.mapper.UserMapper;
import com.project.wedsan.JavaCheckpoint4.model.UserEntity;
import com.project.wedsan.JavaCheckpoint4.repository.UserRepository;
import com.project.wedsan.JavaCheckpoint4.service.validator.user.UserValidator;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private UserRepository userRepository;

    private List<UserValidator> validators;

    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, List<UserValidator> validators, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.validators = validators;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(CreateUserReq createUserReq){
        validators.forEach(v -> v.validate(createUserReq));
        UserEntity user = UserMapper.transformDTOToDomainObj(createUserReq);
        String passwordEncoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> userEntityFound = userRepository.findUserByEmail(username);
        if(userEntityFound.isEmpty()){
            throw new UsernameNotFoundException("");
        }
        return userEntityFound.get();
    }
}
