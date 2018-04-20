package com.zq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zq.po.Admin;
import com.zq.service.AdminService;

public class AdminRegisterServlet extends HttpServlet{

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		 
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		AdminService adminService = new AdminService();
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String ip  = request.getRemoteAddr();
		System.out.println(ip);
		
		Admin admin = adminService.isAdmin(account, password);
		if(admin==null){
			request.setAttribute("msg", "your password is error!");
			request.getRequestDispatcher("/admin/admin_login.jsp").forward(request, response);
			//forward to login jsp page
		}else{
			request.getSession().setAttribute("admin", admin);
			response.sendRedirect(request.getContextPath()+"/frameset/framset.jsp");
		}				 
		//super.doGet(request, response);
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doGet(request,response);
	}

	
}
