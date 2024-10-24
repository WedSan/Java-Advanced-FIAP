package com.fiap.class_23_09_2024.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.ACCEPTED, reason = "Document already registered")
public class DocumentAlreadyExistsException extends RuntimeException{
    public DocumentAlreadyExistsException() {
    }
}
