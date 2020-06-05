package com.yg.face.bean;

/**
 * 轮廓的值
 * @author yg
 *
 */
public class Contour {
	
	private Coordinate contourLeft1;
	private Coordinate contourLeft8;
	private Coordinate contourLeft16;	
	private Coordinate contourChin;	
	private Coordinate contourRight1;
	private Coordinate contourRight8;
	private Coordinate contourRight16;
	
	public Coordinate getContourLeft1() {
		return contourLeft1;
	}
	public void setContourLeft1(Coordinate contourLeft1) {
		this.contourLeft1 = contourLeft1;
	}
	public Coordinate getContourLeft8() {
		return contourLeft8;
	}
	public void setContourLeft8(Coordinate contourLeft8) {
		this.contourLeft8 = contourLeft8;
	}
	public Coordinate getContourLeft16() {
		return contourLeft16;
	}
	public void setContourLeft16(Coordinate contourLeft16) {
		this.contourLeft16 = contourLeft16;
	}
	public Coordinate getContourChin() {
		return contourChin;
	}
	public void setContourChin(Coordinate contourChin) {
		this.contourChin = contourChin;
	}
	public Coordinate getContourRight1() {
		return contourRight1;
	}
	public void setContourRight1(Coordinate contourRight1) {
		this.contourRight1 = contourRight1;
	}
	public Coordinate getContourRight8() {
		return contourRight8;
	}
	public void setContourRight8(Coordinate contourRight8) {
		this.contourRight8 = contourRight8;
	}
	public Coordinate getContourRight16() {
		return contourRight16;
	}
	public void setContourRight16(Coordinate contourRight16) {
		this.contourRight16 = contourRight16;
	}
	

	/*public static void main(String[] args) {
		contourLeft1 = new Coordinate();
		contourLeft1.setX(111.000001);
		contourLeft1.setY(222.000001);		
		System.out.println(contourLeft1.getX()+" "+contourLeft1.getY());  	
		
	}*/
  
}
