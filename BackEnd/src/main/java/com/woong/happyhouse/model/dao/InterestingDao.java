package com.woong.happyhouse.model.dao;

import java.util.List;

import com.woong.happyhouse.model.dto.Interesting;

public interface InterestingDao {
	public void addInteresting(Interesting interesting); // 관심주택 추가하기
	
	public List<Interesting> showInterestingList(String userid); // 관심주택 목록 불러오기
	
	public void deleteInteresting(Interesting interesting); // 관심주택 삭제하기
}
