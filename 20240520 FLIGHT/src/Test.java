import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import util.JDBCUtil;

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
//		selectOne(String sql)
//		selectList(String sql)
//		update(String sql)
		
		String sql = "Select * from member";
		List<Map<String, Object>> list = jdbc
				
				
				.selectList(sql);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
		
	}
	
	public void method2() {
		String sql = "Select * from member where mem_id='a001' and mem_pass = 'asdfasdf'";
		Map<String, Object> map = jdbc.selectOne(sql);
		System.out.println(map);
	}
	public void method3() {
		String sql = "Select * from member where mem_id= ? and mem_pass = ?";
		System.out.println("id");
		String id = sc.next();
//		System.out.println("pw");
//		String pw = sc.next();
		
		List<Object> param = new ArrayList();
		param.add(id);
//		param.add(pw);
		
		Map<String, Object> map = jdbc.selectOne(sql, param);
		System.out.println(map);
	}
	public void method4() {
		String sql = "update member \r\n" + 
					 "set mem_pass = '1234'\r\n" + 
					 "where mem_id = 'a001'";
		
		jdbc.update(sql);
		
	}
	
}
