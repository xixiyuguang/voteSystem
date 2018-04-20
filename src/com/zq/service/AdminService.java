package com.zq.service;

import org.junit.Test;

import com.zq.dao.Impl.AdminDaoImpl;
import com.zq.exception.MsgException;
import com.zq.po.Admin;

public class AdminService {

	private AdminDaoImpl dao = new AdminDaoImpl();

	public Admin isAdmin(String account, String password) {

		Admin admin = dao.findAdminByAccount(account);

		if (password.equals(admin.getPassword())) {
			System.out.println("the name is " + admin.getName());
			return admin;
		}
		// throw new MsgException("your password is error !");

		return null;
	}

	
	public Boolean addAdmin(){
		
		return null;
	}
}
