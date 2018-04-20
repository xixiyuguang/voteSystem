package com.zq.service;

import org.junit.Test;

import com.zq.po.Admin;

public class AdminServiceTest {

	@Test
	public void testIsAdmin() throws Exception {
		AdminService adminService = new AdminService();
		Admin admin  = adminService.isAdmin("1", "2");
		System.out.println("admin = "+admin.getName());
	}

}
