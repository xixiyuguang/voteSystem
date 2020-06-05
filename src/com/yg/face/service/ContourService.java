package com.yg.face.service;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yg.face.bean.Contour;
import com.yg.face.bean.Coordinate;
import com.yg.face.bean.HeadPose;
import com.zq.utils.LocalJsonString;

public class ContourService {
	//测试使用的

	LocalJsonString ljs = new LocalJsonString();
	
 
	public Contour getContour(String str){
		
		Contour contour = new  Contour();
		
		JSONObject jsonObject = JSONObject.parseObject(str) ;//1 层jsonStr
		JSONArray facesArray = jsonObject.getJSONArray("faces");// 2层
		// 获取。[]方括号里面只有一个大括号，所以只有一个array 就是 下面这个 facesArray.getJSONObject(0)
		JSONObject facesObject = facesArray.getJSONObject(0); //3层		
		/**
		 * 这里是脸的点的数据
		 */
	    JSONObject landmarkObject =  facesObject.getJSONObject("landmark");
	    
	    contour.setContourLeft1(new Coordinate(
	    		landmarkObject.getJSONObject("contour_left1").getDouble("y"), 
	    		landmarkObject.getJSONObject("contour_left1").getDouble("x")));
	    contour.setContourLeft8(new Coordinate(
	    		landmarkObject.getJSONObject("contour_left8").getDouble("y"), 
	    		 landmarkObject.getJSONObject("contour_left8").getDouble("x")));
	    contour.setContourLeft16(new Coordinate(
	    		landmarkObject.getJSONObject("contour_left16").getDouble("y"), 
	    		landmarkObject.getJSONObject("contour_left16").getDouble("x")));
	    
	    contour.setContourRight1(new Coordinate(
	    		landmarkObject.getJSONObject("contour_right1").getDouble("y"), 
	    		landmarkObject.getJSONObject("contour_right1").getDouble("x")));
	    contour.setContourRight8(new Coordinate(
	    		 landmarkObject.getJSONObject("contour_right8").getDouble("y"),
	    		 landmarkObject.getJSONObject("contour_right8").getDouble("x")));
	    contour.setContourRight16(new Coordinate(
	    		  landmarkObject.getJSONObject("contour_right16").getDouble("y"), 
	    		  landmarkObject.getJSONObject("contour_right16").getDouble("x")));
	    
	    System.out.println("--:"+landmarkObject.getJSONObject("contour_chin").getDouble("y"));
		return  contour;
	}
	
 
	public HeadPose getHeadPose(String str){
		HeadPose headPose = new HeadPose();
		JSONObject jsonObject = JSONObject.parseObject(str) ;//1 层jsonStr
		JSONArray facesArray = jsonObject.getJSONArray("faces");// 2层
		// 获取。[]方括号里面只有一个大括号，所以只有一个array 就是 下面这个 facesArray.getJSONObject(0)
		JSONObject facesObject = facesArray.getJSONObject(0); //3层		
		/**
		 *这里是属性的哪一个对象 
		 */
		JSONObject attributesObject =  facesObject.getJSONObject("attributes");
		System.out.println("--:"+attributesObject.getJSONObject("headpose").getDouble("yaw_angle"));
	
		headPose.setPitchAngle(attributesObject.getJSONObject("headpose").getDouble("pitch_angle"));
		headPose.setRollAngle(attributesObject.getJSONObject("headpose").getDouble("roll_angle"));
		headPose.setYawAngle(attributesObject.getJSONObject("headpose").getDouble("yaw_angle"));
	    
		return headPose;		
	}

}
