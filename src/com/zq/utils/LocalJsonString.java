package com.zq.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class LocalJsonString {
	public String getLocalJsonString() throws Exception{
		File file =new File("D:/json.txt");
		//输入流 开始
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader reader= new InputStreamReader(fis, "UTF-8");
		
		StringBuffer  sb = new StringBuffer();
		while(reader.ready()){
			sb.append((char)reader.read());  //因为读取的是 整数型的编码，，需要转换成char类型
		}
		
		System.out.println(sb.toString());
		reader.close();
		fis.close();
		System.out.println();
		return sb.toString();
	}

}
