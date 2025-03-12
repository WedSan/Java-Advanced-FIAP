package com.project.wedsan.JavaCheckpoint4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSec) throws Exception {
        httpSec.authorizeHttpRequests(auth -> {
            auth.requestMatchers("/admin").hasRole("ADMIN");
            auth.anyRequest().permitAll();
        })
        .formLogin(
            form -> form
            .loginPage("/login")
            .defaultSuccessUrl("/", true)
            .permitAll()
        ).exceptionHandling(exception -> exception.accessDeniedPage("/access-denied"));

        return httpSec.build();
    }

    @Bean
    public PasswordEncoder getPasswordEncode(){
        return new BCryptPasswordEncoder();
    }
}
