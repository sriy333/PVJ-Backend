package com.pvj.api.test;

import org.junit.Test;

import com.pvj.exception.GlobalResponseException;
import com.pvj.service.UserService;

public class UserApiTest {

	
	UserService user = new UserService();
	@Test
	public void createUser() throws GlobalResponseException {
		String body= "{\n    \"userName\":\"srivalli\",\n    \"password\":\"valli\",\n    \"emailId\":\"srivalli96@gmail.com\",\n    \"userScope\":\"ADMIN_WRITE_READ\",\n    \"userType\":\"Shop\"\n\n}";
		System.out.println(user.saveUser(body));
	}
}
