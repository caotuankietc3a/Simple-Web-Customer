package com.hibernate.spring.dao;

import com.hibernate.spring.model.Customer;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository // use for DAO implementations (auto-scan) and  automatically handle exceptions of JDBC
public class CustomerDaoImpl implements CustomerDao {
  @Autowired private SessionFactory sessionFactory;

  @Transactional
  @Override
  public List<Customer> getCustomers() {
    Session session = sessionFactory.getCurrentSession();
    Query<Customer> query = session.createQuery("from Customer", Customer.class);
    List<Customer> customers = query.getResultList();
    return customers;
  }
}
