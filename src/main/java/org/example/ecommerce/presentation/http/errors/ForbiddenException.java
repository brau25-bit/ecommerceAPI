package org.example.ecommerce.presentation.http.errors;

public class ForbiddenException extends RuntimeException{
    public ForbiddenException(String message){
        super(message);
    }
}
