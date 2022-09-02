package com.hibernate.spring.controller;

import com.hibernate.spring.dao.CustomerDao;
import com.hibernate.spring.model.Customer;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/** CustomerController */
@Controller
@RequestMapping(path = "/")
public class CustomerController {
  @Autowired private CustomerDao customerDao;

  @GetMapping("/")
  public String homePage() {
    return "redirect:/customer-list";
  }

  @GetMapping("/customer-list")
  public String customerList(Model model) {
    List<Customer> customers = customerDao.getCustomers();
    model.addAttribute("customers", customers);
    return "list-customer";
  }

  @GetMapping("/customer-form")
  public String customerForm(Model model) {
    model.addAttribute("customer", new Customer());
    model.addAttribute("actionPost", new String("/web-app-demo/save-customer"));
    model.addAttribute("inputVal", new String("Add Customer"));
    return "form-customer";
  }

  @PostMapping("/save-customer")
  public String saveCustomer(
      @Valid @ModelAttribute("customer") Customer customer,
      BindingResult bindingResult,
      Model model) {
    if (bindingResult.hasErrors()) {
      model.addAttribute("inputVal", new String("Add Customer"));
      return "form-customer";
    }
    customerDao.saveCustomer(customer);
    return "redirect:/customer-list";
  }

  @GetMapping("/delete-customer")
  public String deleteCustomer(@RequestParam("customerId") int customerId) {
    customerDao.deleteCustomer(customerId);
    return "redirect:/customer-list";
  }

  @GetMapping("/update-customer")
  public String updateCustomer(@RequestParam("customerId") int customerId, Model model) {
    Customer customer = customerDao.findCustomer(customerId);
    model.addAttribute("customer", customer);
    model.addAttribute("actionPost", new String("/web-app-demo/update-customer-process"));
    model.addAttribute("inputVal", new String("Update Customer"));
    return "form-customer";
  }

  @PostMapping("/update-customer-process")
  public String updateCustomerProcess(
      @Valid @ModelAttribute("customer") Customer customer,
      BindingResult bindingResult,
      Model model) {
    if (bindingResult.hasErrors()) {
      return "form-customer";
    }
    customerDao.updateCustomer(customer);
    return "redirect:/customer-list";
  }
}
