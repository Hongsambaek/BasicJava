package service;

import java.util.List;

import controller.MainController;
import dao.MemberDao;
import vo.MemberVo;

public class MemberService {
	private static MemberService instance;

	private MemberService() {

	}

	public static MemberService getInstance() {
		if (instance == null) {
			instance = new MemberService();
		}
		return instance;
	}

	
	MemberDao memberDao = MemberDao.getInstance();
	
	public boolean login(List<Object> param, int role) {
		
		MemberVo member = memberDao.login(param);
		if(member == null) {
			return false;
		}
		if(role ==1) {
			MainController.sessionStorage.put("member", member);
		}
		if(role ==2) {
			MainController.sessionStorage.put("admin", member);
		}
		
		return true;
	}
	
}
