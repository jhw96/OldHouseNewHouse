package com.woong.happyhouse.model.service;

import java.util.Map;

import com.woong.happyhouse.model.dto.User;

public interface UserService {
	public User login(Map<String, String> map) throws Exception; // 로그인

	public void memberUpdate(User user) throws Exception; // 회원정보 수정
	
	public User memberView(String id) throws Exception; // 회원정보 조회

	public void signup(User user) throws Exception; // 회원가입

	public void passwdUpdate(User user) throws Exception; // 비밀번호 업데이트
	
	public void memberDelete(String id) throws Exception; // 회원탈퇴
}
