package com.yg.face;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xpath.internal.SourceTree;
import com.yg.face.bean.Coordinate;
import com.yg.face.bean.Eye;
import com.yg.face.bean.EyeStatus;
import com.yg.face.service.EyeService;
import com.yg.face.service.JsonServletService;
import com.yg.face.service.MouthAnalysisService;

/**
 *嘴巴的servlet
 * @author yg
 *
 */
public class EyeServlet extends HttpServlet{

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//set encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
			
		EyeService   eyeService = new EyeService();
		
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
			EyeStatus  eyestatus= eyeService.getEyeStatus(str);
		//眼睛被遮挡
		if(eyestatus.getLeftOcclusion()>50&&eyestatus.getRightOcclusion()>50){
			request.getSession().setAttribute("infor", "您是不是遮住了眼睛！请移除遮挡物。");
			response.sendRedirect(request.getContextPath()+"/takephoto/eye.jsp");
		}
		//如果是墨镜
		else if(eyestatus.getLeftdarkGlasses()>50&&eyestatus.getRightdarkGlasses()>50){
			request.getSession().setAttribute("infor", "请摘到墨镜，认真对待");
			response.sendRedirect(request.getContextPath()+"/takephoto/eye.jsp");
		}else{
			//如果是没有戴眼镜
			if(eyestatus.getLeftnoGlassEyeClose()>50||eyestatus.getLeftnoGlassEyeOpen()>50||
					eyestatus.getRightnoGlassEyeOpen()>50||eyestatus.getRightnoGlassEyeClose()>50){
				if(eyestatus.getRightnoGlassEyeOpen()>50||eyestatus.getLeftnoGlassEyeOpen()>50){
					
					Eye eye = eyeService.getEyeDistance(str);
					double Rdistance = eye.getRightEyeBottom().getY()-eye.getRightEyeTop().getY();
					double Ldistance = eye.getLeftEyeBottom().getY()-eye.getLeftEyeTop().getY();
					request.getSession().setAttribute("infor", "没戴眼镜的客户,您的左眼："+Rdistance+" 您的右眼："+Ldistance);
					response.sendRedirect(request.getContextPath()+"/takephoto/eye.jsp");
				}else{
					request.getSession().setAttribute("infor", "没戴眼镜的客户,您不要闭眼啊");
					response.sendRedirect(request.getContextPath()+"/takephoto/eye.jsp");
				}
			}
			//带了普通的眼睛
			else{
				if(eyestatus.getLeftnormalGlassEyeOpen()>50||eyestatus.getRightnormalGlassEyeOpen()>50){
					//戴眼镜  睁开眼睛状态
					Eye eye = eyeService.getEyeDistance(str);
					double Rdistance = eye.getRightEyeBottom().getY()-eye.getRightEyeTop().getY();
					double Ldistance = eye.getLeftEyeBottom().getY()-eye.getLeftEyeTop().getY();
					request.getSession().setAttribute("infor", "戴眼镜的客户,您的左眼："+Rdistance+" 您的右眼："+Ldistance);
					response.sendRedirect(request.getContextPath()+"/takephoto/eye.jsp");
				}
				else{
					request.getSession().setAttribute("infor", "戴眼镜的客户,您不要闭眼啊");
					response.sendRedirect(request.getContextPath()+"/takephoto/eye.jsp");
				}
				
			}
		}
	}
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doGet(request,response);
	}

	
}
