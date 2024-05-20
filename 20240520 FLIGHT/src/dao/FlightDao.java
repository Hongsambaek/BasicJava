package dao;

import java.util.List;
import java.util.Map;

import util.JDBCUtil;

public class FlightDao {
	private static FlightDao instance;

	private FlightDao() {

	}

	public static FlightDao getInstance() {
		if (instance == null) {
			instance = new FlightDao();
		}
		return instance;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public List<Map<String,Object>> list(List<Object> param) {
		String sql = "SELECT s.*\r\n" + 
				"FROM SCHEDULE s\r\n" + 
				"JOIN AIRPORT dep_airport ON s.SCHE_DEPART = dep_airport.AIR_NAME\r\n" + 
				"JOIN AIRPORT arr_airport ON s.SCHE_ARRIVE = arr_airport.AIR_NAME\r\n" + 
				"WHERE dep_airport.AIR_NATION = ? \r\n" + 
				"AND arr_airport.AIR_NATION = ? ";
		
		return jdbc.selectList(sql, param);
	}
	public void insert(List<Object> param) {
		String sql = " ";
		
		jdbc.update(sql,param);
	}
	public void delete(List<Object> param) {
		// TODO Auto-generated method stub
		String sql = " ";
		
		jdbc.update(sql, param);
	}
	public void update(List<Object> param) {
		// TODO Auto-generated method stub
		String sql = " ";
		jdbc.update(sql, param);
	}
	public void remove(List<Object> param) {
		// TODO Auto-generated method stub
		String sql = "DELETE FROM TICKETING\r\n" + 
					 "WHERE TICKET_NO IN (SELECT t.ticket_no\r\n" + 
					 "                    FROM ticketing t, customer c\r\n" + 
					 "                    WHERE t.cus_no = c.cus_no \r\n" + 
					 "                    AND t.CUS_NO = (SELECT CUS_NO FROM CUSTOMER WHERE CUS_ID = ? AND CUS_PW = ?) \r\n" + 
					 "                    AND t.ticket_no = ?) ";
		jdbc.update(sql, param);
	}
	public void detail(List<Object> param) {
		String sql = "select NO, NAME, TYPE, PRICE \r\n" + 
				"from GOODS\r\n" + 
				"where NO = ? ";
		jdbc.update(sql, param);
	}

	public void reserve(List<Object> reservationParams) {
		
	    String sql ="INSERT INTO RESERVATION (RESERVATION_ID, SCHE_NO, CUS_NO, TICKET_NO, RESERVATION_DATE, SEAT_NO)\r\n" + 
	    		    "VALUES (?, ?, ?, ?, SYSDATE, ?)";
	    jdbc.update(sql, reservationParams);
	}

	public void ticketing(List<Object> ticketingParam) {
		String sql = "INSERT INTO TICKETING (TICKET_NO, TICKET_DATE, TICKET_COST, SCHE_NO, CUS_NO)\r\n" + 
					 "VALUES ( ? , SYSDATE , ? , ?, ?) ";
		
		jdbc.update(sql, ticketingParam);
	}
	
	public List<Map<String,Object>> resList(List<Object> resParam) {
		String sql = "select s.sche_depart, s.sche_departtime, s.sche_arrive, s.sche_arrivetime, r.seat_no, r.ticket_no \r\n" + 
				"from schedule s, customer c, reservation r\r\n" + 
				"where c.cus_no = r.cus_no and s.sche_no = r.sche_no and r.cus_no = (select cus_no\r\n" + 
				"                                                                    from customer\r\n" + 
				"                                                                    where cus_id = ? and cus_pw = ?)";
		
		return jdbc.selectList(sql, resParam);
	}

	
	

	
	
	
}
