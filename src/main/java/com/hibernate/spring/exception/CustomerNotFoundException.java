package com.hibernate.spring.exception;

/** CustomerNotFoundException */
public class CustomerNotFoundException extends RuntimeException {
  public CustomerNotFoundException(String message) {
    super(message);
  }
}
