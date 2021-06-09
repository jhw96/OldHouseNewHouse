package com.woong.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woong.happyhouse.model.dao.CommentDao;
import com.woong.happyhouse.model.dto.Comment;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<Comment> selectByBoard(int boardno) throws Exception {
		return sqlSession.getMapper(CommentDao.class).selectByBoard(boardno);
	}

	@Override
	public void writeComment(Comment comment) throws Exception {
		sqlSession.getMapper(CommentDao.class).writeComment(comment);

	}

	@Override
	public void modifyComment(Comment comment) throws Exception {
		sqlSession.getMapper(CommentDao.class).modifyComment(comment);
	}

	@Override
	public void deleteComment(Comment comment) throws Exception {
		sqlSession.getMapper(CommentDao.class).deleteComment(comment);
	}

}
