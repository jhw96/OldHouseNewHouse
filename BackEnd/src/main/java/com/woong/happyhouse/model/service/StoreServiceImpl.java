package com.woong.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woong.happyhouse.model.dao.StoreDao;
import com.woong.happyhouse.model.dto.StoreInfo;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private SqlSession sqlSession;
	@Override
	public List<StoreInfo> searchByDong(String dong) throws Exception{ // 동에 따른 상권정보 검색 
		
		return sqlSession.getMapper(StoreDao.class).searchByDong(dong);
	}

}
