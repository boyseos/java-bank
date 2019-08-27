package com.bank.web.controller;

import javax.swing.JOptionPane;

import com.bank.web.domains.AccountBean;
import com.bank.web.serviceimpls.AccountServiceImpl;
import com.bank.web.services.AccountService;

public class UserController {
	public static void main(String[] args) {
		AccountBean member = null;
		AccountService service = new AccountServiceImpl();
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료\n"
					+ "1.통장개설"
					+ "2.")) {
			case "0": return;
			case "1":
				service.createAccount(Integer.parseInt(JOptionPane.showInputDialog("얼마를 넣으시겠습니까")));
				break;
			case "2":
				
				break;
			case "3":
				
				break;
			case "4":
				
				break;
			case "5":
				
				break;
			case "6":
				
				break;
			}
		}
	}

}
