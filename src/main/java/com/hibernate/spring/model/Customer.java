package com.hibernate.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/** Customer */
@Entity()
@Table(
    name = "Customer",
    uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})})
public class Customer {
  @Id
  @Column(name = "id", nullable = false, length = 11, unique = true)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name", unique = false, nullable = true, length = 200)
  private String name;

  @Column(name = "email", unique = true, nullable = false, length = 100)
  private String email;

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
