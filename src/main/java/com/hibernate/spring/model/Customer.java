package com.hibernate.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/** Customer */
@Entity(name = "Customer")
@Table(name = "Customer")
public class Customer {
  @Id
  @Column(name = "id", nullable = false, length = 11, unique = true)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull(message = "is required")
  @Size(min = 5, max = 200, message = "Name must be between 5 and 200 characters long")
  @Column(name = "name", unique = false, nullable = false, length = 45)
  private String name;

  @NotNull(message = "is required")
  @Pattern(
      regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$",
      message = "Please enter valid email. Ex: example@gmail.com")
  @Column(name = "email", unique = true, nullable = false, length = 45)
  private String email;

  public Customer() {}

  public Customer(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return this.id + ": " + this.name + ", " + this.email;
  }
}
