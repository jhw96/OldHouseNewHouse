package com.woong.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woong.happyhouse.model.dto.StoreInfo;
import com.woong.happyhouse.model.service.StoreService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api("store")
public class StoreController {
	@Autowired
	private StoreService storeService;
	
	@ResponseBody
	@ApiOperation(value="동 검색에 따른 상권정보를 반환")
	@RequestMapping(value="/store", method = RequestMethod.GET)
	public List<StoreInfo> searchByDong(String dong){
		System.out.println("법정동 상권정보 조회");
		
		List<StoreInfo> list = null;
		
		try {
		list = storeService.searchByDong(dong);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
