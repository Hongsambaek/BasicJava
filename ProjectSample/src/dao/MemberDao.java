package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class MemberDao {
	
	private static MemberDao instance;

	private MemberDao() {

	}

	public static MemberDao getInstance() {
		if (instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();	
	
	public Map<String, Object> login(List<Object> param) {
		
		String sql = "SELECT *\r\n" + 
					 "FROM MEMBER\r\n" + 
					 "WHERE MEM_ID = ?\r\n" + 
					 "AND MEM_PASS = ?";
		
		return jdbc.selectOne(sql, param);
		
	}
	
	public void sign(List<Object> param) {
		String sql = "INSERT INTO JAVA_MEMBER\r\n" + 
					 "VALUES((SELECT NVL(MAX(MEM_NO),0)+1 FROM JAVA_MEMBER),?, ? , ?, '')";
		jdbc.update(sql, param);
	}
	
}
