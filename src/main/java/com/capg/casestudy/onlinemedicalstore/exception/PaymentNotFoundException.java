package com.capg.casestudy.onlinemedicalstore.exception;

public class PaymentNotFoundException extends RuntimeException{
    public PaymentNotFoundException(String message) {
        super(message);
    }
}
