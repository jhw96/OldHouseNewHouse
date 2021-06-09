package com.woong.happyhouse.model.dto;

public class Comment {
	private String userid;
	private String content;
	private String regtime;
	private int boardno;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegtime() {
		return regtime;
	}
	public void setRegtime(String regtime) {
		this.regtime = regtime;
	}
	public int getBoardno() {
		return boardno;
	}
	public void setBoardno(int boardno) {
		this.boardno = boardno;
	}
	@Override
	public String toString() {
		return "Comment [userid=" + userid + ", content=" + content + ", regtime=" + regtime + ", boardno=" + boardno
				+ "]";
	}
	
	
}
