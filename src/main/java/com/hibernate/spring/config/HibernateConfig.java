package com.hibernate.spring.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/** HibernateConfig */
@Configuration
@EnableTransactionManagement
@PropertySource({"classpath:mysql.properties"})
public class HibernateConfig {
  @Autowired private Environment env;

  @Bean
  public DataSource dataSource() throws Exception {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setDriverClass(env.getProperty("jdbc.driver"));
    dataSource.setJdbcUrl(env.getProperty("jdbc.url"));
    dataSource.setUser(env.getProperty("jdbc.user"));
    dataSource.setPassword(env.getProperty("jdbc.password"));
    dataSource.setInitialPoolSize(this.getIntProperty("connection.pool.initialPoolSize"));
    dataSource.setMinPoolSize(this.getIntProperty("connection.pool.minPoolSize"));
    dataSource.setMaxPoolSize(this.getIntProperty("connection.pool.maxPoolSize"));
    dataSource.setMaxIdleTime(this.getIntProperty("connection.pool.maxIdleTime"));
    return dataSource;
  }

  public final Properties hibernateProperties() {
    Properties hibernateProperties = new Properties();
    hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
    hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
    return hibernateProperties;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory() throws Exception {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan(
        env.getProperty("hibernate.packagesToScan")); // look for annotated @Entity class to scan
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
  }

  @Bean
  public HibernateTransactionManager hibernateTransactionManager() throws Exception {
    HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
    hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
    return hibernateTransactionManager;
  }

  // need a helper method
  // read environment property and convert to int
  private int getIntProperty(String propName) {
    return Integer.parseInt(env.getProperty(propName));
  }
}
