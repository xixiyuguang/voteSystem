package com.zq.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zq.po.Admin;
import com.zq.po.Candidate;
import com.zq.service.AdminService;
import com.zq.service.CandidateService;

/* 
1 .  ballot  进行 加一
2.   判断是否可以加 一
3.   重复定向一次
1. 判断是否可以加 一
 */
public class CandidateBallotServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// set encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		CandidateService service = new CandidateService();

		String get_id = request.getParameter("id");
		int id = Integer.parseInt(get_id);
		Candidate candidate = service.findCandidateById(id);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
