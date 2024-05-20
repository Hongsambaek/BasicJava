package service;

import java.util.List;
import java.util.Map;

import controller.MainController;
import dao.MemberDao;

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
	
	public boolean login(List<Object> param) {
        Map<String, Object> member = memberDao.login(param);

        if (member == null) {
            return false;
        }

        //Login → CUS_NO를 세션에 저장
        MainController.sessionStorage.put("CUS_NO", member.get("CUS_NO"));
        MainController.sessionStorage.put("CUS_ID", member.get("CUS_ID"));
        MainController.sessionStorage.put("CUS_PW", member.get("CUS_PW"));
        
        return true;
    }
	
	public void sign(List<Object> param) {
		memberDao.sign(param);
	}
	public void update(List<Object> param) {
		memberDao.update(param);
		
	}
	
	public List<Map<String, Object>> list() {
		
		return memberDao.list();
	}

	public boolean remove(List<Object> param) {
		int member = memberDao.remove(param);
	    if (member == 0)
	        return false;
	    else
	        return true;
	}
	public Map<String, Object> member(List<Object> param) {
	
		return memberDao.member(param);
	}
	
}
