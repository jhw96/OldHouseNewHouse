package com.woong.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woong.happyhouse.model.dto.DongCode;
import com.woong.happyhouse.model.service.DongService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Controller
@Api(value="dong")
public class DongController {

	@Autowired
	private DongService dongService;
	
	@CrossOrigin
	@ResponseBody
	@ApiOperation(value = "select option에서 구 선택시 동을 반환해준다.")
	@RequestMapping(value="/dong", method= RequestMethod.GET, headers = { "Content-type=application/json" }) 
	public List<DongCode> selectDong(String gugun) {
		List<DongCode> list = null;
		
		try {
			list = dongService.selectDong(gugun);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
}
