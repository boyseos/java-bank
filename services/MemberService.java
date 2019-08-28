package com.bank.web.services;
import com.bank.web.domains.AdminBean;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.MemberBean;

public interface MemberService {
	public void join(CustomerBean param);
	public void register(AdminBean param);
	public boolean login(MemberBean param);
	public void updatePass(MemberBean param);
	public void deleteMember(MemberBean param);
	public MemberBean[] findByName(String name);
	public MemberBean findById(String id);
	public boolean existId(String id);
	public CustomerBean[] findAllCustomers();
	public AdminBean[] findAllAdmins();
	public int countCustomers();
	public int countAdmins();
	
	
}