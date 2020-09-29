package com.lsw.controller.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lsw.dao.BoardDAO;
import com.lsw.vo.BoardVO;

public class BoardCheckPassAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		String num=request.getParameter("num");
		//boardView.jsp에서 보낸 값을 
		//<input type="hidden" name="num" value="${param.num}">
		
		String pass=request.getParameter("pass");
		//<input type="password" name="pass" size="20">
		
		BoardDAO bDao = BoardDAO.getInstance();
		BoardVO bVo = bDao.selectOnBoardByNum(num);
		//select * from boardtest1 where num = ? 상세보기 DAO에
		//getParameter로 num값으로 찾은 bVO에 컬럼의 레코드값을 저장
		
		if(bVo.getPass().equals(pass)) { //pass 성공시
			url = "view/checkSuccess.jsp";
			//num로 찾은 bVo입력된 값의 pass가 request로 받은 pass값이 맞다면
			
		} else {
			url="view/boardCheckPass.jsp";
			request.setAttribute("message", "비밀번호 틀렸습니다.");
			//boardCheckPass.jsp의 ${message}키에 값을 뿌린다.
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url); //if 조건에 맞는 url 연결
		dispatcher.forward(request, response);
	}

}
