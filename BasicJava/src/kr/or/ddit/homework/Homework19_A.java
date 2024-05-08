package kr.or.ddit.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Homework19_A {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Homework19_A obj = new Homework19_A();
		obj.process();
	}

	public void process() {
		List<Map<String, Object>> parkList = inputDate();
		parkPay(parkTime(parkList));
	}

	// 3. 요금 계산하기
	public Map<String, Integer> parkPay(Map<String, Integer> parkOut) {
		// 기본시간(분)		기본 요금(원)		단위 시간(분)		단위 요금(원)
		// 180			5000			10				600
		int cal = 0;
		for (String key : parkOut.keySet()) {
			if (parkOut.get(key) < 180) {
				System.out.println("차량번호 " + key + "의 요금 : 5000원"); // 주차시간 180분 이하이면 주차요금 5000원
			} else {
				if ((parkOut.get(key) - 180) % 10 == 0) {
					cal = (parkOut.get(key) - 180) / 10 * 600 + 5000; // 주차시간이 10으로 나누어 떨어질 때 	
				} else
					cal = ((int) ((parkOut.get(key) - 180) / 10.0) + 1) * 600 + 5000; // 주차시간이 10으로 나누어 떨어지지 않을 때	
				System.out.println("차량번호 " + key + "의 요금 : " + cal + "원");
			}
		}

		return null;
	}

	// 2. 차량별 주차 시간 구하기
	public Map<String, Integer> parkTime(List<Map<String, Object>> parkList) {
		Map<String, Integer> parkIn = new HashMap<String, Integer>(); // 입차정보 Map(차량번호, 입차시간)
		Map<String, Integer> parkOut = new HashMap<String, Integer>(); // 요금정보 Map(차량번호, 요금)
		for (Map<String, Object> map : parkList) {
			String carNum = (String) map.get("차량번호");
			int time = getMin((String) map.get("시각"));
			String his = (String) map.get("내역");

			if (his.equals("입차")) {
				parkIn.put(carNum, time); // 입차 시 입차정보 Map에 저장
			} else if (his.equals("출차") && parkIn.containsKey(carNum)) { // 출차이고 입차정보에 차량번호가 있을 시
				int parkInTime = parkIn.get(carNum); // 입차시간을 저장
				int parkTime = time - parkInTime; // 현재시간 - 입차시간 저장

				if (!parkOut.containsKey(carNum)) { // 요금정보 Map에 정보가 없을 때 -> 처음 들어온 차
					parkOut.put(carNum, parkTime); // 요금정보 Map에 요금 정보 저장
				} else {
					parkOut.put(carNum, parkOut.get(carNum) + parkTime); // 요금정보 Map에 정보가 있을 때 원래 정보에서 요금 추가
				}

				parkIn.remove(carNum); // 입차정보 초기화를 위해 기록 삭제
			}
		}

		return parkOut;
	}

	public int getMin(String time) {
		String[] tokens = time.split(":");
		int hour = Integer.parseInt(tokens[0]);
		int min = Integer.parseInt(tokens[1]);
		return hour * 60 + min;
	}

	// 1. 데이터 넣기
	public List<Map<String, Object>> inputDate() {
		// 시각		차량번호	내역
		// 05:34	5961 	입차
		// 06:00	0000 	입차
		// 06:34	0000 	출차
		// 07:59	5961 	출차
		// 07:59	0148 	입차
		// 18:59	0000	입차
		// 19:09	0148	출차
		// 22:59	5961	입차
		// 23:00	5961	출차
		// 23:00    0000	출차
		Map<String, Object> park1 = new HashMap();
		park1.put("시각", "05:34");
		park1.put("차량번호", "5961");
		park1.put("내역", "입차");

		Map<String, Object> park2 = new HashMap();
		park2.put("시각", "06:00");
		park2.put("차량번호", "0000");
		park2.put("내역", "입차");

		Map<String, Object> park3 = new HashMap();
		park3.put("시각", "06:34");
		park3.put("차량번호", "0000");
		park3.put("내역", "출차");

		Map<String, Object> park4 = new HashMap();
		park4.put("시각", "07:59");
		park4.put("차량번호", "5961");
		park4.put("내역", "출차");

		Map<String, Object> park5 = new HashMap();
		park5.put("시각", "07:59");
		park5.put("차량번호", "0148");
		park5.put("내역", "입차");

		Map<String, Object> park6 = new HashMap();
		park6.put("시각", "18:59");
		park6.put("차량번호", "0000");
		park6.put("내역", "입차");

		Map<String, Object> park7 = new HashMap();
		park7.put("시각", "19:09");
		park7.put("차량번호", "0148");
		park7.put("내역", "출차");

		Map<String, Object> park8 = new HashMap();
		park8.put("시각", "22:59");
		park8.put("차량번호", "5961");
		park8.put("내역", "입차");

		Map<String, Object> park9 = new HashMap();
		park9.put("시각", "23:00");
		park9.put("차량번호", "5961");
		park9.put("내역", "출차");

		Map<String, Object> park10 = new HashMap();
		park10.put("시각", "23:00");
		park10.put("차량번호", "0000");
		park10.put("내역", "출차");

		List<Map<String, Object>> list = new ArrayList();

		list.add(park1);
		list.add(park2);
		list.add(park3);
		list.add(park4);
		list.add(park5);
		list.add(park6);
		list.add(park7);
		list.add(park8);
		list.add(park9);
		list.add(park10);

		return list;

	}
}
