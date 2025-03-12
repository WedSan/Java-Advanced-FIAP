package com.project.wedsan.JavaCheckpoint4.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CreateUserReq {

    @NotEmpty(message = "{register.error.username.invalid}")
    @Size(min = 2, max = 32, message = "{register.error.name.length}")
    private String name;

    @Email(message = "{register.error.email.invalid}")
    private String email;

    @NotEmpty(message = "{register.error.password.invalid}")
    @Size(min = 8, max = 64, message = "{register.error.password.length}")
    private String password;

    public CreateUserReq() {
    }

    public CreateUserReq(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
