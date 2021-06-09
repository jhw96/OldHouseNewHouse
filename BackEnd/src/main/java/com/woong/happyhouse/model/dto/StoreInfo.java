package com.woong.happyhouse.model.dto;

public class StoreInfo {
	private String storename;
	private String storecategory;
	private String dong;
	private String addr;
	private String lng;
	private String lat;
	
	
	
	public String getStorename() {
		return storename;
	}



	public void setStorename(String storename) {
		this.storename = storename;
	}



	public String getStorecategory() {
		return storecategory;
	}



	public void setStorecategory(String storecategory) {
		this.storecategory = storecategory;
	}



	public String getDong() {
		return dong;
	}



	public void setDong(String dong) {
		this.dong = dong;
	}



	public String getAddr() {
		return addr;
	}



	public void setAddr(String addr) {
		this.addr = addr;
	}



	public String getLng() {
		return lng;
	}



	public void setLng(String lng) {
		this.lng = lng;
	}



	public String getLat() {
		return lat;
	}



	public void setLat(String lat) {
		this.lat = lat;
	}



	@Override
	public String toString() {
		return "StoreInfo [storename=" + storename + ", storecategory=" + storecategory + ", dong=" + dong + ", addr="
				+ addr + ", lng=" + lng + ", lat=" + lat + "]";
	}
	
}
