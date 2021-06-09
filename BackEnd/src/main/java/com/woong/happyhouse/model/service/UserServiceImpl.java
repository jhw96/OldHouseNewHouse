package com.woong.happyhouse.model.service;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woong.happyhouse.model.dao.UserDao;
import com.woong.happyhouse.model.dto.User;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public User login(Map<String, String> map) throws Exception {
		return sqlSession.getMapper(UserDao.class).login(map);
	}

	@Override
	public void memberUpdate(User user) throws Exception {
		sqlSession.getMapper(UserDao.class).memberUpdate(user);
	}

	@Override
	public User memberView(String id) throws Exception {
		return sqlSession.getMapper(UserDao.class).memberView(id);
	}

	@Override
	public void signup(User user) throws Exception {
		sqlSession.getMapper(UserDao.class).signup(user);
	}

	@Override
	public void passwdUpdate(User user) throws Exception {
		sqlSession.getMapper(UserDao.class).passwdUpdate(user);
	}

	@Override
	public void memberDelete(String id) throws Exception {
		sqlSession.getMapper(UserDao.class).memberDelete(id);
	}

}
