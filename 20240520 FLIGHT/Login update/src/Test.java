import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import util.JDBCUtil;

public class Test {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Test obj = new Test();
		obj.process();
	}

	public void process() {
		
		method4();

	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public void method1() {
		
	
	//selectOne(String sql)
	//selectList(String sql)
	//update(String sql)
	
	
	String sql = "SELECT*FROM MEMBER";
	List<Map<String,Object>> list = jdbc.selectList(sql);
	for(Map<String,Object> map : list) {
		System.out.println(map);
		}
	
	}
	public void method2() {
		String sql = "SELECT*\r\n" + 
				"FROM MEMBER;\r\n" + 
				"WHERE MEM_ID = 'A001'\r\n" + 
				"AND MEM_PASS = 'ASDFASDF'";
		
		Map<String,Object> map = jdbc.selectOne(sql);
				System.out.println(map);
		
	}
	public void method3() {
		String sql = "SELECT*\r\n" + 
				"FROM MEMBER;\r\n" + 
				"WHERE MEM_ID = 'A001'\r\n" + 
				"AND MEM_PASS = 'ASDFASDF'";
		
		System.out.println("아이디");
		String id = sc.next();
		System.out.println("패스워드");
		String pw = sc.next();
		
		List<Object>param = new ArrayList();
		param.add(id);
		param.add(pw);
		
		
		Map<String,Object> map = jdbc.selectOne(sql);
		System.out.println(map);
	
	}
	
	public void method4() {
		String sql = "UPDATE MEMBER\r\n" + 
				"SET MEM_PASS = '1d45'\r\n" + 
				"WHERE MEM_ID = 'a001'";
		
		jdbc.update(sql);
		
	}
	
}
