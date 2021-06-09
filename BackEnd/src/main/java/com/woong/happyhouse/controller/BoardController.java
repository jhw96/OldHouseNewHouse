package com.woong.happyhouse.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woong.happyhouse.model.dto.Board;
import com.woong.happyhouse.model.service.BoardService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin
@Controller
@Api(value="board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@ResponseBody
	@ApiOperation(value="게시판 전체 조회")
	@RequestMapping(value="/board/list", method = RequestMethod.GET)
	public List<Board> selectAll() { // 게시글 전체 조회
		System.out.println("게시판 전체 조회");
		return boardService.selectAll();
	}
	
	@ResponseBody
	@ApiOperation(value="게시글 등록")
	@RequestMapping(value="/board", method= RequestMethod.POST, headers = { "Content-type=application/json" }) 
	public String registBoard(@RequestBody Map<String, String> map) { // 게시글 등록
		System.out.println("게시글 등록");
		String writer = map.get("writer");
		String title = map.get("title");
		String content = map.get("content");
		
		Board board = new Board();
		board.setWriter(writer);
		board.setTitle(title);
		board.setContent(content);
		try {
			boardService.registBoard(board);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAIL";
		}
		return "SUCCESS";
	}
	
	@ResponseBody
	@ApiOperation(value="게시글 상세 조회")
	@RequestMapping(value="/board", method = RequestMethod.GET)
	public Board select(int no) { // 게시글 상세조회
		System.out.println("게시글 상세조회");
		return boardService.select(no);
	}
	
	@ResponseBody
	@ApiOperation(value="게시글 수정")
	@RequestMapping(value="/board", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	public String modifyBoard(@RequestBody Map<String, String> map) { // 게시글 수정
		System.out.println("게시글 수정");
		
		int no = Integer.parseInt(map.get("no"));
		String title = map.get("title");
		String content = map.get("content");
		
		Board board = new Board();
		board.setNo(no);
		board.setTitle(title);
		board.setContent(content);
		
		try {
			boardService.modifyBoard(board);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "FAIL";
		}
		return "SUCCESS";
	}
	
	@ResponseBody
	@ApiOperation(value="게시글 삭제")
	@RequestMapping(value="/board/{no}", method = RequestMethod.DELETE, headers = { "Content-type=application/json" })
	public String deleteBoard(@PathVariable("no") String no) { // 게시글 삭제
		int newNo = Integer.parseInt(no);
		try {
			boardService.deleteBoard(newNo);
		} catch (Exception e) {
			e.printStackTrace();
			return "FAIL";
		}
		
		return "SUCCESS";
	}
}
