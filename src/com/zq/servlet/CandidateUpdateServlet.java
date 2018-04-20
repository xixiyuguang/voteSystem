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

public class CandidateUpdateServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// set encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		CandidateService service = new CandidateService();

		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		int age = Integer.parseInt(request.getParameter("age"));
		String address = request.getParameter("address");
		String introduce = request.getParameter("introduce");
		String image = request.getParameter("image");

		String get_id = request.getParameter("id");
		int id = Integer.parseInt(get_id);
		Candidate candidate = new Candidate();
		candidate.setName(name);
		candidate.setSex(sex);
		candidate.setAge(age);
		candidate.setAddress(address);
		candidate.setIntroduce(introduce);
		candidate.setImage(image);

		Boolean b = service.updateCandidate(id, candidate);

		// request.getSession().setAttribute("candidate", candidate);
		//response.sendRedirect(request.getContextPath() + "/candidateList");

		response.getWriter().write("update success ! please wait a second! ");
		response.setHeader("refresh", "1;url=" + request.getContextPath()+ "/candidateList");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
