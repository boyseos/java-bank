package com.bank.web.domains;

public class AccountBean {
	private String accountNum, today, money;
	
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getToday() {
		return today;
	}
	public void setToday(String today) {
		this.today = today;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	@Override
	public String toString() {
		return "계좌정보 [계좌번호=" + accountNum + ","
				+ " 거래일자=" + today + ","
						+ " 돈=" + money + "]";
	}
}
