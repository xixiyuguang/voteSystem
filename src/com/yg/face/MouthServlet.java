package com.yg.face;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.yg.face.bean.Coordinate;
import com.yg.face.service.JsonServletService;
import com.yg.face.service.MouthAnalysisService;

/**
 *嘴巴的servlet
 * @author yg
 *
 */
public class MouthServlet extends HttpServlet{

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//set encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
			
		MouthAnalysisService  mService = new MouthAnalysisService();
		
		JsonServletService service  = new  JsonServletService();
		
		String str= service.getJsonString();
		JSONObject jsonObject = JSONObject.parseObject(str);  //第一层
		 

		//检测是否获取到数据  不行就报错刷新
		if(jsonObject.getString("error_message")!=null){
				System.out.println("报错了，请重试。。。。");	
				request.setAttribute("msg", "由于网络原因，请重试。。。。!");
				request.getRequestDispatcher("/takephoto/check.jsp").forward(request, response);
			}
		else{	
			System.out.println("开始分析");
			int status = mService.getMouthStatus(str);
			double distance = mService.getMouthOpenDistance(str);
			if(status==0){
				request.getSession().setAttribute("infor", "您是不是遮住了嘴巴！请移除遮挡物。");
				response.sendRedirect(request.getContextPath()+"/takephoto/mouth.jsp");
			}
			if(status==1){
				request.getSession().setAttribute("infor", "你的嘴巴闭合了。");
				request.getSession().setAttribute("distance", 0);
				response.sendRedirect(request.getContextPath()+"/takephoto/mouth.jsp");
			}
            if(status==2){
            	request.getSession().setAttribute("infor", "嘴巴张开了。");
            	request.getSession().setAttribute("distance", distance);            	
            	response.sendRedirect(request.getContextPath()+"/takephoto/mouth.jsp");
			}				
		}				 	
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doGet(request,response);
	}

	
}
