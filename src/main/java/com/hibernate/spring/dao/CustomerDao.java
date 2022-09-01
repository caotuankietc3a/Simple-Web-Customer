package com.hibernate.spring.dao;

import java.util.List;

import com.hibernate.spring.model.Customer;

/**
 * CustomerDAO
 */
public interface CustomerDao {
  public List<Customer> getCustomers();
}
