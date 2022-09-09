package com.hibernate.spring.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/** test */
public class test {
  public static void main(String[] args) {
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    String encodedPassword = encoder.encode("creator");
    System.out.println(encodedPassword);
  }
}
