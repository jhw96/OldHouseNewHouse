package com.woong.happyhouse.model.dao;

import java.sql.SQLException;
import java.util.Map;

import com.woong.happyhouse.model.dto.User;

public interface UserDao {
	public User login(Map<String, String> map) throws SQLException;

	public void memberUpdate(User user) throws SQLException; // 회원수정

	public User memberView(String id) throws SQLException; // 회원정보 조회

	public void signup(User user) throws SQLException; // 회원가입

	public void passwdUpdate(User user) throws SQLException; // 비밀번호 변경

	public void memberDelete(String id) throws SQLException; // 회원탈퇴
}
