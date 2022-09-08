package com.hibernate.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/** SecurityConfigure */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
  //////////////////////// Old Version /////////////////////

  @Autowired UserDetailsService userDetailsService;

  // @Override
  // protected void configure(HttpSecurity http) throws Exception {
  //   http.authorizeRequests()
  //       .antMatchers("/admin")
  //       .hasRole("ADMIN")
  //       .antMatchers("/**")
  //       .hasRole("USER")
  //       .and()
  //       .formLogin();
  // }

  // @Override
  // protected void configure(AuthenticationManagerBuilder auth) throws Exception {
  //   auth.userDetailsService(this.userDetailsService);
  // }

  // Need PasswordEncoder otherwise throw IllegalArgumentException error
  @Bean
  public PasswordEncoder getPasswordEncoder() {
    return NoOpPasswordEncoder.getInstance();
  }

  // @Bean
  // public InMemoryUserDetailsManager userDetailsManager() {
  //
  // }

  /////////// New Version ////////////////
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeHttpRequests()
        .antMatchers("/**")
        .hasRole("USER")
        .antMatchers("/admin/**")
        .hasRole("ADMIN")
        .and()
        .formLogin();
    return http.build();
  }

  // @Bean
  // public WebSecurityCustomizer webSecurityCustomizer() {
  //   return (web) -> web.ignoring().antMatchers("/images/**", "/js/**");
  // }

  // @Bean
  // public UserDetailsService userDetailsService() {
  //   UserDetails user =
  //       User.withDefaultPasswordEncoder()
  //           .username("user")
  //           .password("password")
  //           .roles("USER")
  //           .build();
  //   UserDetails admin =
  //       User.withDefaultPasswordEncoder()
  //           .username("admin")
  //           .password("password")
  //           .roles("ADMIN", "USER")
  //           .build();
  //   return new InMemoryUserDetailsManager(user, admin);
  // }
}
