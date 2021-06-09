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

import com.woong.happyhouse.model.dto.Comment;
import com.woong.happyhouse.model.service.CommentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Controller
@Api("comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@ResponseBody
	@ApiOperation(value = "해당 글의 댓글들 반환하기")
	@RequestMapping(value="/comment", method = RequestMethod.GET)
	public List<Comment> selectByBoard(int boardno) { // 해당 글의 댓글들 불러오기
		System.out.println("댓글 목록 불러오기");
		List<Comment> list = null;
		try {
			list = commentService.selectByBoard(boardno);
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		return list;
	}
	
	@ResponseBody
	@ApiOperation(value = "해당 글에 댓글달기")
	@RequestMapping(value="/comment", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public String writeComment(@RequestBody Map<String,String> map) {
		System.out.println("댓글달기");
		Comment comment = new Comment();
		comment.setBoardno(Integer.parseInt(map.get("boardno")));
		comment.setUserid(map.get("userid"));
		comment.setContent(map.get("content"));
		
		try {
			commentService.writeComment(comment);
		} catch (Exception e) {
			e.printStackTrace();
			return "FAIL";
		}
		
		return "SUCCESS";
	}
	
	@ResponseBody
	@ApiOperation(value = "댓글 수정하기")
	@RequestMapping(value="/comment", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	public String modifyComment(@RequestBody Comment comment) {
		System.out.println("댓글수정");

		try {
			commentService.modifyComment(comment);
		} catch (Exception e) {
			e.printStackTrace();
			return "FAIL";
		}
		
		return "SUCCESS";
	}
	
	@ResponseBody
	@ApiOperation(value="댓글 삭제하기")
	@RequestMapping(value="/comment", method = RequestMethod.DELETE,  headers = { "Content-type=application/json" })
	public String deleteComment(String userid, String boardno, String regtime) {
		System.out.println("댓글삭제");
		
		Comment comment = new Comment();
		comment.setUserid(userid);
		comment.setBoardno(Integer.parseInt(boardno));
		comment.setRegtime(regtime);
		
		try {
			commentService.deleteComment(comment);
		} catch (Exception e) {
			e.printStackTrace();
			return "FAIL";
		}
		
		return "SUCCESS";
	}

}
