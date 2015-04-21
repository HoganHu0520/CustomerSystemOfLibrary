package com.hogan.service;

import org.junit.Before;
import org.junit.Test;

import com.hogan.util.ApplicationContextUtil;

public class UserServiceTest {
	private UserService userService;
	
	@Before
	public void initUserService() {
		userService = ApplicationContextUtil.getBean("userService");
	}
	
	@Test
	public void loginTest() {
		userService.login("1127160850", "password");
	}
}
