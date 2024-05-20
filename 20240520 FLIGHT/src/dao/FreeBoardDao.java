package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class FreeBoardDao {
	private static FreeBoardDao instance;

	private FreeBoardDao() {

	}

	public static FreeBoardDao getInstance() {
		if (instance == null) {
			instance = new FreeBoardDao();
		}

		return instance;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String,Object>> list(){
		String sql = "SELECT BOARD_NO,BOARD_NAME,REGDATE\r\n" + 
				"FROM FREEBOARD\r\n" + 
				"WHERE delyn = 'N'\r\n" + 
				"ORDER BY BOARD_NO";
	
		return jdbc.selectList(sql);
	
	}
	
	public Map<String,Object> detail(List<Object> param){
		 String sql = "SELECT BOARD_NAME 제목 , BOARD_NO 게시판번호, BOARD_CONTENT 내용, REGDATE 게시일 \r\n" + 
		 		"FROM FREEBOARD\r\n" + 
		 		"WHERE BOARD_NO = ? ";
		      
		      return jdbc.selectOne(sql, param);
	}
	
	public void delete(List<Object>param) {
		String sql = "UPDATE FREEBOARD\r\n" + 
				"SET DELYN = 'Y'\r\n" + 
				"WHERE BOARD_NO = ? " ;
		
		jdbc.update(sql,param);
	}
	
	public void insert(List<Object> param) {
		String sql = "INSERT INTO FREEBOARD(BOARD_NO, BOARD_NAME, BOARD_CONTENT, REGDATE, CUS_NO)\r\n" + 
				"VALUES(BOARD_NO_SEQ.NEXTVAL,?,?,SYSDATE, '0000001')";

		jdbc.update(sql,param);
	}

	public void update(List<Object> param) {
	    String sql = "UPDATE FREEBOARD\r\n" + 
	            "SET BOARD_NAME = ?, BOARD_CONTENT = ?, REGDATE = SYSDATE\r\n" +
	            "WHERE BOARD_NO = ?";
	    
	    jdbc.update(sql, param);
	}

}
