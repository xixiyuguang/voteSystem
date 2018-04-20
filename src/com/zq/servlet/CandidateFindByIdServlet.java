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

public class CandidateFindByIdServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// set encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		CandidateService service = new CandidateService();

		String get_id = request.getParameter("id");
		int id = Integer.parseInt(get_id);
		Candidate candidate = service.findCandidateById(id);

//		request.getSession().setAttribute("admin", admin);
//		response.sendRedirect(request.getContextPath()+"/frameset/framset.jsp");
		request.getSession().setAttribute("candidate", candidate);
		response.sendRedirect(request.getContextPath()+"/candidate/candidate_update.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
