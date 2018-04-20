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

///BallotCountListServlet

public class BallotCountListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// set encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		CandidateService service = new CandidateService();

		List<Candidate> candidateList = service.getBallotAll();
		 
		for(Candidate c:candidateList){			
			 System.out.println(c.getBallot());
		}
		request.setAttribute("candidateList", candidateList);
	

		request.getRequestDispatcher("count_ballot.jsp").forward(
				request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
