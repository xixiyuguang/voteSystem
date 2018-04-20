package com.zq.dao.Impl;

import org.junit.Test;

import com.zq.po.Admin;

public class AdminDaoImplTest {

	@Test
	public void testFindAdminByAccount() {
		AdminDaoImpl a = new AdminDaoImpl();	
		Admin admin = a.findAdminByAccount("1");
	    System.out.println("测试成功"+admin.getAccount());
	}
	@Test
	public void testaddAdmin() {
		AdminDaoImpl a = new AdminDaoImpl();	
		Admin admin = new Admin();
		
		admin.setAccount("");
		Boolean b = a.addAdmin(admin);
	    System.out.println("测试结过"+b);
	}

}
