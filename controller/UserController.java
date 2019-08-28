package com.bank.web.controller;

import javax.swing.JOptionPane;

import com.bank.web.domains.AdminBean;
import com.bank.web.domains.CustomerBean;
import com.bank.web.domains.MemberBean;
import com.bank.web.serviceimpls.MemberServiceImpl;
import com.bank.web.services.MemberService;

public class UserController {
	public static void main(String[] args) {
		CustomerBean cMember = null;
		AdminBean aMember = null;
		MemberBean member = null;
		CustomerBean[] cMembers = null;
		AdminBean[] aMembers = null;
		MemberBean[] members = null;
		String[] arr = null;
		MemberService service = new MemberServiceImpl();
		String result = "";
		while(true) {
			switch(JOptionPane.showInputDialog("0.종료\n"
					+ "1.고객회원가입\n"
					+ "2.사원회원가입\n"
					+ "3.로그인\n"
					+ "4.비번변경\n"
					+ "5.회원탈퇴\n"
					+ "6.이름검색\n"
					+ "7.고객정보\n"
					+ "8.사원정보")) {
			case "0": return;
			case "1":
				cMember = new CustomerBean();
				arr = JOptionPane.showInputDialog("아이디,패스워드,이름,민번,신용등급").split(",");
				if(!service.existId(arr[0])){
					arr[0] = JOptionPane.showInputDialog("같은아이디가 있습니다. 다시 입력해주세요");
				}
				cMember.setId(arr[0]);
				cMember.setPass(arr[1]);
				cMember.setName(arr[2]);
				cMember.setSsn(arr[3]);
				cMember.setCredit(arr[4]);
				service.join(cMember);//조인메소드 파라미터를 스트링으로 해서 받은 스트링을 바로 넘겨버리는게 더 깔끔하지않나? 보안때문에 이리한다했었나.
				break;
			case "2":
				aMember = new AdminBean();
				arr = JOptionPane.showInputDialog("아이디,패스워드,이름,민번,사원번호").split(",");
				if(!service.existId(arr[0])){
					arr[0] = JOptionPane.showInputDialog("같은아이디가 있습니다. 다시 입력해주세요");
				}
				aMember.setId(arr[0]);
				aMember.setPass(arr[1]);
				aMember.setName(arr[2]);
				aMember.setSsn(arr[3]);
				aMember.setSabun(arr[4]);
				service.register(aMember);
				break;
			case "3":
				member = new MemberBean();
				member.setId(JOptionPane.showInputDialog("아이디"));
				member.setPass(JOptionPane.showInputDialog("패스워드"));
				JOptionPane.showMessageDialog(null, service.login(member) ? "로그인 성공" : "로그인 실패");
				break;
			case "4":
				member = new MemberBean();
				arr = JOptionPane.showInputDialog("아이디-구비번,신비번").split("-");
				member.setId(arr[0]);
				member.setPass(arr[1]);
				service.updatePass(member);
				break;
			case "5":
				member = new MemberBean();
				member.setId(JOptionPane.showInputDialog("아이디"));
				member.setPass(JOptionPane.showInputDialog("패스워드"));
				service.deleteMember(member);
				break;
			case "6":
				members = service.findByName(JOptionPane.showInputDialog("이름"));
				for(int i = 0; i < members.length; i++) {
					result += members[i] + "\n";
				}
				JOptionPane.showMessageDialog(null, result);
				result = "";
				break;
			case "7":
				cMembers = service.findAllCustomers();
				for(int i = 0; i < cMembers.length; i++) {
					if(cMembers[i] == null)	break;
					result += cMembers[i] + "\n";
				}
				result += service.countCustomers() + "명";
				JOptionPane.showMessageDialog(null, result);
				result = "";
				break;
			case "8":
				aMembers = service.findAllAdmins();
				for(int i = 0; i < aMembers.length; i++) {
					if(aMembers[i] == null) break;
					result += aMembers[i] + "\n";
				}
				result += service.countAdmins() + "명";
				JOptionPane.showMessageDialog(null, result);
				result = "";
				break;
			}
		}
	}

}
