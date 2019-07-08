package com.tpssoft.devicesmanagement.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tpssoft.devicesmanagement.model.Subcategory;
import com.tpssoft.devicesmanagement.model.Supercategory;


public class SubCategoryDAO {
	private static SessionFactory factory;

	public SubCategoryDAO() {
		super();
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}


	public Integer addSubCategory(Supercategory superCategory, String name) {
		Session session = factory.openSession();
		Transaction tx = null;
		Integer idSubCategory = null;
		try {
			tx = session.beginTransaction();
			Subcategory subCategory = new Subcategory();
			subCategory.setName(name);
			subCategory.setSupercategory(superCategory);
			idSubCategory = (Integer) session.save(subCategory);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return idSubCategory;
	}

	@SuppressWarnings("unchecked")
	public List<Subcategory> getAllSubCategory() {
		Session session = factory.openSession();
		Transaction tx = null;
		List<Subcategory> subCategories = null;
		try {
			tx = session.beginTransaction();
			subCategories = session.createQuery("FROM Subcategory").list();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return subCategories;
	}

	public Supercategory getOneSuperCategory(Integer idSuperCategory) {
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

	public boolean updateSubCategory(Supercategory superCategory, Integer idSubCategory, String name) {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean isSuccess = false;
		try {
			tx = session.beginTransaction();
			Subcategory subCategory = session.get(Subcategory.class, idSubCategory);
			subCategory.setName(name);
			subCategory.setSupercategory(superCategory);
			session.update(subCategory);
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

	public boolean deleteSubCategory(Integer idSubCategory) {
		Session session = factory.openSession();
		Transaction tx = null;
		boolean isSuccess = false;
		try {
			tx = session.beginTransaction();
			Subcategory subCategory = session.get(Subcategory.class, idSubCategory);
			session.delete(subCategory);
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
