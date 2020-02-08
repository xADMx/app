package com.example.chess.app.controllers;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerUtils {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MMM-yyyy");

    static Map<String, String> getErrors(BindingResult bindingResult) {
        return bindingResult.getFieldErrors().stream().collect(Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        ));
    }
}
