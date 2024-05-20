package service;

import java.util.List;
import java.util.Map;

import controller.MainController;
import dao.CusInfoDao;

public class CusInfoService {
	private static CusInfoService instance;

	private CusInfoService() {

	}

	public static CusInfoService getInstance() {
		if (instance == null) {
			instance = new CusInfoService();
		}
		return instance;
	}

	CusInfoDao cusinfodao = CusInfoDao.getInstance();

	public void sign(List<Object> param) {
		cusinfodao.sign(param);
	}
	public boolean remove(List<Object> param) {
	    int member = cusinfodao.remove(param);
	    if (member == 0)
	        return false;
	    else
	        return true;
	}

	
	public boolean login(List<Object> param) {
		Map<String, Object> member = cusinfodao.login(param);
		if (member == null)
			return false;
		else {
			MainController.sessionStorage.put("member", member);
			return true;
		}

	}
}
