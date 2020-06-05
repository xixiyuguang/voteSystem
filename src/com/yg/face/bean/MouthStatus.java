package com.yg.face.bean;

/*
 "mouthstatus": {   "close": 99.999,
                    "surgical_mask_or_respirator": 0,  外科口罩或呼吸器
                    "open": 0,
                    "other_occlusion": 0.001 其他咬合 
                }
 */
/**
 * 嘴巴的状态  先判断是否有遮挡物
 * @author yg
 *
 */
public class MouthStatus {
	
	private double close;
	private double open;
	private double otherOcclusion;
	private double surgical_mask_or_respirator; //是否戴口罩 或者怎么样
	
	
	public double getClose() {
		return close;
	}
	public void setClose(double close) {
		this.close = close;
	}
	public double getOpen() {
		return open;
	}
	public void setOpen(double open) {
		this.open = open;
	}
	public double getOtherOcclusion() {
		return otherOcclusion;
	}
	public void setOtherOcclusion(double otherOcclusion) {
		this.otherOcclusion = otherOcclusion;
	}
	public double getSurgical_mask_or_respirator() {
		return surgical_mask_or_respirator;
	}
	public void setSurgical_mask_or_respirator(double surgical_mask_or_respirator) {
		this.surgical_mask_or_respirator = surgical_mask_or_respirator;
	}
	
	
	

}
