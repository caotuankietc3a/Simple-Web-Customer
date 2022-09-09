package com.hibernate.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/** User */
@Entity
@Table(name = "User")
public class User {
  @Id
  @Column(name = "id", nullable = false, length = 11, unique = true)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @NotNull
  @Size(max = 45, min = 5, message = "Please enter a name with 5 minimum chars and max 45 chars")
  @Column(name = "name", unique = true, nullable = false, length = 45)
  private String name;

  @NotNull
  @Column(name = "password", unique = false, nullable = false, length = 64)
  private String password;

  private boolean active;
  private String roles;

  public User() {}

  public User(String name, String password) {
    this.name = name;
    this.password = password;
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

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public boolean isActive() {
    return this.active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public String getRoles() {
    return this.roles;
  }

  public void setRoles(String roles) {
    this.roles = roles;
  }
}
