package com.bank.web.controller;

import javax.swing.JOptionPane;

import com.bank.web.domains.AccountBean;
import com.bank.web.serviceimpls.AccountServiceImpl;
import com.bank.web.services.AccountService;

public class AdminController {
	public static void main(String[] args) {
		AccountBean member = new AccountBean();
		AccountService service = new AccountServiceImpl();
		while (true) {
			switch (JOptionPane.showInputDialog("0.종료\n"
												+ "1.계좌개설\n"
												+ "2.입금\n"
												+ "3.출금\n"
												+ "4.계좌조회\n"
												+ "5.계좌삭제\n"
												+ "6.총 계좌수\n"
												+ "7.총 계좌확인\n")) {
			case "0":
				return;
			case "1":
				service.createAccount(Integer.parseInt(
						JOptionPane.showInputDialog("얼마를 넣으시겠습니까")));
				JOptionPane.showMessageDialog(null, "계좌생성");
				break;
			case "2":
				member.setAccountNum(
						JOptionPane.showInputDialog("계좌번호를 넣어주세요"));
				member.setMoney(
						JOptionPane.showInputDialog("얼마를 넣으시겠습니까"));
				service.depositMoney(member);
				JOptionPane.showMessageDialog(null, 
						service.findByAccountNum(member.getAccountNum()).toString());
				break;
			case "3":
				member.setAccountNum(JOptionPane
						.showInputDialog("계좌번호를 넣어주세요"));
				member.setMoney(JOptionPane
						.showInputDialog("얼마를 찾으시겠습니까"));
				service.withdrawMoney(member);
				JOptionPane.showMessageDialog(null,	service
						.findByAccountNum(member.getAccountNum()).toString());
				break;
			case "4":
				JOptionPane.showMessageDialog(null, 
						service.findByAccountNum(
								JOptionPane.showInputDialog(
										"계좌번호를 넣어주세요")).toString());
				break;
			case "5":
				service.deleteAccountNum(JOptionPane
						.showInputDialog("계좌번호를 넣어주세요"));
				JOptionPane.showMessageDialog(null, "계좌삭제");
				break;
			case "6":
				JOptionPane.showMessageDialog(null, 
						service.countAccounts()+"계좌");
				break;
			case "7":
				AccountBean[] aArr = new AccountBean[10]; 
				aArr = service.findAll();
				String result = "";
				for(int i = 0; i < aArr.length; i++) {
					if(aArr[i] == null) {
						break;
					}
					result += aArr[i]+"\n";
				}
				JOptionPane.showMessageDialog(null, result);
				break;
			}
		}
	}
}
