package com.zq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zq.po.Candidate;
import com.zq.service.AdminService;
import com.zq.service.CandidateService;

public class CandidateAddServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// set encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		if(request.getParameter("age") == null||request.getParameter("age") == ""){
			request.setAttribute("msg", "error !");
			request.getRequestDispatcher("/candidate/candidate_add.jsp").forward(request, response);
			return ;
		}
		CandidateService  service = new CandidateService();
	
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		String introduce = request.getParameter("introduce");
		String image = request.getParameter("image");

		
		Candidate candidate = new Candidate();
		candidate.setName(name);
		candidate.setSex(sex);
		candidate.setAge(age);
		candidate.setAddress(address);
		candidate.setIntroduce(introduce);
		candidate.setImage(image);
		Boolean b = service.addCandidate(candidate);
//		if(b){
//			System.out.println("add success");
//		}
	
//		request.setAttribute("candidate", candidate);
//		response.sendRedirect(request.getContextPath()+"/frameset/framset.jsp"); 
		 
		response.getWriter().write("add success ! please wait a second! ");
		response.setHeader("refresh", "1;url="+request.getContextPath()+"/candidateList");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
