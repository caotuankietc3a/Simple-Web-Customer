package com.hibernate.spring.service;

import java.util.Arrays;
import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/** MyUserDetails */
public class MyUserDetails implements UserDetails {
  private String name;

  public MyUserDetails() {}

  public MyUserDetails(String name) {
    this.name = name;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // TODO Auto-generated method stub
    return Arrays.asList(
        new SimpleGrantedAuthority("ROLE_USER"), new SimpleGrantedAuthority("ROLE_ADMIN"));
  }

  @Override
  public String getPassword() {
    // TODO Auto-generated method stub
    return "password";
  }

  @Override
  public String getUsername() {
    // TODO Auto-generated method stub
    return this.name;
  }

  @Override
  public boolean isAccountNonExpired() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    // TODO Auto-generated method stub
    return true;
  }

  @Override
  public boolean isEnabled() {
    // TODO Auto-generated method stub
    return true;
  }
}
