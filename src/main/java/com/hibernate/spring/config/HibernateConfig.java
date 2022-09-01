package com.hibernate.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/** HibernateConfig */
@Configuration
@EnableTransactionManagement
public class HibernateConfig {
  @Bean
  public DataSource dataSource() throws Exception {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
    dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/web_customer_tracker");
    dataSource.setUser("student-spring-hibernate");
    dataSource.setPassword("student-spring-hibernate");
    dataSource.setInitialPoolSize(5);
    dataSource.setMinPoolSize(5);
    dataSource.setMaxPoolSize(20);
    dataSource.setMaxIdleTime(30000);
    return dataSource;
  }

  public final Properties hibernateProperties() {
    Properties hibernateProperties = new Properties();
    hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    hibernateProperties.setProperty("hibernate.show_sql", "true");
    return hibernateProperties;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory() throws Exception {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan(
        "com.hibernate.spring.model"); // look for annotated @Entity class to scan
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
  }

  @Bean
  public HibernateTransactionManager hibernateTransactionManager() throws Exception {
    HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
    hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
    return hibernateTransactionManager;
  }
}
