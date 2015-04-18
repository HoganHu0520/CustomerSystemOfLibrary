package com.hogan.dao.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hogan.util.HibernateUtil;

public class BaseDao<T> {
	
	public static String getClassName() {
		return Class.class.getName();
	}
	
	protected BaseDao(){}
	
	public void saveOrUpdate(T instance) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(instance);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	
	public void delete(T instance) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.delete(instance);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
	
}
