package com.yg.face.bean;

/*
 
 "mouth_upper_lip_top":    { "y": 150, "x": 202  }
"mouth_upper_lip_bottom": { "y": 156, "x": 202  }
"mouth_lower_lip_top":    { "y": 156, "x": 202  }
"mouth_lower_lip_bottom": { "y": 164, "x": 202  }
"mouth_left_corner":      { "y": 156, "x": 182  }
"mouth_right_corner":     { "y": 155, "x": 222  }
 "mouthstatus": {   "close": 99.999,
                    "surgical_mask_or_respirator": 0,
                    "open": 0,
                    "other_occlusion": 0.001
                }

 */
/**
 * 嘴巴的几个点 使用mark后缀
 * @author yg
 *
 */
public class Mouth {
	
	/**
	 * 上嘴唇
	 */
	private Coordinate mouth_upper_lip_top;
	private Coordinate mouth_upper_lip_bottom;
	/**
	 * 下嘴唇
	 */
	private Coordinate mouth_lower_lip_top;
	private Coordinate mouth_lower_lip_bottom;
	/**
	 * 嘴角
	 */
	private Coordinate mouth_left_corner;
	private Coordinate mouth_right_corner;
	
	
	public Coordinate getMouth_upper_lip_top() {
		return mouth_upper_lip_top;
	}
	public void setMouth_upper_lip_top(Coordinate mouth_upper_lip_top) {
		this.mouth_upper_lip_top = mouth_upper_lip_top;
	}
	public Coordinate getMouth_upper_lip_bottom() {
		return mouth_upper_lip_bottom;
	}
	public void setMouth_upper_lip_bottom(Coordinate mouth_upper_lip_bottom) {
		this.mouth_upper_lip_bottom = mouth_upper_lip_bottom;
	}
	public Coordinate getMouth_lower_lip_top() {
		return mouth_lower_lip_top;
	}
	public void setMouth_lower_lip_top(Coordinate mouth_lower_lip_top) {
		this.mouth_lower_lip_top = mouth_lower_lip_top;
	}
	public Coordinate getMouth_lower_lip_bottom() {
		return mouth_lower_lip_bottom;
	}
	public void setMouth_lower_lip_bottom(Coordinate mouth_lower_lip_bottom) {
		this.mouth_lower_lip_bottom = mouth_lower_lip_bottom;
	}
	public Coordinate getMouth_left_corner() {
		return mouth_left_corner;
	}
	public void setMouth_left_corner(Coordinate mouth_left_corner) {
		this.mouth_left_corner = mouth_left_corner;
	}
	public Coordinate getMouth_right_corner() {
		return mouth_right_corner;
	}
	public void setMouth_right_corner(Coordinate mouth_right_corner) {
		this.mouth_right_corner = mouth_right_corner;
	}
	
	
	

}
