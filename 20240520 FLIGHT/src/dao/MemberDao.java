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
	
	public void sign(List<Object> param) {
		String sql = "insert into JAVA_MEMBER values\r\n" + 
				" ((select count(mem_no) + 1 from java_member),\r\n" + 
				" ?, ?, null, 'N', null) ";
		
		jdbc.update(sql,param);
	}
	
	public void update(List<Object> param) {
		String sql = "UPDATE CUSTOMER\r\n" + 
				"SET \r\n" + 
				"CUS_ID = ?\r\n" + 
				",CUS_PW = ?\r\n" + 
				",CUS_NAME = ?\r\n" + 
				",CUS_PASS = ?\r\n" + 
				",CUS_TELNO= ?\r\n" + 
				",CUS_ADDRESS = ? \r\n" + 
				"WHERE CUS_NO = ?";
		
	 jdbc.update(sql,param);
	}
	
	public Map<String, Object> login(List<Object> param) {
		String sql = "SELECT *\r\n" + 
				"FROM CUSTOMER \r\n" + 
				"WHERE CUS_ID = ?\r\n" + 
				"AND CUS_PW = ?\r\n";
		return jdbc.selectOne(sql, param);
	}
	public void insert(List<Object> param) {
		String sql = "insert into goods values"
				+ "(select nvl(max(no),0)+1 from goods),"
				+ " ?, ?, ?, 'N')";
		
		jdbc.update(sql,param);
	}
	public int delete(List<Object> param) {
		String sql = "update goods\r\n" + 
				"set delyn = 'Y'\r\n" + 
				"where no = ?";
		
		return jdbc.update(sql,param);
	}
	

	

	public int remove(List<Object> param) {
		String sql = "DELETE FROM CUSTOMER\r\n" + 
				"WHERE CUS_ID = ? AND CUS_PW = ?";
		
		return jdbc.update(sql, param);
	}

	public Map<String,Object> member(List<Object> param){
		 String sql = "SELECT* FROM CUSTOMER WHERE CUS_NO = ?";
		      
		      return jdbc.selectOne(sql, param);
	}

	public List<Map<String, Object>> list() {
		String sql = "select CUS_NAME, CUS_ID, CUS_PW, CUS_TELNO, CUS_RATING PRICE from CUSTOMER";
		
		return jdbc.selectList(sql);
		
	}
	
}
