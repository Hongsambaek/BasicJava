package service;

import java.util.List;
import java.util.Map;

import dao.FreeBoardDao;

public class FreeBoardService {
	private static FreeBoardService instance;

	private FreeBoardService() {

	}

	public static FreeBoardService getInstance() {
		if (instance == null) {
			instance = new FreeBoardService();
		}

		return instance;
	}
	
	FreeBoardDao dao = FreeBoardDao.getInstance();
	
	public List<Map<String,Object>>list(){
		return dao.list();
	}

	public Map<String, Object> detail(List<Object> param) {
		// TODO Auto-generated method stub
		return dao.detail(param);
	}
	
	public void delete(List<Object>param) {
		dao.delete(param);
	}

	public void insert(List<Object> param) {
		dao.insert(param);
		
	}
	public void update(List<Object> param) {
		dao.update(param);
		
	}
	
}
