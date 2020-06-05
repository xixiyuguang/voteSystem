package com.yg.face;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yg.face.bean.Coordinate;

/**
 * json的解析的测试
 * @author yg
 *
 */
public class test {

	public static void main(String[] args) throws Exception {
	
		

		//"D:/java/workspace64/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/vote/takephoto/1.png"
       String  path="D:/java/workspace64/.metadata/.plugins/org.eclipse.wst.server.core/"
		+ "tmp2/wtpwebapps/vote/takephoto/1.png";
       String path1 = "C:/Users/yg/Desktop/face/我的照片/base"
       		+ ".png";

		String str = FacePlusPlus.getJson(path1);// 封装 然后获取
		 
		System.out.println("打印输出数据 ：" + str);

		//三个简单对象解析
		JSONObject jsonObject = JSONObject.parseObject(str);  //第一层
		if(jsonObject.getString("error_message")!=null){
			System.out.println("报错了，请重试。。。。");			
		}
		
		String  image_id = jsonObject.getString("image_id");
		String  request_id = jsonObject.getString("request_id");
		int   time_used = jsonObject.getInteger("time_used");
		
		System.out.println(image_id+request_id+"  time  "+time_used);
		
		//faces复杂的解析
		//faces  array
		JSONArray facesArray = jsonObject.getJSONArray("faces");
		
		// 获取。[]方括号里面只有一个大括号，所以只有一个array 就是 下面这个 facesArray.getJSONObject(0)
		JSONObject facesObject = facesArray.getJSONObject(0);
		
		//face_token 
		System.out.println("face_token:  "+facesObject.getString("face_token"));
		
		
		//读取到的  face_rectangle
		JSONObject face_rectangleObject =  facesObject.getJSONObject("face_rectangle");
		int width = face_rectangleObject.getInteger("width");
		int top = face_rectangleObject.getInteger("top");
		int left = face_rectangleObject.getInteger("left");
		int height = face_rectangleObject.getInteger("height");
		System.out.println("face_rectangle = "+width+" "+top+" "+left+" "+height);
		
		//attributes  是一个jsonObject  里面是多个jsonObject
		JSONObject attributesObject =  facesObject.getJSONObject("attributes");
		JSONObject headposeObject =  attributesObject.getJSONObject("headpose");
		System.out.println( "抬头值（低头是正  抬头是负） "+headposeObject.getDouble("pitch_angle"));
		
		/*glass	String	

		是否佩戴眼镜的分析结果。返回值为：
		None	不佩戴眼镜
		Dark	佩戴墨镜
		Normal	佩戴普通眼镜
		eyestatus
		eyestatus	Object	

眼睛状态信息。返回值包含以下属性：

    left_eye_status：左眼的状态
    right_eye_status：右眼的状态

每个属性都包含以下字段。每个字段的值都是一个浮点数，范围 [0,100]，小数点后 3 位有效数字。字段值的总和等于 100。

    occlusion：眼睛被遮挡的置信度
    no_glass_eye_open：不戴眼镜且睁眼的置信度
    normal_glass_eye_close：佩戴普通眼镜且闭眼的置信度
    normal_glass_eye_open：佩戴普通眼镜且睁眼的置信度
    dark_glasses：佩戴墨镜的置信度
    no_glass_eye_close：不戴眼镜且闭眼的置信度
		*/
		//headposeObject.getDouble("pitch_angle");
		JSONObject glassObject = attributesObject.getJSONObject("glass");
		System.out.println("带的什么眼镜"+glassObject.getString("value"));  
		
		//眼镜的status  eyestatus
		JSONObject eyestatusObject = attributesObject.getJSONObject("eyestatus");
		JSONObject left_eye_statusObject = eyestatusObject.getJSONObject("left_eye_status");
		JSONObject right_eye_statusObject = eyestatusObject.getJSONObject("right_eye_status");
		
		System.out.println("left_eye_statusObject"+left_eye_statusObject.toString());
		System.out.println("right_eye_statusObject"+right_eye_statusObject.toString());
		
		
		//获取详细的面部数据  landmark
		JSONObject landmarkObject =  facesObject.getJSONObject("landmark");
		
		int x =landmarkObject.getJSONObject("mouth_upper_lip_left_contour2").getInteger("x");
		int y =landmarkObject.getJSONObject("mouth_upper_lip_left_contour2").getInteger("y");
		System.out.println("x======"+x+"y ====="+y);

	}

}
