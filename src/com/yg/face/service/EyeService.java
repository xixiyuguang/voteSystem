package com.yg.face.service;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yg.face.bean.Coordinate;
import com.yg.face.bean.Eye;
import com.yg.face.bean.EyeStatus;
import com.zq.utils.LocalJsonString;

public class EyeService {
	
	
	//测试使用的
	LocalJsonString ljs = new LocalJsonString();
	
	 
	public Eye getEyeDistance(String jsonStr){
		Eye eye = new Eye();		 
		
		JSONObject jsonObject = JSONObject.parseObject(jsonStr) ;//1 层
		JSONArray facesArray = jsonObject.getJSONArray("faces");// 2层
		// 获取。[]方括号里面只有一个大括号，所以只有一个array 就是 下面这个 facesArray.getJSONObject(0)
		JSONObject facesObject = facesArray.getJSONObject(0); //3层		
		/**
		 * 这里是脸的点的数据
		 */
	    JSONObject landmarkObject =  facesObject.getJSONObject("landmark");
	 
	    eye.setLeftEyeTop(new Coordinate( 
	    		landmarkObject.getJSONObject("left_eye_top").getDouble("y"), 
	    		landmarkObject.getJSONObject("left_eye_top").getDouble("x")));
	    eye.setLeftEyeCenter(new Coordinate(
	    		landmarkObject.getJSONObject("left_eye_center").getDouble("y"), 
	    		landmarkObject.getJSONObject("left_eye_center").getDouble("x")));
	    eye.setLeftEyePupil(new Coordinate(
	    		landmarkObject.getJSONObject("left_eye_pupil").getDouble("y"), 
	    		landmarkObject.getJSONObject("left_eye_pupil").getDouble("x")));
	    eye.setLeftEyeBottom(new Coordinate(
	    		landmarkObject.getJSONObject("left_eye_bottom").getDouble("y"), 
	    		landmarkObject.getJSONObject("left_eye_bottom").getDouble("x")));
	    
	    eye.setRightEyeTop(new Coordinate( 
	    		landmarkObject.getJSONObject("right_eye_top").getDouble("y"), 
	    		landmarkObject.getJSONObject("right_eye_top").getDouble("x")));
	    eye.setRightEyeCenter(new Coordinate(
	    		landmarkObject.getJSONObject("right_eye_center").getDouble("y"), 
	    		landmarkObject.getJSONObject("right_eye_center").getDouble("x")));
	    eye.setRightEyePupil(new Coordinate(
	    		landmarkObject.getJSONObject("right_eye_pupil").getDouble("y"), 
	    		landmarkObject.getJSONObject("right_eye_pupil").getDouble("x")));
	    eye.setRightEyeBottom(new Coordinate(
	    		landmarkObject.getJSONObject("right_eye_bottom").getDouble("y"), 
	    		landmarkObject.getJSONObject("right_eye_bottom").getDouble("x")));
	     
	    double distance = eye.getLeftEyeBottom().getY() - eye.getLeftEyeTop().getY();
	    
	    System.out.println("--"+landmarkObject.getJSONObject("left_eye_top").getDouble("y"));
	    System.out.println("--"+landmarkObject.getJSONObject("left_eye_bottom").getDouble("y"));
	    System.out.println("--"+distance);
	    //闭眼的时候是2 
	    return eye;
	}
	
	
 
	public EyeStatus getEyeStatus(String jsonStr) {
		EyeStatus eyeStatus = new EyeStatus();
		//String jsonStr
		
		JSONObject jsonObject = JSONObject.parseObject(jsonStr) ;//1 层
		JSONArray facesArray = jsonObject.getJSONArray("faces");// 2层
		// 获取。[]方括号里面只有一个大括号，所以只有一个array 就是 下面这个 facesArray.getJSONObject(0)
		JSONObject facesObject = facesArray.getJSONObject(0); //3层		
		/**
		 *这里是属性的哪一个对象 
		 */
		JSONObject attributesObject =  facesObject.getJSONObject("attributes");
		JSONObject eyestatusObject = attributesObject.getJSONObject("eyestatus");
		JSONObject leftEyestatusObject = eyestatusObject.getJSONObject("left_eye_status");
		JSONObject rightEyestatusObject = eyestatusObject.getJSONObject("right_eye_status");
		
		eyeStatus.setLeftOcclusion(leftEyestatusObject.getDouble("occlusion"));
	 
		eyeStatus.setLeftdarkGlasses(leftEyestatusObject.getDouble("dark_glasses"));;
		
		eyeStatus.setLeftnormalGlassEyeOpen(leftEyestatusObject.getDouble("normal_glass_eye_open"));
		eyeStatus.setLeftnormalGlassEyeClose(leftEyestatusObject.getDouble("normal_glass_eye_close"));		
		
		eyeStatus.setLeftnoGlassEyeClose(leftEyestatusObject.getDouble("no_glass_eye_close"));
		eyeStatus.setLeftnoGlassEyeOpen(leftEyestatusObject.getDouble("no_glass_eye_open"));
	 
		eyeStatus.setRightOcclusion(rightEyestatusObject.getDoubleValue("occlusion"));
		
		eyeStatus.setRightdarkGlasses(rightEyestatusObject.getDoubleValue("dark_glasses"));
		
		eyeStatus.setRightnormalGlassEyeClose(rightEyestatusObject.getDoubleValue("normal_glass_eye_open"));
		eyeStatus.setRightnormalGlassEyeOpen(rightEyestatusObject.getDoubleValue("normal_glass_eye_close"));
		
		eyeStatus.setRightnoGlassEyeClose(rightEyestatusObject.getDoubleValue("no_glass_eye_close"));
		eyeStatus.setRightnoGlassEyeOpen(rightEyestatusObject.getDoubleValue("no_glass_eye_open"));
		
		System.out.println("--:"+eyeStatus.getLeftOcclusion());
		return eyeStatus;		
	}

}
