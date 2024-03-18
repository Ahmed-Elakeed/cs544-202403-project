package edu.miu.cs.cs544.exception;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = NotFoundException.class)
    public ResponseEntity<String> notFoundExceptionHandler(Exception exception){
        return ResponseEntity.ok(exception.getMessage());
    }
}
