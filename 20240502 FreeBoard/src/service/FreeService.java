package service;

import java.util.List;
import java.util.Map;

import dao.FreeDao;

public class FreeService {  //복잫한 로직들을 service에 작성 = service를 통해 dao에서 control로 전송
	private static FreeService instance;

	private FreeService() {

	}

	public static FreeService getInstance() {
		if (instance == null) {
			instance = new FreeService();
		}
		return instance;
	}

	FreeDao dao = FreeDao.getInstance();

	public List<Map<String, Object>> list() {
		return dao.list();
	}
	
	public Map<String, Object> detail(List<Object> param){
		return dao.detail(param);
	}
	
	public void delete(List<Object> param) {
		dao.delete(param);
	}

	public void insert(List<Object> param) {
		// TODO Auto-generated method stub
		dao.insert(param);
	}
}

