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
		/* 추가 된 부분 */
		if (command.equals("board_list")) {
			action = new BoardListAction(); // 목록

		} else if (command.equals("board_write_form")) {
			action = new BoardWriteFormAction(); // 등록 화면

		} else if (command.equals("board_write")) {
			action = new BoardWriteAction(); // 실제 등록

		} else if (command.equals("board_view")) {
			action = new BoardViewAction(); // 상세보기

		} else if (command.equals("board_check_pass_form")) {
			action = new BoardCheckPassFormAction(); // 수정, 삭제 시 비밀번호 입력

		} else if (command.equals("board_check_pass")) {
			action = new BoardCheckPassAction(); // 수정, 삭제 시 비밀번호 확인

		} else if (command.equals("board_update_form")) {
			action = new BoardUpdateFormAction(); // 수정 화면

		} else if (command.equals("board_update")) {
			action = new BoardUpdateAction(); // 실제 수정

		} else if (command.equals("board_delete")) {
			action = new BoardDeleteAction(); // 실제 삭제

		}
		return action;

	}
}