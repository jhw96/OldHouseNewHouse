package com.woong.happyhouse.model.service;

import java.util.List;

import com.woong.happyhouse.model.dto.StoreInfo;

public interface StoreService {
	public List<StoreInfo> searchByDong(String dong) throws Exception; // 동에 따른 상권정보 검색
}
