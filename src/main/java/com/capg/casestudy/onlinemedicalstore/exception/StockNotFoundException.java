package com.capg.casestudy.onlinemedicalstore.exception;

public class StockNotFoundException extends RuntimeException{
    public StockNotFoundException(String message) {
        super(message);
    }
}
