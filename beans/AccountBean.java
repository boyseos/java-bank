package beans;

public class AccountBean {
	private int accountNum, today, money;
	
	public int getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	public int getToday() {
		return today;
	}
	public void setToday(int today) {
		this.today = today;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
