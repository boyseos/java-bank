package com.bank.web.domains;

public class AdminBean extends MemberBean{
	private int sabun;
	
	public int getSabun() {
		return sabun;
	}
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	
	@Override
	public String toString() {
		return String.format("운영자 sabun = %d\n"
				+ "ID = %d\n"
				+ "PASS = %s\n"
				+ "Name = %s\n"
				+ "ssn = %s\n", sabun, getId(),getPass(),getName(),getSsn());
				
	}
}
