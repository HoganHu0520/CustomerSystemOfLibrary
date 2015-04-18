package com.hogan.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.hogan.util.HibernateUtil;

public class UserTest {

	@Test
	public void createUserTest() {
		User user = new User();
		user.setId(2);
		user.setName("Hogan");
		user.setPassword("password");
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
