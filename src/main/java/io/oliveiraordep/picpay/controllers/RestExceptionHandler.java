package io.oliveiraordep.picpay.controllers;

import io.oliveiraordep.picpay.exceptions.StandardError;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(StandardError.class)
    public ProblemDetail handleStandardErrorException(StandardError e){
        return e.toProblemDetail();
    }
}
