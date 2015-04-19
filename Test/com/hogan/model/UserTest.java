package com.hogan.model;

import org.junit.Test;

import com.hogan.dao.UserDao;
import com.hogan.model.common.Pagination;

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
	
	@Test
	public void getUserTest() {
		User user = new User();
		user.setId(3);
		
		User resultUser = UserDao.shareInstance.getById(user);
		System.out.println(resultUser.getName() + " " + resultUser.getPassword());
	}
	
	@Test
	public void getUserListTest() {
		Pagination<User> pagination = new Pagination<User>();
		pagination.setPageIndex(1);
		
		pagination = UserDao.shareInstance.query(pagination);
		
		for (User user : pagination.getResults()) {
			System.out.println(user);
		}
	}

}
