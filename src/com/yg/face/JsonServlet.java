package com.yg.face;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.yg.face.bean.Coordinate;
import com.yg.face.service.JsonServletService;
/**
 * 打印输出数据 ：{"image_id": "ACYPlf9xqgyr3hPMswHt6Q==", 
 * "request_id": "1526698844,5e21c829-0714-4f53-8ff0-4e4c7642b47c", 
 * "time_used": 186, 
 * "faces": []}
 * @author yg
 *
 */

public class JsonServlet extends HttpServlet{

	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
		//set encoding
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
			
		
		JsonServletService service  = new  JsonServletService();
		String str= service.getJsonString();
		JSONObject jsonObject = JSONObject.parseObject(str);  //第一层
		String jsonstr = jsonObject.toJSONString();

		if(jsonObject.getString("error_message")!=null){
				System.out.println("报错了，请重试。。。。");	
				request.setAttribute("msg", "由于网络原因，请重试。。。。!");
				request.getRequestDispatcher("/takephoto/check.jsp").forward(request, response);
			}
		else{
			request.getSession().setAttribute("json", str);
			request.getSession().setAttribute("admin", jsonstr);
			response.sendRedirect(request.getContextPath()+"/takephoto/json.jsp");
		}	
				 
				 
	
	}

 
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 doGet(request,response);
	}

	
}
