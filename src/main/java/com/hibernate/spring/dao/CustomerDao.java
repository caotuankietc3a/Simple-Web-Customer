package com.hibernate.spring.dao;

import com.hibernate.spring.model.Customer;
import java.util.List;

/** CustomerDAO */
public interface CustomerDao {
  public List<Customer> getCustomers();

  public void saveCustomer(Customer customer);

  public void updateCustomer(Customer customer);

  public void deleteCustomer(int customerId);

  public Customer findCustomer(int customerId);

  public Customer findAndUpdateCustomer(int customerId, Customer newCustomer);
}
