package com.myboilerplate.myboilerplate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<CustomErrorResponse> customHandleNumberFormat(Exception ex, WebRequest request) {

        CustomErrorResponse errors = new CustomErrorResponse();
        errors.setTimestamp(LocalDateTime.now());
        errors.setError("Wrong number!");
        errors.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
