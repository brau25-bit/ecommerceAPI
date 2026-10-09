package org.example.ecommerce.presentation.http.errors;

public class RequestTimeoutException extends RuntimeException{
    public RequestTimeoutException(String message){
        super(message);
    }
}
