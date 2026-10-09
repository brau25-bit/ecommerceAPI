package org.example.ecommerce.presentation.http.errors.ExeptionHandler;

import org.example.ecommerce.domain.DTO.responses.error.ExceptionResponse;
import org.example.ecommerce.presentation.http.errors.BadRequestException;
import org.example.ecommerce.presentation.http.errors.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleNotFound(
            NotFoundException notFoundException
    ){
        ExceptionResponse response = new ExceptionResponse(
                404,
                notFoundException.getMessage(),
                Instant.now(),
                Map.of()
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequest(
            BadRequestException badRequestException
    ){
        ExceptionResponse response = new ExceptionResponse(
                400,
                badRequestException.getMessage(),
                Instant.now(),
                Map.of()
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
