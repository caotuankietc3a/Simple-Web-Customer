package com.hibernate.spring.dao;

import com.hibernate.spring.model.User;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/** UserDaoImp */
@Repository
public class UserDaoImp implements UserDao {
  @Autowired private SessionFactory sessionFactory;

  @Override
  @Transactional
  public User findByUserName(String name) {
    Session session = sessionFactory.getCurrentSession();
    Query<User> query =
        session
            .createQuery("from User where name = :username", User.class)
            .setParameter("username", name);
    return query.uniqueResult();
  }
}
