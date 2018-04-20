package com.zqq.takephoto;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

import sun.misc.BASE64Decoder;


/**
 * 拍照的servlet
 * 
 * @author yg
 *
 */
public class Uploadimage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		System.out.println("adassad");
		pw.println("receive!");

		BufferedReader read;
		read = request.getReader();
		char[] buff = new char[1024];
		int len = 0;
		StringBuffer sb = new StringBuffer();
		while ((len = read.read(buff)) != -1) {
			sb.append(buff, 0, len);
		}
		GenerateImage(sb.toString());
		
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

	 
	public  boolean GenerateImage(String imgStr) { //
		if (imgStr == null) // 
			return false;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {
					b[i] += 256;
				}
			}
		 
			String uuidName = UUID.randomUUID().toString(); 
			String imgFilePath = "D:/apache-tomcat-6.0.45/webapps/Day15/takephoto" +uuidName + ".png";// 
			String path = this.getServletContext().getRealPath("takephoto");
			System.out.println(path);
			String[] a = path.split("\\\\");
			String str="";
			for(String b1:a){
				System.out.println(b1); 
				str=str+b1+"/";
				System.out.println();
			}
			System.out.println(str);
			
			OutputStream out = new FileOutputStream(str+uuidName + ".png");
			out.write(b);
			out.flush();
			out.close();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
