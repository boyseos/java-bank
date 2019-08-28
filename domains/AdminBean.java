package com.bank.web.domains;

public class AdminBean extends MemberBean{
	private String sabun;
	
	public String getSabun() {
		return sabun;
	}
	
	public void setSabun(String sabun) {
		this.sabun = sabun;
	}
	
	@Override
	public String toString() {
		return String.format("운영자\n sabun = %s    \t"
				+ "ID = %s    \t"
				+ "PASS = %s    \t"
				+ "Name = %s    \t"
				+ "ssn = %s    \t", sabun, getId(),getPass(),getName(),getSsn());
				
	}
}
