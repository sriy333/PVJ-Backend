package com.pvj.test.config;

import org.junit.Test;

import com.pvj.config.DBConfig;

public class DBConfigTest {

	DBConfig dbconfig = new DBConfig();
	@Test
	public void getConfigObject() {
		System.out.println(dbconfig);
	}
}
