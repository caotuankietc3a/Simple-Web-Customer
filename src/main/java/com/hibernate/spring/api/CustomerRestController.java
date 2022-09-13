package com.hibernate.spring.api;

import com.hibernate.spring.dao.CustomerDao;
import com.hibernate.spring.exception.CustomerNotFoundException;
import com.hibernate.spring.model.Customer;
import com.hibernate.spring.model.CustomerResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** CustomerRestController */
@RestController
@RequestMapping("/api")
public class CustomerRestController {
  @Autowired private CustomerDao customerDao;

  @GetMapping("/customers")
  private List<Customer> getCustomers() {
    return customerDao.getCustomers();
  }

  @GetMapping("/customers/{customerId}")
  private ResponseEntity<CustomerResponse> getCustomer(@PathVariable int customerId)
      throws Exception {
    Customer customer = this.customerDao.findCustomer(customerId);
    if (customer == null)
      throw new CustomerNotFoundException("Not found customer with id: " + customerId);
    return new ResponseEntity<CustomerResponse>(
        new CustomerResponse(
            HttpStatus.OK.value(),
            "Customer id: " + customerId,
            System.currentTimeMillis(),
            customer),
        HttpStatus.OK);
  }

  @DeleteMapping("/customers/{customerId}")
  private ResponseEntity<CustomerResponse> deleteCustomer(@PathVariable int customerId)
      throws Exception {
    Customer customer = this.customerDao.findCustomer(customerId);
    if (customer == null)
      throw new CustomerNotFoundException("Not found customer with id: " + customerId);
    this.customerDao.deleteCustomer(customerId);
    return new ResponseEntity<CustomerResponse>(
        new CustomerResponse(
            HttpStatus.OK.value(),
            "Delete customer id: " + customerId + " sucessfully!!!",
            System.currentTimeMillis(),
            customer),
        HttpStatus.OK);
  }

  @PostMapping("/customers/new-customer")
  private ResponseEntity<CustomerResponse> createCustomer(@RequestBody Customer customer)
      throws Exception {
    if (customer.getName() == null) throw new Exception("Missing customer name!!!");
    if (customer.getEmail() == null) throw new Exception("Missing customer email!!!");
    customerDao.saveCustomer(customer);
    return new ResponseEntity<CustomerResponse>(
        new CustomerResponse(
            HttpStatus.OK.value(),
            "Create new customer sucessfully!!!",
            System.currentTimeMillis(),
            customer),
        HttpStatus.OK);
  }

  @PutMapping("/customers/{customerId}")
  private ResponseEntity<CustomerResponse> updateCustomer(
      @PathVariable int customerId, @RequestBody Customer newCustomer) throws Exception {
    if (newCustomer.getName() == null) throw new Exception("Missing customer name!!!");
    if (newCustomer.getEmail() == null) throw new Exception("Missing customer email!!!");
    Customer customer = this.customerDao.findAndUpdateCustomer(customerId, newCustomer);
    if (customer == null)
      throw new CustomerNotFoundException("Not found customer with id: " + customerId);

    return new ResponseEntity<CustomerResponse>(
        new CustomerResponse(
            HttpStatus.OK.value(),
            "Update customer sucessfully!!!",
            System.currentTimeMillis(),
            customer),
        HttpStatus.OK);
  }
}
