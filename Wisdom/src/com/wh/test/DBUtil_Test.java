package com.wh.test;

import java.sql.Connection;

import org.junit.Test;

import com.wh.utils.DBUtil;

public class DBUtil_Test {
	
	@Test
	public void connectionTest(){
		Connection connection = DBUtil.getConnection();
		System.out.println(connection);
	}
}
