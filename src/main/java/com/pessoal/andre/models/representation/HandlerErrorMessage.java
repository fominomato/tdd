package com.pessoal.andre.models.representation;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class HandlerErrorMessage {

    private HttpStatus status;

    private String message;

    private List<String> errors;

    public HandlerErrorMessage(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.errors = errors;
    }
}