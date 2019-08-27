package com.bank.web.serviceimpls;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import com.bank.web.domains.AccountBean;
import com.bank.web.services.AccountService;

public class AccountServiceImpl implements AccountService{
	private AccountBean[] members = null;
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
		while (existAccountNum(createAccountNum())) {
			members[count].setAccountNum(createAccountNum());
		}
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
		for(int i = 0; i < count; i++) {
			if(accountNum.equals(members[i].getAccountNum())) {
				break;
			}
			num++;
		}
		return members[num];
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		AccountBean temp = findByAccountNum(accountNum);
		return temp.getAccountNum() == null;
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
		//temp 와 파인드아이디로 찾은 인스턴스는 참조하는 주소는 같을지언정 다른존재다.
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
