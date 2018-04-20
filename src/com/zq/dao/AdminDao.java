package com.zq.dao;

import com.zq.po.Admin;

public interface AdminDao {
	
	public Admin findAdminByAccount(String account);  //find admin  by  Account
	
	public Boolean addAdmin(Admin admin);
}
