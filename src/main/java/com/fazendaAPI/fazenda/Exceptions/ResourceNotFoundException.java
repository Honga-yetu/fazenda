package com.fazendaAPI.fazenda.Exceptions;

import org.springframework.web.bind.annotation.*;
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }

    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
