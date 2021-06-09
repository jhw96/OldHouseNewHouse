package com.woong.happyhouse.model.dao;

import java.util.List;

import com.woong.happyhouse.model.dto.StoreInfo;

public interface StoreDao {
	public List<StoreInfo> searchByDong(String dong); // 동에 따른 상권정보 검색
}
