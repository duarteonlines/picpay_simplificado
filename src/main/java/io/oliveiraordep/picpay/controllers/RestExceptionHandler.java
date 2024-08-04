package io.oliveiraordep.picpay.controllers;

import io.oliveiraordep.picpay.exceptions.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(StandardError.class)
    public ProblemDetail handleStandardErrorException(StandardError e){
        return e.toProblemDetail();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ProblemDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        var fieldErros = e.getFieldErrors()
                .stream()
                .map(field -> new InvalidParams(field.getField(), field.getDefaultMessage()));
        var pb = ProblemDetail.forStatus(HttpStatus.BAD_REQUEST);
        pb.setTitle("Your request parameters didn't validate");
        pb.setProperty("Invalid Params", fieldErros);
        return pb;
    }

    public record InvalidParams(String name, String message){

    }
}
