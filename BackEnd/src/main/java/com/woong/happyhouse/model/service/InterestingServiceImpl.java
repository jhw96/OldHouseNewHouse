package com.woong.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woong.happyhouse.model.dao.InterestingDao;
import com.woong.happyhouse.model.dto.Interesting;

@Service
public class InterestingServiceImpl implements InterestingService {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addInteresting(Interesting interesting) throws Exception { // 관심주택 추가하기
		sqlSession.getMapper(InterestingDao.class).addInteresting(interesting);
	}

	@Override
	public List<Interesting> showInterestingList(String userid) throws Exception { // 유저의 관심주택 목록 불러오기
		return sqlSession.getMapper(InterestingDao.class).showInterestingList(userid);
	}

	@Override
	public void deleteInteresting(Interesting interesting) throws Exception { // 관심주택 삭제하기
		sqlSession.getMapper(InterestingDao.class).deleteInteresting(interesting);
	}

	
}
