package com.gswtek.huyd.model;

/**
 * Author: huyd
 * Date: 2017-07-07
 * Time: 14:06
 * Describe:Icon模型类
 */
public class Icon {
	private int iId;
	private String iName;

	public Icon() {
	}

	public Icon(int iId, String iName) {
		this.iId = iId;
		this.iName = iName;
	}

	public int getiId() {
		return iId;
	}

	public String getiName() {
		return iName;
	}

	public void setiId(int iId) {
		this.iId = iId;
	}

	public void setiName(String iName) {
		this.iName = iName;
	}
}