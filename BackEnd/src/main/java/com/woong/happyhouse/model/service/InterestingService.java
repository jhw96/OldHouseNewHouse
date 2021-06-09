package com.woong.happyhouse.model.service;

import java.util.List;

import com.woong.happyhouse.model.dto.Interesting;

public interface InterestingService {
	public void addInteresting(Interesting interesting) throws Exception; // 관심주택 추가하기
	
	public List<Interesting> showInterestingList(String userid) throws Exception; // 관심주택 목록 불러오기
	
	public void deleteInteresting(Interesting interesting) throws Exception; // 관심주택 삭제하기
}
