package serviceimpls;

import beans.AdminBean;
import beans.CustomerBean;
import beans.MemberBean;
import services.MemberService;

public class MemberServiceImpl implements MemberService{
	private MemberBean[] members = null;
	private CustomerBean[] cMembers = null;
	private AdminBean[] aMembers = null;
	private int count;
	String[] arr = null;
	
	public MemberServiceImpl() {
		members = new MemberBean[10];
		cMembers = new CustomerBean[10];
		aMembers = new AdminBean[10];
		count = 0;
	}
	
	@Override
	public void join(MemberBean param) {
		members[count] = param;
		count++;
	}

	@Override
	public MemberBean[] findByName(String name) {
		int num = 0;
		MemberBean[] members = new MemberBean[3];
		for(int i = 0; i < count; i++) {
			if(name.equals(this.members[i].getName())) {
				 num++;
				 break;
			}
		}
		num = 0;
		for (int i = 0; i< count; i++) {
			if(name.equals(this.members[i].getName())) {
				members[num] = this.members[i];
				num++;
				if (num == members.length) {
					break;
				}
			}
		}
		return members;
	}

	@Override
	public MemberBean findById(String id) {
		int num = 0;
		for(int i = 0; i < count; i++) {
			if(id.equals(members[i].getId())) {
				 num++;
				 break;
			}
		}
		return members[num];
	}

	@Override
	public boolean login(MemberBean param) {
		boolean is = false;
		for(int i = 0; i < count; i++) {
			if(param.getId().equals(members[i].getId()) && param.getPass().equals(members[i].getPass())) {
				 is = true;
				 break;
			}
		}
		return is;
	}

	@Override
	public int countMembers() {
		return count;
	}

	@Override
	public boolean existId(String id) {
		boolean is = false;
		for(int i = 0; i < count; i++) {
			if(id.equals(members[i].getId())) {
				 is = true;
				 break;
			}
		}
		return is;
	}

	@Override
	public void updatePass(MemberBean param) {
		arr = new String[2];
		arr = param.getPass().split(",");
		for (int i = 0; i < count; i++) {
			if (param.getId().equals(members[i].getId()) && arr[0].equals(members[i].getPass())) {
				members[i].setPass(arr[1]);
				break;
			}
		}
	}

	@Override
	public void deleteMember(MemberBean param) {
		int num = 0;
		for (int i = 0; i < count; i++) {
			if (param.getId() == members[i].getId()) {
				num++;
				break;
			}
		}
		count--;
		members[num] = members[count];
		members[count] = null;
	}

	@Override
	public CustomerBean[] findAllCustomers() {
		return cMembers;
	}

	@Override
	public AdminBean[] findAllAdmins() {
		return aMembers;
	}

}
