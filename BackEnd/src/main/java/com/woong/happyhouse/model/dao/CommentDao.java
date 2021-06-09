package com.woong.happyhouse.model.dao;

import java.util.List;

import com.woong.happyhouse.model.dto.Comment;

public interface CommentDao {
	public List<Comment> selectByBoard(int boardno); // 해당 글의 댓글 불러오기
	
	public void writeComment(Comment comment); // 댓글 쓰기
	
	public void modifyComment(Comment comment); // 댓글 수정
	
	public void deleteComment(Comment comment); // 댓글 삭제
}
