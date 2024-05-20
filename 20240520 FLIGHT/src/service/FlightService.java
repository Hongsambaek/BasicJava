package service;

import java.util.List;
import java.util.Map;

import dao.FlightDao;


public class FlightService {
	private static FlightService instance;

	private FlightService() {

	}

	public static FlightService getInstance() {
		if (instance == null) {
			instance = new FlightService();
		}
		return instance;
	}
	
	FlightDao flightDao = FlightDao.getInstance();
	
//	public List<Map<String, Object>> list() {
//		return flightDao.list();
//		
//		
//	}
	public void insert(List<Object> param) {
		flightDao.insert(param);
	}
	public void delete(List<Object> param) {
		flightDao.delete(param);
	}
	public void update(List<Object> param) {
		flightDao.update(param);
	}
	public void detail(List<Object> param) {
		flightDao.detail(param);
	}

	public List<Map<String, Object>> list(List<Object> param) {
		return flightDao.list(param);
	}


	public void reserve(List<Object> reservationParams) {
	    flightDao.reserve(reservationParams);
	}
	public void ticketing(List<Object> ticketingParam) {
		flightDao.ticketing(ticketingParam);
	}
	public void remove(List<Object> param) {
		flightDao.remove(param);
	}
	public List<Map<String, Object>> resList(List<Object> resParam){
		return flightDao.resList(resParam);
	}
	
}

