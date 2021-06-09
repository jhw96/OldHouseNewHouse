package com.woong.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.woong.happyhouse.model.dto.HouseDeal;
import com.woong.happyhouse.model.dto.HouseInfo;

public interface HouseService {
	public List<HouseInfo> searchByDong(String dong) throws Exception; // 동 이름으로 검색

	public List<HouseDeal> selectHistory(Map<String, String> map) throws Exception; // 해당 아파트에 대한 상세 거래내역
}
