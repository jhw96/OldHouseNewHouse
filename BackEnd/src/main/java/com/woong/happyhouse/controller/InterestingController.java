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

import com.woong.happyhouse.model.dto.Interesting;
import com.woong.happyhouse.model.service.InterestingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Controller
@Api(value = "interesting")
public class InterestingController {
	@Autowired
	private InterestingService interestingService;
	
	@ResponseBody
	@ApiOperation(value="관심주택 추가하기")
	@RequestMapping(value="/interesting", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public String addInteresting(@RequestBody Map<String,String> map) {
		System.out.println("관심주택 추가");
		
		Interesting interesting = new Interesting();
		interesting.setUserid(map.get("id"));
		interesting.setDong(map.get("dong"));
		interesting.setAptName(map.get("aptName"));
		interesting.setLat(map.get("lat"));
		interesting.setLng(map.get("lng"));
		
		try {
			interestingService.addInteresting(interesting);
		} catch (Exception e) {
			e.printStackTrace();
			return "FAIL";
		}
		
		
		return "SUCCESS";
	}
	
	@ResponseBody
	@ApiOperation(value="관심주택 리스트 반환받기")
	@RequestMapping(value="/interesting", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public List<Interesting> showInterestingList(String id) {
		System.out.println("관심주택 조회");
		
		List<Interesting> list = null;
		
		try {
			list = interestingService.showInterestingList(id);
		} catch (Exception e) { // 에러처리
			e.printStackTrace();
			return null;
		}
		
		return list;
	}
	
	@ResponseBody
	@ApiOperation(value="관심주택 삭제하기")
	@RequestMapping(value="/interesting", method = RequestMethod.DELETE, headers = {"Content-type=application/json"})
	public String deleteInteresting(String id, String dong, String aptName) {
		System.out.println("관심주택 삭제");
		
		Interesting interesting = new Interesting();
		
		interesting.setUserid(id);
		interesting.setDong(dong);
		interesting.setAptName(aptName);
		
		try {
			interestingService.deleteInteresting(interesting);
		} catch (Exception e) { // 에러처리
			e.printStackTrace();
		}
		
		return "SUCCESS";
	}
	
	
}
