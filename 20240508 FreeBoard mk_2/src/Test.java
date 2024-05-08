import java.util.*;


import util.JDBCUtil;

// getColumnName vs getColumnLabel
// getColumnName : 원본 컬럼명을 가져옴
// getColumnLabel : as로 선언된 별명을 가져옴, 없으면 원본 컬럼명

public class Test {
	public static void main(String[] args) {
		Test test = new Test();
//		test.method1();
//		test.method2();
//		test.method3();
		test.method4();
		
	}
	Scanner sc = new Scanner(System.in);
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public void method1() {
		//selectOne(String sql)
		//selectList(String sql)
		//update(String sql)
		
		String sql = "SELECT * FROM MEMBER";
		jdbc.selectList(sql);
		List<Map<String, Object>> list = jdbc.selectList(sql);
		for(Map<String, Object> map : list) {
			System.out.println(map);
		}

	}
	
	public void method2() {
		String sql = "SELECT * \r\n" + 
					 "FROM MEMBER\r\n" + 
					 "WHERE MEM_ID = 'a001'\r\n" + 
					 "AND MEM_PASS = 'asdfasdf'";
		
		Map<String, Object> map = jdbc.selectOne(sql);
		System.out.println(map);
	}
	
	public void method3() {
		//동적으로 사용해주기 위해 id와 pw를 ?로 넣는다
		String sql = "SELECT * \r\n" + 
					 "FROM MEMBER\r\n" + 
					 "WHERE MEM_ID = ? \r\n" + 
					 "AND MEM_PASS = ?";
		
		System.out.println("ID");
		String id = sc.next();
		System.out.println("PW");
		String pw = sc.next();
		
		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pw);
		
		
		Map<String, Object> map = jdbc.selectOne(sql,param);
		System.out.println(map);
	}
	
	
	public void method4() {
		String sql = "UPDATE MEMBER\r\n" + 
					 "SET MEM_PASS = '1234'\r\n" + 
					 "WHERE MEM_ID = 'a001';\r\n";
		
		jdbc.update(sql);
	}

	
}
