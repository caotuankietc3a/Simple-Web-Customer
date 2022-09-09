package com.hibernate.spring.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

/** LoginController */
@Controller
@RequestMapping(path = "/")
public class LoginController {
  @InitBinder
  public void initBinder(WebDataBinder webDataBinder) {
    StringTrimmerEditor stringTrimmerEditor =
        new StringTrimmerEditor(true); // true means trim data to null if it has white space
    webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
  }

  // @GetMapping("/")
  // public String homePage(@AuthenticationPrincipal MyUserDetails myUserDetails) {
  //   System.out.println(myUserDetails.getUsername());
  //   if (myUserDetails.getAuthorities().stream()
  //       .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) return "admin";
  //   // if (myUserDetails.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
  //   //   return "admin";
  //   // }
  //   return "redirect:/customer-list";
  // }

  @GetMapping("/")
  public String homePage() {
    return "redirect:/customer/customer-list";
  }

  @GetMapping("/admin")
  public String adminPage() {
    return "admin";
  }

  @GetMapping("/access-denied-403")
  public String accessDenied403() {
    return "403";
  }
}
