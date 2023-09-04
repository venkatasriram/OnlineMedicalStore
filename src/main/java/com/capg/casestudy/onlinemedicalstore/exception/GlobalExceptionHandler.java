package com.capg.casestudy.onlinemedicalstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<String> handleUserNotFoundException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = OrderDetailsNotFoundException.class)
    public ResponseEntity<String> handleOrderDetailsNotFoundException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = CartNotFoundException.class)
    public ResponseEntity<String> handleCartNotFoundException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = PaymentNotFoundException.class)
    public ResponseEntity<String> handlePaymentNotFoundException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = StockNotFoundException.class)
    public ResponseEntity<String> handleStockNotFoundException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        return responseEntity;
    }

    @ExceptionHandler(value = SupplierNotFoundException.class)
    public ResponseEntity<String> handleSupplierNotFoundException(Exception e) {
        ResponseEntity<String> responseEntity = new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
