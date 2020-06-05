package com.yg.face.bean;

import lombok.Data;

/**
 * 坐标系的x和y轴  ，用于别的地方的使用这个类
 * 注意这里的y和x的顺序
 * @author yg
 *
 */
public class Coordinate {
	
	
	private double y;
	private double x;
	
	public Coordinate(double y, double x) {
		this.y = y;
		this.x = x;
	}
	
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	
	
	
	
}
