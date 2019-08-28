package com.bank.web.serviceimpls;

import com.bank.web.domains.AdminBean;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.services.MemberService;

public class MemberServiceImpl implements MemberService{
	private CustomerBean[] members;
	private AdminBean[] aMembers;
	private int cusCount, adCount;

	
	public MemberServiceImpl() {
		members = new CustomerBean[10];
		aMembers = new AdminBean[10];
		cusCount = 0;
	}
	
	@Override
	public void join(CustomerBean param) {
		members[cusCount] = param;
		cusCount++;
	}

	@Override
	public void register(AdminBean param) {
		aMembers[adCount] = param;
		adCount++;
	}
	@Override
	public MemberBean[] findByName(String name) {
		int num1 = 0, num2 = 0, num3 = 0;
		//MemberBean[] members = new MemberBean[3];
		for(int i = 0; i < cusCount; i++) {
			if(name.equals(this.members[i].getName())) {
				 num1++;
			}
		}
		for(int i = 0; i < adCount; i++) {
			if(name.equals(this.aMembers[i].getName())) {
				 num2++;
			}
		}
		num3 = num1 + num2; //동명이인의 수
		MemberBean[] members = new MemberBean[num3];
		int j = 0;
		for (int i = 0; i< cusCount; i++) {
			if(name.equals(this.members[i].getName())) {
				members[j] = this.members[i];
				j++;
				if (num1 == j) {
					break;
				}
			}
		}
		for (int i = 0; i< adCount; i++) {
			if(name.equals(this.aMembers[i].getName())) {
				members[j] = this.aMembers[i];
				j++;
				if (num3 == j) {
					break;
				}
			}
		}
		return members;
	}

	@Override
	public MemberBean findById(String id) {
//		int num = 0;
//		for(int i = 0; i < cusCount; i++) {
//			if(id.equals(members[i].getId())) {
//				 num++;
//				 break;
//			}
//		}
		MemberBean m = new MemberBean();
		for(int i = 0; i< cusCount; i++) {
			if(id.equals(members[i].getId())) {
				m = members[i];
				break;
				}
		}
		for(int i = 0; i< adCount; i++) {
			if(id.equals(aMembers[i].getId())) {
				m = aMembers[i];
				break;
				}
		}
		return m;
	}

	@Override
	public boolean login(MemberBean param) {
//		for(int i = 0; i < cusCount; i++) {
//			if(param.getId().equals(members[i].getId()) 
//					&& param.getPass().equals(members[i].getPass())) {
//				 is = true;
//				 break;
//			}
//		}
		return findById(param.getId()).getPass()
				.equals(param.getPass());
	}


	@Override
	public boolean existId(String id) {
		//boolean is = false;
//		for(int i = 0; i < cusCount; i++) {
//			if(id.equals(members[i].getId())) {
//				 is = true;
//				 break;
//			}
//		}
//		if (!is) {
//			for (int i = 0; i < adCount; i++) {
//				if (id.equals(aMembers[i].getId())) {
//					is = true;
//					break;
//				}
//			}
//		}
		return findById(id).getId() == null;
		//return is;
	}

	@Override
	public void updatePass(MemberBean param) {
		String id = param.getId();		
		String[] arr = param.getPass().split(",");
		String oldPass = arr[0], newPass = arr[1];
		param.setPass(oldPass);
		if(login(param)) {
			for(int i = 0; i< cusCount; i++) {
				if(id.equals(members[i].getId())) {
					members[i].setPass(newPass);
					break;
					}
			}
			for(int i = 0; i< adCount; i++) {
				if(id.equals(aMembers[i].getId())) {
					aMembers[i].setPass(newPass);
					break;
					}
			}
		}
		
	/**	
	 * 2안 아이디이용
		MemberBean temp = findById(param.getId());
		if(temp.getId().equals(id)){
			temp.setPass(param.getPass().split(",")[1]);
		}
		**/
		
//		boolean is = true;
//		for (int i = 0; i < cusCount; i++) {
//			if (param.getId().equals(id) 
//					&& oldPass.equals(newPass)) {
//				members[i].setPass(newPass);
//				is = false;
//				break;
//			}
//		}
//		if (is) {
//			for (int i = 0; i < adCount; i++) {
//				if (param.getId().equals(id) 
//						&& oldPass.equals(newPass)) {
//					aMembers[i].setPass(newPass);
//					break;
//				}
//			}
//		}
	}

	@Override
	public void deleteMember(MemberBean param) {
		int num = 0;
		boolean is = true;
		for (int i = 0 ; i < cusCount; i++,num++) {
			if (param.getId().equals(members[i].getId())) {
				is = false;
				break;
			}
		}
		if (is) {
			num = 0;
			for (int i = 0 ; i < adCount; i++,num++) {
				if (param.getId().equals(aMembers[i].getId())) {
					break;
				}
			}
			adCount--;
			aMembers[num] = aMembers[adCount];
			aMembers[adCount] = null;
		} else {
			cusCount--;
			members[num] = members[cusCount];
			members[cusCount] = null;
		}
	}
//		int i = 0;
//		if(login(param)) {
//			for(; i< cusCount; i++)
//				if(members[i].getId().equals(param.getId())) {
//					members[i] = members[cusCount - 1];
//					cusCount--;
//					break;
//				}
//		}
//		i = 0;
//		if(login(param)) {
//			for(; i< adCount; i++)
//				if(aMembers[i].getId().equals(param.getId())) {
//					aMembers[i] = aMembers[cusCount - 1];
//					adCount--;
//					break;
//				}
//		}
//	}

	@Override
	public CustomerBean[] findAllCustomers() {
		return members;
	}

	@Override
	public AdminBean[] findAllAdmins() {
		return aMembers;
	}

	@Override
	public int countAdmins() {
		// TODO Auto-generated method stub
		return adCount;
	}

	@Override
	public int countCustomers() {
		return cusCount;
	}
	

}
