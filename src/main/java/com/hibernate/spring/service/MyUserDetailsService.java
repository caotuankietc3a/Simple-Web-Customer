package com.hibernate.spring.service;

import com.hibernate.spring.dao.UserDao;
import com.hibernate.spring.model.MyUserDetails;
import com.hibernate.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/** MyUserDetailsService */
@Service
public class MyUserDetailsService implements UserDetailsService {
  @Autowired private UserDao userDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userDao.findByUserName(username);
    if (user == null) throw new UsernameNotFoundException("Not found: " + username);
    return new MyUserDetails(user);
  }
}
