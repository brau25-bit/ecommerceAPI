package org.example.ecommerce.presentation.http.errors;

public class InternalServerError extends RuntimeException{
    public InternalServerError(String message){
        super(message);
    }
}
