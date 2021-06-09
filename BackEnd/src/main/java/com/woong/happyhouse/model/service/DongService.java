package com.woong.happyhouse.model.service;

import java.util.List;

import com.woong.happyhouse.model.dto.DongCode;

public interface DongService {
	public List<DongCode> selectDong(String gugun) throws Exception;
}
