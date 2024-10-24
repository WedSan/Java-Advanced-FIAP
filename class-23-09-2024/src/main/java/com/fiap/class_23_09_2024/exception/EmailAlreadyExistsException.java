package com.fiap.class_23_09_2024.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT, reason = "Email already registered")
public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException() {
    }

}
