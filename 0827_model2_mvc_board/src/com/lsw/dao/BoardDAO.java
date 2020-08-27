package com.lsw.dao;

import java.util.List;

import com.lsw.dto.BoardVO;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();

	private BoardDAO() {

	}

	public static BoardDAO getInstance() {
		return instance;

	}

	public List<BoardVO> selectAllBoards() {
		return null;

	}

	public void insertBoard(BoardVO bVo) {

	}

	public void updateReadCount(String num) {

	}

	// 게시판 글 상세 내용 보기 : 글번호로 찾아온다 : 실패 null
	public BoardVO selectOneBoardByNum(String num) {

	}

	public void updateBoard(BoardVO bVo) {

	}

	public BoardVO checkPassWord(String pass, String num) {

	}

	public void deleteBoard(String num) {

	}

}
