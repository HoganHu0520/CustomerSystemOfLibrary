package com.hogan.dao.proxy;

import org.hibernate.Session;

public interface DaoProxy {
	public void action(Session session);
}
