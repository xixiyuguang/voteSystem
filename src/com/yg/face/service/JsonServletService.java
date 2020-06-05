package com.yg.face.service;

import com.sun.org.apache.regexp.internal.recompile;
import com.yg.face.FacePlusPlus;
/**
 * 获取json 数据的service
 * @author yg
 *
 */
public class JsonServletService {
	
	private final String  path="D:/java/workspace64/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/vote/takephoto/1.png";
	
	public String getJsonString(){		
	    
        String str = "";
		try {
			str = FacePlusPlus.getJson(path);						
		} catch (Exception e) {			 
			e.printStackTrace();
		}
		System.out.println("打印输出数据 ：" + str);
		return str;
	}

}
