package com.woong.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woong.happyhouse.model.dto.HouseDeal;
import com.woong.happyhouse.model.dto.HouseInfo;
import com.woong.happyhouse.model.service.HouseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Controller
@Api(value = "house")
public class HouseController {

	@Autowired
	private HouseService houseService;

	@ApiOperation(value = "법정동의 주택 리스트를 반환")
	@ResponseBody
	@RequestMapping(value = "/house", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public List<HouseInfo> searchByDong(String dong) {
		System.out.println("법정동 주택 리스트 조회");
		
		List<HouseInfo> list = null;
		
		try {
			list = houseService.searchByDong(dong);
		} catch (Exception e) {
			e.printStackTrace();

		}

		return list;
	}

	@ApiOperation(value = "주택의 상세 거래내역을 반환")
	@ResponseBody
	@RequestMapping(value = "/house/detail", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public List<HouseDeal> selectHistory(@RequestParam Map<String, String> map) {
		System.out.println("선택한 주택 거래내역");
		
		List<HouseDeal> list = null;

		try {
			list = houseService.selectHistory(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
