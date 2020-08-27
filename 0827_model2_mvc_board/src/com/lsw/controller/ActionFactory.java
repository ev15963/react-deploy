package com.lsw.controller;

import com.lsw.controller.action.*;

//SingleTone
public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);

		/* 추가된 부분 */
		if (command.equals("board_list")) {
			action = new BoardListAction();
			
		} else if (command.equals("board_view")) { //상세보기
			action = new BoardViewAction();
			
		} else if (command.equals("board_check_pass_form")) { //수정 삭제시 비밀번호 입력
			action = new BoardCheckPassFormAction();
			
		} else if (command.equals("board_check_pass")) {	//수정 삭제시 비밀번호 확인
			action = new BoardCheckPassAction();
			
		} else if (command.equals("board_update_form")) {
			action = new BoardWriteFormAction();
			
		} else if (command.equals("board_write")) {
			action = new BoardWriteAction();
			
		} else if (command.equals("board_view")) {
			action = new BoardViewAction();
			
		} else if (command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFormAction();
			
		} else if (command.equals("board_check_pass")) {
			action = new BoardCheckPassAction();
			
		} else if (command.equals("board_update_form")) {
			action = new BoardUpdateFormAction();
			
		} else if (command.equals("board_update")) {
			action = new BoardUpdateAction();
			
		} else if (command.equals("board_delete")) {
			action = new BoardDeleteAction();
		}

		return action;
	}

}
