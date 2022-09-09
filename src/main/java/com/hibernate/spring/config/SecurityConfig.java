package com.hibernate.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/** SecurityConfigure */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired private UserDetailsService userDetailsService;
  //////////////////////// Old Version /////////////////////
  // @Override
  // protected void configure(HttpSecurity http) throws Exception {
  // http.authorizeRequests()
  // .antMatchers("/admin")
  // .hasRole("ADMIN")
  // .antMatchers("/**")
  // .hasRole("USER")
  // .and()
  // .formLogin();
  // }

  // @Override
  // protected void configure(AuthenticationManagerBuilder auth) throws Exception
  // {
  // auth.userDetailsService(this.userDetailsService);
  // }

  // Need PasswordEncoder otherwise throw IllegalArgumentException error
  @Bean
  public PasswordEncoder getPasswordEncoder() {
    // return NoOpPasswordEncoder.getInstance();
    return new BCryptPasswordEncoder();
  }

  /////////// New Version ////////////////
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // http.authorizeHttpRequests()
    // .antMatchers("/admin/**")
    // .hasRole("ADMIN")
    // .antMatchers("/**")
    // .hasRole("USER")

    http.authorizeRequests()
        .antMatchers("/admin")
        .hasRole("ADMIN")
        .antMatchers("/customer/customer-form")
        // .hasAnyAuthority("ADMIN", "CREATOR")
        .hasAnyRole("ADMIN", "CREATOR")
        .antMatchers("/customer/update-customer")
        // .hasAnyAuthority("ADMIN", "EDITOR")
        .hasAnyRole("ADMIN", "EDITOR")
        .antMatchers("/customer/delete-customer")
        // .hasAnyAuthority("ADMIN")
        .hasAnyRole("ADMIN")
        .antMatchers("/")
        .hasAnyRole("USER", "ADMIN", "CREATOR", "EDITOR")
        .and()
        .formLogin()
        .and()
        .exceptionHandling()
        .accessDeniedPage("/access-denied-403");
    return http.build();
  }
}
