package com.tpssoft.devicesmanagement.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tpssoft.devicesmanagement.model.User;

public class UserDAO {
	private static SessionFactory factory;

	public UserDAO() {
		super();
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	

	public User getUserById(String name) {
		Session session = factory.openSession();
		Transaction tx = null;
		User user = null;
		try {
			tx = session.beginTransaction();
			user = session.get(User.class, name);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return user;
	}
}
