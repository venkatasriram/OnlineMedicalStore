package com.capg.casestudy.onlinemedicalstore.exception;

public class OrderDetailsNotFoundException extends RuntimeException{
    public OrderDetailsNotFoundException(String message) {
        super(message);
    }
}
