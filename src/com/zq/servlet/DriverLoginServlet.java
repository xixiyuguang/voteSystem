package com.zq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zq.po.Admin;
import com.zq.po.Candidate;
import com.zq.service.AdminService;
import com.zq.service.CandidateService;

public class DriverLoginServlet extends HttpServlet{

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//set encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		CandidateService candidateService= new CandidateService();
		String account = request.getParameter("account");
		String password = request.getParameter("password");	 
	    System.out.println(account+password+request.getContextPath());
		
		Candidate candidate = candidateService.isDriver(account, password);
		if(candidate==null){
			request.setAttribute("msg", "驾驶员界面your password is error!");
			request.getRequestDispatcher("/driver/driver_login.jsp").forward(request, response);
			//forward to login jsp page
		}else{
			request.getSession().setAttribute("candidate", candidate);
			request.getRequestDispatcher("/takephoto/takephoto.jsp").forward(request, response);
		}				 
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doGet(request,response);
	}

	
}
