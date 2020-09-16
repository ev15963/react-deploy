package board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import board.dao.BoardDAO;
import board.dto.BoardDTO;

public class ListActionController implements Controller {

	BoardDAO dao;	//BoardDAO dao = new BoardDAO();
	
	/***
	 * <bean name="/list.do" class="board.controller.ListActionController">
	 * 		<property name="dao">
	 * 			<ref bean="boardDAO" />
	 * 		</property>
	 * </bean> 에 의해서 자동 주입(스프링의 DI 개념 적용)
	 */
	
	public void setDao(BoardDAO dao) {
		this.dao = dao;
		System.out.println("setDao() 호출됨(dao) : "+dao);
	}
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		System.out.println("ListActionController 실행됨!");
		
		ArrayList<BoardDTO> list = dao.list();
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("list");		//list.jsp
		mav.addObject("list", list); //k, v
		//requset.setArribute("list", list);
		return mav; //dispater에게 전송
	}

}
