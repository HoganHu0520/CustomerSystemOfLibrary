package com.hogan.model;

import org.junit.Test;

import com.hogan.dao.UserDao;

public class UserTest {

	@Test
	public void createUserTest() {
		User user = new User();
		user.setId(3);
		user.setName("Hogan");
		user.setPassword("password");
		
//		UserDao.shareInstance.saveOrUpdate(user);
		UserDao.shareInstance.delete(user);
	}

}
