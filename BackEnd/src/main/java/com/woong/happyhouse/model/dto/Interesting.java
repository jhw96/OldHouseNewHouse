package com.woong.happyhouse.model.dto;

public class Interesting {
	private String userid;
	private String dong;
	private String AptName;
	private String lat;
	private String lng;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	public String getAptName() {
		return AptName;
	}
	public void setAptName(String aptName) {
		AptName = aptName;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLng() {
		return lng;
	}
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	@Override
	public String toString() {
		return "Interesting [userid=" + userid + ", dong=" + dong + ", AptName=" + AptName + ", lat=" + lat + ", lng="
				+ lng + "]";
	}
	
	
	

}
