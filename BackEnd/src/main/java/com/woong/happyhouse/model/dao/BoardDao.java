package com.woong.happyhouse.model.dao;

import java.util.List;

import com.woong.happyhouse.model.dto.Board;

public interface BoardDao {
	public void registBoard(Board board); // 게시판 등록
	
	public List<Board> selectAll(); // 전체 게시판 조회
	
	public Board select(int no); // 게시판 상세조회
	
	public void modifyBoard(Board board); // 게시판 수정
	
	public void deleteBoard(int no); // 게시판 삭제
}
