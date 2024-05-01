package service;

import dao.MemberDao;
import java.util.*;

import controller.MainController;

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
	
	MemberDao dao = MemberDao.getInstance();

	public boolean login(List<Object> param) {
		Map<String, Object> member = dao.login(param);
		if(member == null) {
			return false;
		}else {
			MainController.sessionStorage.put("member", member);
			return true;
		}
	}
	
	
	public void sign(List<Object> param) {
		dao.sign(param);
	}
	
}
