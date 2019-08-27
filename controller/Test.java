package com.bank.web.controller;

import javax.swing.JOptionPane;

import com.bank.web.domains.AccountBean;
import com.bank.web.serviceimpls.AccountServiceImpl;
import com.bank.web.services.AccountService;

public class Test {

	public static void main(String[] args) {
		AccountBean[] temps = new AccountBean[10];
		AccountBean temp = new AccountBean();
		AccountService s = new AccountServiceImpl();
		s.createAccount(555555);
		s.createAccount(222222);
		s.createAccount(333333);
		System.out.println(s.findAll()[0]);
		System.out.println(s.findAll()[1]);
		System.out.println(s.findAll()[2]);
		String acNum = JOptionPane.showInputDialog("계좌번호");
		//temp.setAccountNum(acNum);
		//temp.setMoney(JOptionPane.showInputDialog("출금할돈"));
		System.out.println(s.existAccountNum(acNum));
		s.deleteAccountNum(acNum);
		System.out.println(s.findAll()[0]);
		System.out.println(s.findAll()[1]);
		System.out.println(s.findAll()[2]);
	}

}
