package com.capg.casestudy.onlinemedicalstore.exception;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(String message) {
        super(message);
    }
}
