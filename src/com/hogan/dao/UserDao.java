package com.hogan.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.hogan.dao.base.BaseDao;
import com.hogan.dao.proxy.DaoProxy;
import com.hogan.model.User;
import com.hogan.model.common.Pagination;

public class UserDao extends BaseDao<User> {
	public static UserDao shareInstance = new UserDao();

	private UserDao(){}

	public Pagination<User> query(Pagination<User> pagination) {
		Pagination<User> resultPagination = pagination;
		
		List<User> list = this.executeActionWithResult(new DaoProxy() {
			
			@Override
			public void action(Session session) {
				Query query = session.createQuery("select user from User user")
						.setFirstResult((pagination.getPageIndex() - 1) * pagination.getPageSize())
						.setMaxResults(pagination.getPageSize());
				result = query.list();
			}
		});
		
		resultPagination.setResults(list);
		return resultPagination;
	}
}
