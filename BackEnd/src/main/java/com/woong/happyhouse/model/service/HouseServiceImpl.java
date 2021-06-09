package com.woong.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woong.happyhouse.model.dao.HouseDao;
import com.woong.happyhouse.model.dto.HouseDeal;
import com.woong.happyhouse.model.dto.HouseInfo;

@Service
public class HouseServiceImpl implements HouseService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<HouseInfo> searchByDong(String dong) throws Exception {
		return sqlSession.getMapper(HouseDao.class).searchByDong(dong); 
	}

	@Override
	public List<HouseDeal> selectHistory(Map<String, String> map) throws Exception {
		return sqlSession.getMapper(HouseDao.class).selectHistory(map);
	}

}
