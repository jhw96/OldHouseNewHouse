package com.woong.happyhouse.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woong.happyhouse.model.dto.User;
import com.woong.happyhouse.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Controller
@Api("User")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	
	@ResponseBody
	@PostMapping("/user/login") // 로그인 처리
	@ApiOperation(value="로그인")
	public User login(@RequestBody Map<String, String> map) {
		System.out.println("로그인");
		User user = null;
		
		try {
			user = userService.login(map);

		} catch (Exception e) {
			e.printStackTrace();
			return user;
		}
		
		return user;
	}

	@GetMapping("/user/logout") // 로그아웃 처리
	@ApiOperation(value="로그아웃")
	public String logout(HttpSession session) {
		session.invalidate();
		return "home";
	}


	@ResponseBody
	@ApiOperation(value="회원가입")
	@RequestMapping(value = "/user/join", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public String join(@RequestBody Map<String,String> map) { // 회원가입 요청 처리
		System.out.println("회원가입");
		
		try {
			User check = userService.memberView(map.get("id"));
			if(check!=null)
				return "DUPLICATE";
		} catch (Exception e1) {
			e1.printStackTrace();
			return "FAIL";
		}
		
		User user = new User();
		user.setId(map.get("id"));
		user.setPw(map.get("pw"));
		user.setName(map.get("name"));
		user.setAddr(map.get("addr"));
		user.setTel(map.get("tel"));
		
		try {
			userService.signup(user);
		} catch (Exception e) {
			return "FAIL";
		}
		return "SUCCESS";
	}


	@ResponseBody
	@ApiOperation(value="회원정보 수정")
	@PutMapping("/user")
	public String modifyMember(@RequestBody Map<String, String> map,HttpSession session) {
		System.out.println("회원정보 수정");
		
		String id = map.get("id");
		String pw = map.get("pw");
		String name = map.get("name");
		String addr = map.get("addr");
		String tel = map.get("tel");
		

		if (id == null || pw == null || name == null || addr == null || tel == null)
			return null;
		
		User user = new User();
		user.setId(id);
		user.setPw(pw);
		user.setName(name);
		user.setAddr(addr);
		user.setTel(tel);

		try {
			userService.memberUpdate(user);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		session.setAttribute("loginUser", user);
		
		return "SUCCESS";
	}
	
	@ResponseBody
	@ApiOperation(value="회원정보 삭제")
	@RequestMapping(value = "/user", method = RequestMethod.DELETE, headers = { "Content-type=application/json" })
	public String remove(@RequestParam String id) {
		System.out.println("회원정보 삭제");
		
		try {
			userService.memberDelete(id);
		} catch (Exception e) {
			return "FAIL";
		}
		
		return "SUCCESS";
	}
}
