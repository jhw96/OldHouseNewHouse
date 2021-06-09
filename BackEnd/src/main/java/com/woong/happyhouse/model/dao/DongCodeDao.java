package com.woong.happyhouse.model.dao;

import java.util.List;

import com.woong.happyhouse.model.dto.DongCode;

public interface DongCodeDao {
	public List<DongCode> selectDong(String gugun);
}
