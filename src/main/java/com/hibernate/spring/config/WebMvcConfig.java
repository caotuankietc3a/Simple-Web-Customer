package com.hibernate.spring.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
// import org.springframework.validation.Validator;
// import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/** WebMvcConfig */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.hibernate.spring")
public class WebMvcConfig implements WebMvcConfigurer {
  @Bean(name = "viewResolver")
  public InternalResourceViewResolver viewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/view/");
    resolver.setSuffix(".jsp");
    resolver.setViewClass(JstlView.class);
    return resolver;
  }

  // default name = messageSource
  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource source = new ResourceBundleMessageSource();
    source.setBasename("/resources/messages");
    return source;
  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry
        .addResourceHandler("/resources/**")
        .addResourceLocations("/resources/")
        .setCachePeriod(31556926);
    // registry.addResourceHandler("/img/**").addResourceLocations("/img/").setCachePeriod(31556926);
    // registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
  }
}
