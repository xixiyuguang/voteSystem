package com.zq.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zq.po.Candidate;
import com.zq.service.AdminService;
import com.zq.service.CandidateService;

/**
 * 投票检测
 * @author yg
 *
 */
public class VoterCheckServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// set encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		CandidateService service = new CandidateService();

		// 对ip进行处理 yaozuo
		String[] ip_str = request.getParameterValues("test_ip");
		String ip = ip_str[0]; // 获取到的ip

		String[] ids = request.getParameterValues("test"); // 获取到投票的string[0]
		if(ids[0]==null || ids[0] ==""){
			request.setAttribute("msg", "please check! 请投票之后再提交");
			request.getRequestDispatcher("/ListCandidateToVoter").forward(request, response);
			 
		}else{
			String[] t = ids[0].split(" ");
			for (String i : t) {
				int id = Integer.parseInt(i);
				service.addCandidateBallot(id);
			}
			// 获取有哪些参数
			// String[] id = request.getParameterValues("id");
			// for(String i:id){
			// System.out.println(i);
			// }

			response.getWriter()
					.write("vote   success ! please wait a second! ");
			//response.setHeader("refresh", "1;url=" + request.getContextPath()+ "/candidateList");
			//response.setHeader("refresh", "1;url=" + request.getContextPath()+ "/index.jsp");
			response.sendRedirect(request.getContextPath()+ "/success.jsp"); 
			
		}
		
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
