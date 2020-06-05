package com.yg.face;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.yg.face.bean.Contour;
import com.yg.face.bean.Coordinate;
import com.yg.face.bean.HeadPose;
import com.yg.face.service.ContourService;
import com.yg.face.service.JsonServletService;
/**
 * 打印输出数据 ：{"image_id": "ACYPlf9xqgyr3hPMswHt6Q==", 
 * "request_id": "1526698844,5e21c829-0714-4f53-8ff0-4e4c7642b47c", 
 * "time_used": 186, 
 * "faces": []}
 * @author yg
 *
 */

public class ContourServlet extends HttpServlet{

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//set encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
			
		ContourService contourService = new ContourService();
		
		//获取json数据
		JsonServletService service  = new  JsonServletService();
		String str= service.getJsonString();
		JSONObject jsonObject = JSONObject.parseObject(str);  //第一层
	 

		if(jsonObject.getString("error_message")!=null){
				System.out.println("报错了，请重试。。。。");	
				request.setAttribute("msg", "由于网络原因，请重试。。。。!");
				request.getRequestDispatcher("/takephoto/check.jsp").forward(request, response);
			}
		//没问题的
		else{
			Contour contour= contourService.getContour(str);
			HeadPose headPose = contourService.getHeadPose(str);
			//低头
			if(headPose.getPitchAngle()>5){
				//右边歪头
				if(headPose.getRollAngle()<-10){
					request.getSession().setAttribute("infor", "状态：低头，右侧歪头");
					response.sendRedirect(request.getContextPath()+"/takephoto/contour.jsp");
				}
				//左边歪头
				else if(headPose.getRollAngle()>10){
					request.getSession().setAttribute("infor", "状态：低头，左侧歪头");
					response.sendRedirect(request.getContextPath()+"/takephoto/contour.jsp");
				}
				//不歪头
				else{
					request.getSession().setAttribute("infor", "状态：正常低头");
					response.sendRedirect(request.getContextPath()+"/takephoto/contour.jsp");
				}
			}
			//抬头
			else if(headPose.getPitchAngle()<-5){
				//右边歪头
				if(headPose.getRollAngle()<-10){
					request.getSession().setAttribute("infor", "状态：抬头，右侧歪头");
					response.sendRedirect(request.getContextPath()+"/takephoto/contour.jsp");
				}
				//左边歪头
				else if(headPose.getRollAngle()>10){
					request.getSession().setAttribute("infor", "状态：抬头，左侧歪头");
					response.sendRedirect(request.getContextPath()+"/takephoto/contour.jsp");
				}
				//不歪头
				else{
					request.getSession().setAttribute("infor", "状态：正常抬头");
					response.sendRedirect(request.getContextPath()+"/takephoto/contour.jsp");
				}
			}
			//正常
			else{
				//右边歪头
				if(headPose.getRollAngle()<-10){
					request.getSession().setAttribute("infor", "状态：右侧歪头");
					response.sendRedirect(request.getContextPath()+"/takephoto/contour.jsp");
				}
				//左边歪头
				else if(headPose.getRollAngle()>10){
					request.getSession().setAttribute("infor", "状态：左侧歪头");
					response.sendRedirect(request.getContextPath()+"/takephoto/contour.jsp");
				}
				//不歪头
				else{
					request.getSession().setAttribute("infor", "状态：正常");
					response.sendRedirect(request.getContextPath()+"/takephoto/contour.jsp");
				}				
			}			
		}					 	
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doGet(request,response);
	}

	
}
