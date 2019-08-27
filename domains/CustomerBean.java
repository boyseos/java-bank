package com.bank.web.domains;

public class CustomerBean extends MemberBean{
	private int credit;
	
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	@Override
	public String toString() {
		return String.format("고객정보 credit = %d\n"
				+ "ID = %d\n"
				+ "PASS = %s\n"
				+ "Name = %s\n"
				+ "ssn = %s\n", credit, getId(),getPass(),getName(),getSsn());
				
	}
}
