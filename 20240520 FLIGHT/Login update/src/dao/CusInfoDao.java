package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class CusInfoDao {
	
	private static CusInfoDao instance;

	private CusInfoDao() {

	}

	public static CusInfoDao getInstance() {
		if (instance == null) {
			instance = new CusInfoDao();
		}
		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public void sign(List<Object> param) {
		String sql = "INSERT INTO CUSTOMER\r\n" + 
				     "VALUES(?, ?, ?, ?, ?, ?, ?, 0, ?)";
		jdbc.update(sql, param);
	}
	
	public int remove(List<Object> param) {
		String sql = "DELETE FROM CUSTOMER\r\n" + 
				"WHERE CUS_ID = ? AND CUS_PW = ?";
		
		return jdbc.update(sql, param);
		
		
	}
	
	
	public Map<String, Object>  login(List<Object> param) {
		String sql = "SELECT *\r\n" + 
					 "FROM CUSTOMER\r\n" + 
					 "WHERE CUS_ID = ?\r\n" + 
					 "AND CUS_PW = ?";
		
		return jdbc.selectOne(sql, param);
	}
}
