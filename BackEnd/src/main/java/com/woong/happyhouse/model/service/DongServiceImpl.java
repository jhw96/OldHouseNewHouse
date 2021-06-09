package com.woong.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woong.happyhouse.model.dao.DongCodeDao;
import com.woong.happyhouse.model.dto.DongCode;

@Service
public class DongServiceImpl implements DongService {

	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<DongCode> selectDong(String gugun) throws Exception{
		return sqlSession.getMapper(DongCodeDao.class).selectDong(gugun);
	}

}
