package com.hibernate.spring.controller;

import com.hibernate.spring.dao.CustomerDao;
import com.hibernate.spring.model.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/** CustomerController */
@Controller
@RequestMapping(path = "/customer")
public class CustomerController {
  @Autowired private CustomerDao customerDao;

  @GetMapping("/")
  public String customerHomePage(Model model) {
    List<Customer> customers = customerDao.getCustomers();
    model.addAttribute("customers", customers);
    System.out.println(customers);
    return "list-customers";
  }
}
