package com.hibernate.spring.model;

/** CustomerErrorResponse */
public class CustomerResponse extends RestApiResponse {
  private Customer customer;

  public CustomerResponse(int status, String message, long timeStamp, Customer customer) {
    super(status, message, timeStamp);
    this.customer = customer;
  }

  public Customer getCustomer() {
    return this.customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }
}
