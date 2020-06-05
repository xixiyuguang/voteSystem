package com.yg.face.service;

 

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yg.face.bean.Coordinate;
import com.yg.face.bean.Mouth;
import com.yg.face.bean.MouthStatus;
import com.zq.utils.LocalJsonString;

public class MouthAnalysisService {
	
	JsonServletService service  = new  JsonServletService();
	
	//测试使用的
	LocalJsonString ljs = new LocalJsonString();
	
	/**
	 * 返回嘴巴的状态
	 * @param str
	 * @return
	 */
	public int getMouthStatus(String jsonStr){
		
		MouthStatus  mouthStatus = new MouthStatus();
		//service.getJsonString() //ljs.getLocalJsonString()
		JSONObject jsonObject = JSONObject.parseObject(jsonStr) ;//1 层
		JSONArray facesArray = jsonObject.getJSONArray("faces");// 2层
		// 获取。[]方括号里面只有一个大括号，所以只有一个array 就是 下面这个 facesArray.getJSONObject(0)
		JSONObject facesObject = facesArray.getJSONObject(0); //3层
		
		/**
		 *这里是属性的哪一个对象 
		 */
		JSONObject attributesObject =  facesObject.getJSONObject("attributes");
		//
		JSONObject mouthstatusObject =  attributesObject.getJSONObject("mouthstatus");
		//插入参数
		mouthStatus.setClose(mouthstatusObject.getDouble("close"));
		mouthStatus.setOpen(mouthstatusObject.getDouble("open"));
		mouthStatus.setOtherOcclusion(mouthstatusObject.getDouble("other_occlusion"));
		mouthStatus.setSurgical_mask_or_respirator(mouthstatusObject.getDouble("surgical_mask_or_respirator"));
		System.out.println("---close"+mouthstatusObject.getDouble("close"));
		System.out.println("---open"+mouthstatusObject.getDouble("open"));
		//戴面具  或者别的原因遮住嘴巴了
		if(mouthStatus.getSurgical_mask_or_respirator()>50||mouthStatus.getOtherOcclusion()>50){
			return 0; //遮住嘴巴了
		}
		if(mouthStatus.getClose()>mouthStatus.getOpen()){
			return 1; //嘴巴闭合了
		}
	
		return 2;// 嘴巴张开了	
	}
	

	/**
	 * 获取嘴巴张开的大致长度 double类型
	 * @param str
	 * @return
	 */
	public double getMouthOpenDistance(String jsonStr){
		Mouth mouthmark = new Mouth();
		//service.getJsonString() ljs.getLocalJsonString()
		JSONObject jsonObject = JSONObject.parseObject(jsonStr);//1 层
		JSONArray facesArray = jsonObject.getJSONArray("faces");// 2层
		// 获取。[]方括号里面只有一个大括号，所以只有一个array 就是 下面这个 facesArray.getJSONObject(0)
		JSONObject facesObject = facesArray.getJSONObject(0); //3层		
		/**
		 * 这里是脸的点的数据
		 */
	    JSONObject landmarkObject =  facesObject.getJSONObject("landmark");

	    mouthmark.setMouth_upper_lip_top(new Coordinate(
				landmarkObject.getJSONObject("mouth_upper_lip_top").getDouble("y"),
				landmarkObject.getJSONObject("mouth_upper_lip_top").getDouble("x")));
	    
	    mouthmark.setMouth_upper_lip_bottom(new Coordinate(
	    		landmarkObject.getJSONObject("mouth_upper_lip_bottom").getDouble("y"), 
	    		landmarkObject.getJSONObject("mouth_upper_lip_bottom").getDouble("x")));
	    
	    mouthmark.setMouth_lower_lip_top(new Coordinate(
	    		landmarkObject.getJSONObject("mouth_lower_lip_top").getDouble("y"), 
	    		landmarkObject.getJSONObject("mouth_lower_lip_top").getDouble("x")));
	    
	    mouthmark.setMouth_lower_lip_bottom(new Coordinate(
	    		landmarkObject.getJSONObject("mouth_lower_lip_bottom").getDouble("y"), 
	    		landmarkObject.getJSONObject("mouth_lower_lip_bottom").getDouble("x")));
	    
	    mouthmark.setMouth_left_corner(new Coordinate(
	    		landmarkObject.getJSONObject("mouth_left_corner").getDouble("y"), 
	    		landmarkObject.getJSONObject("mouth_left_corner").getDouble("x")));
	    
	    mouthmark.setMouth_right_corner(new Coordinate(
    		    landmarkObject.getJSONObject("mouth_right_corner").getDouble("y"), 
    		    landmarkObject.getJSONObject("mouth_right_corner").getDouble("x")));
	    
	   double distance = mouthmark.getMouth_lower_lip_top().getY()-mouthmark.getMouth_upper_lip_bottom().getY();
	   
	    System.out.println("--"+landmarkObject.getJSONObject("mouth_upper_lip_top").getDouble("y"));
	    System.out.println("--"+landmarkObject.getJSONObject("mouth_upper_lip_top").getDouble("x"));
	    return distance;
	}

}
