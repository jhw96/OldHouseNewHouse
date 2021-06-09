package com.woong.happyhouse.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woong.happyhouse.model.dao.BoardDao;
import com.woong.happyhouse.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void registBoard(Board board) throws Exception {
		sqlSession.getMapper(BoardDao.class).registBoard(board);
	}

	@Override
	public List<Board> selectAll() {
		
		return sqlSession.getMapper(BoardDao.class).selectAll();
	}

	@Override
	public Board select(int no) {
		return sqlSession.getMapper(BoardDao.class).select(no);
	}

	@Override
	public void modifyBoard(Board board) throws Exception {
		sqlSession.getMapper(BoardDao.class).modifyBoard(board);
	}

	@Override
	public void deleteBoard(int no) throws Exception {
		sqlSession.getMapper(BoardDao.class).deleteBoard(no);
	}

}
