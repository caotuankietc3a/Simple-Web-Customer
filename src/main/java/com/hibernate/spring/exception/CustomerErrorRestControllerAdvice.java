package com.hibernate.spring.exception;

import com.hibernate.spring.model.CustomerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/** CustomerErrorRestControllerAdvice */
@RestControllerAdvice
public class CustomerErrorRestControllerAdvice {
  @ExceptionHandler(CustomerNotFoundException.class)
  private ResponseEntity<CustomerResponse> handle(CustomerNotFoundException ex) {
    CustomerResponse error =
        new CustomerResponse(
            HttpStatus.NOT_FOUND.value(), ex.getMessage(), System.currentTimeMillis(), null);
    return new ResponseEntity<CustomerResponse>(error, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(Exception.class)
  private ResponseEntity<CustomerResponse> handle(Exception ex) {
    CustomerResponse error =
        new CustomerResponse(
            HttpStatus.BAD_REQUEST.value(), ex.getMessage(), System.currentTimeMillis(), null);
    return new ResponseEntity<CustomerResponse>(error, HttpStatus.BAD_REQUEST);
  }
}
