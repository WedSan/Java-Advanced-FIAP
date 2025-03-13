package com.project.wedsan.JavaCheckpoint4.config;

import com.project.wedsan.JavaCheckpoint4.model.UserEntity;
import com.project.wedsan.JavaCheckpoint4.model.UserRole;
import com.project.wedsan.JavaCheckpoint4.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class InitUser implements CommandLineRunner {

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    public InitUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        boolean userExists = userRepository.existsByEmail("admin@thesystem.com");
        if(!userExists){
            UserEntity admin = new UserEntity(
                null,
                "admin",
                "admin@thesystem.com",
                passwordEncoder.encode("securitypassword"),
                UserRole.ADMIN
            );
            userRepository.save(admin);
        }
    }
}
