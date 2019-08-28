package com.bank.web.domains;

public class CustomerBean extends MemberBean{
	private String credit;
	
	public String getCredit() {
		return credit;
	}
	public void setCredit(String credit) {
		this.credit = credit;
	}
	@Override
	public String toString() {
		return String.format("고객정보\n credit = %s   \t"
				+ "ID = %s   \t"
				+ "PASS = %s   \t"
				+ "Name = %s   \t"
				+ "ssn = %s   \t", credit, getId(),getPass(),getName(),getSsn());
				
	}
}
