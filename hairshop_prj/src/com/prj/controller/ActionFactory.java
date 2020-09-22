package com.prj.controller;

import com.prj.controller.action.*;
import com.prj.controller.action.Action;


public class ActionFactory {
	private static ActionFactory instance = new ActionFactory();


	public ActionFactory() {
		super();
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getaction(String command) {
		Action action = null;
		System.out.println("Actionfactory ===>  " + command);// 확인 코드
		
		if (command.equals("res_list")) {
			action = new ReservationListAction();
		} else if (command.equals("Admin_login")) {
			action = new LoginAction();			
		} else if (command.equals("reson_list")) {
			action = new ReservationOnListAction();
		} else if (command.equals("cusres_update")) {
			action = new CusResUpdateAction();
		} else if (command.equals("cusres_delete")) {
			action = new CusResDeleteAction ();
		} else if (command.equals("cusres_end")) {
			action = new CusResEndAction();
		} else if (command.equals("cus_insert")) {
			action = new CustomerInsertAction();
		} else if (command.equals("cus_list")) {
			action = new CustomerListAction ();
		} else if (command.equals("cus_delete")) {
			action = new CustomerDeleteAction();
		} else if (command.equals("cus_update")) {
			action = new CustomerUpdateAction ();
		} else if (command.equals("cus_detail")) {
			action = new CustomerDetailAction();
		} else if (command.equals("id_check_form")) {
			action = new IdCheckFormAction();
		} else if (command.equals("index")) {
			action = new IndexAction();
			
			// 고객(customer)
	      } else if (command.equals("cus_login_form")) {
	          action = new CusLoginFormAction();
	       } else if (command.equals("cus_login")) {
	          action = new CusLoginAction();
	       } else if (command.equals("cus_join")) {
	          action = new CusJoinAction();
	       } else if (command.equals("cus_join_form")) {
	          action = new CusJoinFormAction();
	       } else if (command.equals("cus_res_check")) {
	          action = new CusReservationCheckAction();
	       } else if (command.equals("cus_res_form")) {
	          action = new CusReservationFormAction();
	       } else if (command.equals("cus_index")) {
	          action = new CusIndexAction();
	       } else if (command.equals("cus_logout")) {
	          action = new CusLogoutAction();
		
		return action;
	}
}