package com.hogan.model;

import org.junit.Before;
import org.junit.Test;

import com.hogan.dao.UserDao;
import com.hogan.model.common.Pagination;
import com.hogan.util.ApplicationContextUtil;

public class UserTest {
	
	private UserDao userDao = null;
	
	@Before
	public void initUserDao() {
		userDao = ApplicationContextUtil.getBean("userDao");
	}

	@Test
	public void createUserTest() {
		User user = new User();
		user.setId(3);
		user.setName("Hogan");
		user.setPassword("password");
		
//		UserDao.shareInstance.saveOrUpdate(user);
		userDao.delete(user);
	}
	
	@Test
	public void getUserTest() {
		User user = new User();
		user.setId(3);
		
		User resultUser = userDao.getById(user);
		System.out.println(resultUser.getName() + " " + resultUser.getPassword());
	}
	
	@Test
	public void getUserListTest() {
		Pagination<User> pagination = new Pagination<User>();
		pagination.setPageIndex(1);
		
		pagination = userDao.query(pagination);
		
		for (User user : pagination.getResults()) {
			System.out.println(user);
		}
	}

}
