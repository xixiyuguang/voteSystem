package com.zq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zq.po.Admin;
import com.zq.service.AdminService;
import com.zq.service.CandidateService;

public class CandidateDeleteServlet extends HttpServlet{

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		CandidateService  service = new CandidateService();
		String url_id = request.getParameter("id");
		int id = Integer.parseInt(url_id);
		Boolean b = service.deleteCandidate(id);
		System.out.println(b);
		
		//response.sendRedirect(request.getContextPath()+"/candidateList");
		response.getWriter().write("delete success ! please wait a second! ");
		response.setHeader("refresh", "1;url="+request.getContextPath()+"/candidateList");

	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doGet(request,response);
	}

	
}
