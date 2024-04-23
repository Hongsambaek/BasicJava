package kr.or.ddit.study06.sec05.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBMain {
	public static void main(String[] args) {
		DBMain obj = new DBMain();
		obj.process();
	}
	
	public void process() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		conn = DBConn.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = " SELECT * FROM MEMBER ";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				String mail = rs.getNString("mem_mail");
				String job = rs.getNString("mem_job");
				String like = rs.getNString("mem_like");
				if(!job.equals("주부")) continue;
				System.out.println(mail+"\t"+job+"\t"+like+"\t");
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
