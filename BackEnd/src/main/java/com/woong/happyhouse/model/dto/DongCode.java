package com.woong.happyhouse.model.dto;

public class DongCode {
	private String city;
	private String gugun;
	private String dong;
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getGugun() {
		return gugun;
	}
	public void setGugun(String gugun) {
		this.gugun = gugun;
	}
	public String getDong() {
		return dong;
	}
	public void setDong(String dong) {
		this.dong = dong;
	}
	@Override
	public String toString() {
		return "DongCode [city=" + city + ", gugun=" + gugun + ", dong=" + dong + "]";
	}
	
	
}
