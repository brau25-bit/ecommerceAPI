package org.example.ecommerce.presentation.http.errors;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
