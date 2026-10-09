package org.example.ecommerce.presentation.http.errors;

public class PaymentRequiredException extends RuntimeException{
    public PaymentRequiredException(String message){
        super(message);
    }
}
