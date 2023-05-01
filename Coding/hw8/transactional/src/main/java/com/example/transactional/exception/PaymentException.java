package com.example.transactional.exception;

public class PaymentException extends RuntimeException {
    public PaymentException(String message){
        super(message);
    }
}
