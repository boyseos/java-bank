package services;
import beans.AdminBean;
import beans.CustomerBean;
import beans.MemberBean;

public interface MemberService {
	public void join(MemberBean param);
	public CustomerBean[] findAllCustomers();
	public AdminBean[] findAllAdmins();
	public MemberBean[] findByName(String name);
	public MemberBean findById(String id);
	public boolean login(MemberBean param);
	public int countMembers();
	public boolean existId(String id);
	public void updatePass(MemberBean param);
	public void deleteMember(MemberBean param);
}
