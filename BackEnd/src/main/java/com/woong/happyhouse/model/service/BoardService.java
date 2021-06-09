package com.woong.happyhouse.model.service;

import java.util.List;

import com.woong.happyhouse.model.dto.Board;

public interface BoardService {
	public void registBoard(Board board) throws Exception; // 게시판 등록

	public List<Board> selectAll(); // 전체 게시판 조회

	public Board select(int no); // 게시판 상세조회

	public void modifyBoard(Board board) throws Exception; // 게시판 수정

	public void deleteBoard(int no) throws Exception; // 게시판 삭제
}
