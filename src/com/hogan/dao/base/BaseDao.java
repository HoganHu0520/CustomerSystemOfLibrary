package com.hogan.dao.base;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hogan.dao.proxy.DaoProxy;
import com.hogan.model.base.BaseModel;
import com.hogan.util.HibernateUtil;

public class BaseDao<T extends BaseModel> {

	protected Object result;

	protected BaseDao() {
	}

	public void saveOrUpdate(T instance) {
		this.executeAction(new DaoProxy() {

			@Override
			public void action(Session session) {
				session.saveOrUpdate(instance);
			}
		});

	}

	public void delete(T instance) {
		this.executeAction(new DaoProxy() {

			@Override
			public void action(Session session) {
				session.delete(instance);
			}
		});
	}

	public T getById(T instance) {

		return this.executeActionWithResult(new DaoProxy() {

			@Override
			public void action(Session session) {
				result = session.get(instance.getClass(),
						((BaseModel) instance).getId());
			}
		});
	}

	// Private Methods

	protected void executeAction(DaoProxy proxy) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		proxy.action(session);
		session.getTransaction().commit();
		session.close();
	}

	@SuppressWarnings("unchecked")
	protected <B> B executeActionWithResult(DaoProxy proxy) {
		this.executeAction(proxy);
		
		B b = (B)result;
		result = null;
		return b;
	}
}
