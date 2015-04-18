package com.hogan.dao;

import com.hogan.dao.base.BaseDao;
import com.hogan.model.User;

public class UserDao extends BaseDao<User> {
	public static UserDao shareInstance = new UserDao();

	private UserDao(){}

}
