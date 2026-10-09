package org.example.ecommerce.presentation.http.errors;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}
