package serviceimpls;

import beans.AccountBean;
import services.AccountService;
import java.util.Random;

public class AccountServiceImpl implements AccountService{
	private AccountBean[] members = null;
	private int count;
	
	public AccountServiceImpl() {
		members = new AccountBean[10];
		count = 0;
	}
	@Override
	public void createAccount(int money) {//계좌번호 랜덤 1234-5678생성
		String[] arr = new String[2];
		members[count] = new AccountBean();
		members[count].setMoney(money);
		System.out.println(members[count].getMoney());
		arr = this.createAccountNum().split("-");		
		System.out.println("44");
		members[count].setAccountNum(Integer.parseInt(arr[0]) * 10000 + Integer.parseInt(arr[1]));
		count++;
	}

	@Override
	public String createAccountNum() {
		Random ran = new Random();
		//int AccountNum1 = ran.nextInt(9999), AccountNum2 = ran.nextInt(9999);
		//return AccountNum1 + "-" + AccountNum2;
		return ran.nextInt(9999) + "-" + ran.nextInt(9999);
	}

	@Override
	public AccountBean[] findAll() {
		return members;
	}

	@Override
	public AccountBean findByAccountNum(String accountNum) {
		int num = 0;
		for(int i = 0; i < count; i++) {
			if(Integer.parseInt(accountNum) == members[i].getAccountNum()) {
				 num++;
				 break;
			}
		}
		return members[num];
	}

	@Override
	public int countAccounts() {
		return count;
	}

	@Override
	public boolean existAccountNum(String accountNum) {
		boolean is = false;
		for (int i = 0; i < count; i++) {
			if (Integer.parseInt(accountNum) == members[i].getAccountNum()) {
				is = true;
				break;
			}
		}
		return is;
	}

	@Override
	public String findDate() {
		
		return null;
	}

	@Override
	public void depositMoney(AccountBean param) {
		int num = 0;
		for (int i = 0; i < count; i++) {
			if (param.getAccountNum() == members[i].getAccountNum()) {
				num++;
				break;
			}
		}
		members[num].setMoney(members[num].getMoney() + param.getMoney());		
	}

	@Override
	public void withdrawMoney(AccountBean param) {
		int num = 0;
		for (int i = 0; i < count; i++) {
			if (param.getAccountNum() == members[i].getAccountNum()) {
				num++;
				break;
			}
		}
		members[num].setMoney(members[num].getMoney() - param.getMoney());		
	}

	@Override
	public void deleteAccountNum(String accountNum) {
		int num = 0;
		for (int i = 0; i < count; i++) {
			if (Integer.parseInt(accountNum) == members[i].getAccountNum()) {
				num++;
				break;
			}
		}
		count--;
		members[num] = members[count];
		members[count] = null;
	}
}
