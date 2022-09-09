package com.hibernate.spring.dao;

import com.hibernate.spring.model.User;

/** UserDao */
public interface UserDao {
  public User findByUserName(String name);
}
