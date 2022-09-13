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

  @Override
  @Transactional
  public List<Customer> getCustomers() {
    Session session = sessionFactory.getCurrentSession();
    Query<Customer> query = session.createQuery("from Customer", Customer.class);
    List<Customer> customers = query.getResultList();
    return customers;
  }

  @Override
  @Transactional
  public void saveCustomer(Customer customer) {
    Session session = sessionFactory.getCurrentSession();
    session.save(customer);
  }

  @Override
  @Transactional
  public void deleteCustomer(int customerId) {
    Session session = sessionFactory.getCurrentSession();
    Customer customer = session.get(Customer.class, customerId);
    session.delete(customer);
  }

  @Override
  @Transactional
  public Customer findCustomer(int customerId) {
    Session session = sessionFactory.getCurrentSession();
    Customer customer = session.get(Customer.class, customerId);
    return customer;
  }

  @Override
  @Transactional
  public Customer findAndUpdateCustomer(int customerId, Customer newCustomer) {
    Session session = sessionFactory.getCurrentSession();
    Customer customer = session.get(Customer.class, customerId);
    if (customer == null) return null;
    customer.setName(newCustomer.getName());
    customer.setEmail(newCustomer.getEmail());
    return customer;
  }

  @Override
  @Transactional
  public void updateCustomer(Customer customer) {
    Session session = sessionFactory.getCurrentSession();
    session.saveOrUpdate(customer);
  }
}
