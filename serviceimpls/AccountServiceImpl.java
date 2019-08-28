package com.bank.web.serviceimpls;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.bank.web.domains.AccountBean;
import com.bank.web.services.AccountService;

public class AccountServiceImpl implements AccountService{
	private AccountBean[] members;
	private int count;
	
	public AccountServiceImpl() {
		members = new AccountBean[10];
		count = 0;
	}
	@Override
	public void createAccount(int money) {//계좌번호 랜덤 1234-5678생성
		members[count] = new AccountBean();
		members[count].setMoney(money+"");
		members[count].setToday(findDate());
		members[count].setAccountNum(createAccountNum());
//		while (count != 0 && existAccountNum(createAccountNum())) {
//			members[count].setAccountNum(createAccountNum());
//		} 일단 보류..
		count++;
	}

	@Override
	public String createAccountNum() {
		Random ran = new Random();
		return String.format("%04d-%04d", ran.nextInt(9999),ran.nextInt(9999));
	}

	@Override
	public String findDate() {
		return new SimpleDateFormat("yyyy-MM-dd hh:mm").format(new Date());
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		int num = 0;
		for(int i = 0 ; i < count; i++) {
			if(accountNum.equals(members[i].getAccountNum())) {
				break;
			}
			num++;
		}
		return members[num];
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		return findByAccountNum(accountNum) != null;
	}

	@Override
	public void depositMoney(AccountBean param) {
		AccountBean temp = findByAccountNum(param.getAccountNum());
		temp.setMoney(Integer.parseInt(temp.getMoney()) 
				+ Integer.parseInt(param.getMoney())+"");
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		AccountBean temp = findByAccountNum(param.getAccountNum());
		temp.setMoney(Integer.parseInt(temp.getMoney()) 
				- Integer.parseInt(param.getMoney())+"");
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		count--;
		AccountBean temp = findByAccountNum(accountNum);
		temp.setAccountNum(members[count].getAccountNum());
		temp.setMoney(members[count].getMoney());
		temp.setToday(members[count].getToday());
		members[count] = null;
	}

	@Override
	public AccountBean[] findAll() {
		return members;
	}
	
	@Override
	public int countAccounts() {
		return count;
	}
}
