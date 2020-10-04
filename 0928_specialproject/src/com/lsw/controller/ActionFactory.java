package com.lsw.controller;

import com.lsw.controller.action.Action;
import com.lsw.controller.action.BoardCheckPassAction;
import com.lsw.controller.action.BoardCheckPassFormAction;
import com.lsw.controller.action.BoardDeleteAction;
import com.lsw.controller.action.BoardUpdateAction;
import com.lsw.controller.action.BoardUpdateFormAction;
import com.lsw.controller.action.BoardViewAction;
import com.lsw.controller.action.BoardWriteAction;
import com.lsw.controller.action.BoardWriteFormAction;

public class ActionFactory {
	
	private static ActionFactory instance = new ActionFactory();
	//싱글톤
	//ActionFactory의 인자를 instance이란  이름으로 만들어서 static을 단 한번만
	//인스턴스화한 후 private로 지정하여 ActionFactory class (현재클래스)에서만 사용하게 된다.
	//static은 본인 자신을 사용한다.
	
	private ActionFactory() {
		super();
	}
	
	public static ActionFactory getInstance() {
		return instance; //싱글톤 static으로 파리미터를 사용 
	}
	
	public Action getAction (String command) {
		Action action =null;
		System.out.println("ActionFactory :"+command);
		
		if(command.equals("board_list")) {
			action=new BoardListAction(); 
			//action 클래스의 기능 action에 boardlistaction.java의 BoardlistAction()메소드 실행
		} else if(command.equals("board_write_form")) { //만약 command키 값이 equals(문자열 비교) "board_write_form
			action = new BoardWriteFormAction();
			
			//action클래스의 기능 action에 boardwriteformaction.java의 boardwriteformaction() 메소드 실행
		} else if(command.equals("board_write")) { //글을 쓰고 list로 보내는 경로가기
			action = new BoardWriteAction();
		} else if(command.equals("board_view")) { //글을 쓰고 list로 보내는 경로가기
			action = new BoardViewAction();
		} else if(command.equals("board_check_pass_form")) { //글을 쓰고 list로 보내는 경로가기
			action = new BoardCheckPassFormAction();
		} else if(command.equals("board_check_pass")) { //글을 쓰고 list로 보내는 경로가기
			action = new BoardCheckPassAction();
		} else if(command.equals("board_update_form")) { //글을 쓰고 list로 보내는 경로가기
			action = new BoardUpdateFormAction();
		} else if(command.equals("board_update")) { //글을 쓰고 list로 보내는 경로가기
			action = new BoardUpdateAction();
		} else if(command.equals("board_delete")) { //글을 쓰고 list로 보내는 경로가기
			action = new BoardDeleteAction();
		}
 		return action; //action에 담긴 값을 돌려준다
 		//다른곳에서 getAction() 호출한다면 BoardAction()을 실행하게 된다.
	}
	
	
}
