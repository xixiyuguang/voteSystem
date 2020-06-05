package com.yg.face.bean;

/*
 
 "headpose": { "yaw_angle": 3.698088,
               "pitch_angle": 21.743643,
               "roll_angle": -2.838138 }
    pitch_angle：抬头
    roll_angle：旋转（平面旋转）
    yaw_angle：摇头
 */
/**
 * 头部姿态
 * @author yg
 *
 */
public class HeadPose {
	
	private double yawAngle; // 摇头
	private double pitchAngle; // 抬头
	private double rollAngle; //旋转 平面
	
	public double getYawAngle() {
		return yawAngle;
	}
	public void setYawAngle(double yawAngle) {
		this.yawAngle = yawAngle;
	}
	public double getPitchAngle() {
		return pitchAngle;
	}
	public void setPitchAngle(double pitchAngle) {
		this.pitchAngle = pitchAngle;
	}
	public double getRollAngle() {
		return rollAngle;
	}
	public void setRollAngle(double rollAngle) {
		this.rollAngle = rollAngle;
	}
	
	
	

}
