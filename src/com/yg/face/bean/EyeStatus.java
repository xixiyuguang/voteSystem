package com.yg.face.bean;

/*
 
 "left_eye_status": {
                        "normal_glass_eye_open": 97.659,
                        "no_glass_eye_close": 0,
                        "occlusion": 0.352,
                        "no_glass_eye_open": 0.245,
                        "normal_glass_eye_close": 1.718,
                        "dark_glasses": 0.026
                    }
 */
/**
 * 这里只考虑了左眼的计算 
 * left_eye_status
 * @author yg
 *
 */
public class EyeStatus {
	private double leftnormalGlassEyeOpen;
	private double leftnormalGlassEyeClose;
	private double leftnoGlassEyeOpen;
	private double leftnoGlassEyeClose;
	private double leftOcclusion; //眼睛闭合程度
	private double leftdarkGlasses; //墨镜
	
	private double rightnormalGlassEyeOpen;
	private double rightnormalGlassEyeClose;
	private double rightnoGlassEyeOpen;
	private double rightnoGlassEyeClose;
	private double rightOcclusion; //眼睛闭合程度
	private double rightdarkGlasses; //墨镜
	public double getLeftnormalGlassEyeOpen() {
		return leftnormalGlassEyeOpen;
	}
	public void setLeftnormalGlassEyeOpen(double leftnormalGlassEyeOpen) {
		this.leftnormalGlassEyeOpen = leftnormalGlassEyeOpen;
	}
	public double getLeftnormalGlassEyeClose() {
		return leftnormalGlassEyeClose;
	}
	public void setLeftnormalGlassEyeClose(double leftnormalGlassEyeClose) {
		this.leftnormalGlassEyeClose = leftnormalGlassEyeClose;
	}
	public double getLeftnoGlassEyeOpen() {
		return leftnoGlassEyeOpen;
	}
	public void setLeftnoGlassEyeOpen(double leftnoGlassEyeOpen) {
		this.leftnoGlassEyeOpen = leftnoGlassEyeOpen;
	}
	public double getLeftnoGlassEyeClose() {
		return leftnoGlassEyeClose;
	}
	public void setLeftnoGlassEyeClose(double leftnoGlassEyeClose) {
		this.leftnoGlassEyeClose = leftnoGlassEyeClose;
	}
	public double getLeftOcclusion() {
		return leftOcclusion;
	}
	public void setLeftOcclusion(double leftOcclusion) {
		this.leftOcclusion = leftOcclusion;
	}
	public double getLeftdarkGlasses() {
		return leftdarkGlasses;
	}
	public void setLeftdarkGlasses(double leftdarkGlasses) {
		this.leftdarkGlasses = leftdarkGlasses;
	}
	public double getRightnormalGlassEyeOpen() {
		return rightnormalGlassEyeOpen;
	}
	public void setRightnormalGlassEyeOpen(double rightnormalGlassEyeOpen) {
		this.rightnormalGlassEyeOpen = rightnormalGlassEyeOpen;
	}
	public double getRightnormalGlassEyeClose() {
		return rightnormalGlassEyeClose;
	}
	public void setRightnormalGlassEyeClose(double rightnormalGlassEyeClose) {
		this.rightnormalGlassEyeClose = rightnormalGlassEyeClose;
	}
	public double getRightnoGlassEyeOpen() {
		return rightnoGlassEyeOpen;
	}
	public void setRightnoGlassEyeOpen(double rightnoGlassEyeOpen) {
		this.rightnoGlassEyeOpen = rightnoGlassEyeOpen;
	}
	public double getRightnoGlassEyeClose() {
		return rightnoGlassEyeClose;
	}
	public void setRightnoGlassEyeClose(double rightnoGlassEyeClose) {
		this.rightnoGlassEyeClose = rightnoGlassEyeClose;
	}
	public double getRightOcclusion() {
		return rightOcclusion;
	}
	public void setRightOcclusion(double rightOcclusion) {
		this.rightOcclusion = rightOcclusion;
	}
	public double getRightdarkGlasses() {
		return rightdarkGlasses;
	}
	public void setRightdarkGlasses(double rightdarkGlasses) {
		this.rightdarkGlasses = rightdarkGlasses;
	}
	
	
	
	

}
