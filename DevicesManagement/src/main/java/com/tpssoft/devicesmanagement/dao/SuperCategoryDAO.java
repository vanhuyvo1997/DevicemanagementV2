package com.tpssoft.devicesmanagement.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tpssoft.devicesmanagement.model.Supercategory;

public class SuperCategoryDAO {
	private SessionFactory factory;

	public SuperCategoryDAO() {
		super();
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}


	/* Method to CREATE an employee in the database */
	public Integer addSuperCategory(String name) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer idSuperCategory = null;
		try {
			tx = session.beginTransaction();
			Supercategory superCategory = new Supercategory();
			superCategory.setName(name);
			idSuperCategory = (Integer) session.save(superCategory);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return idSuperCategory;
	}

	@SuppressWarnings("unchecked")
	public List<Supercategory> getAllSuperCategory() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Supercategory> superCategories = null;
		try {
			tx = session.beginTransaction();
			superCategories = session.createQuery("FROM Supercategory").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return superCategories;
	}

	public Supercategory getSuperCategoryById(Integer idSuperCategory) {
		Session session = factory.openSession();
		Transaction tx = null;
		Supercategory superCategory = null;
		try {
			tx = session.beginTransaction();
			superCategory = session.get(Supercategory.class, idSuperCategory);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return superCategory;
	}

	public boolean updateSuperCategory(Integer idSuperCategory, String name) {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean isSuccess = false;
		try {
			tx = session.beginTransaction();
			Supercategory superCategory = session.get(Supercategory.class, idSuperCategory);
			superCategory.setName(name);
			session.update(superCategory);
			tx.commit();
			isSuccess = true;
		} catch (HibernateException e) {
			isSuccess = false;
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isSuccess;
	}

	public boolean deleteSuperCategory(Integer idSuperCategory) {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean isSuccess = false;
		try {
			tx = session.beginTransaction();
			Supercategory superCategory = session.get(Supercategory.class, idSuperCategory);
			session.delete(superCategory);
			tx.commit();
			isSuccess = true;
		} catch (HibernateException e) {
			isSuccess = false;
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isSuccess;
	}

}
