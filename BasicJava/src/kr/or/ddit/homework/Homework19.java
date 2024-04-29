package kr.or.ddit.homework;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Homework19 {
   Scanner sc = new Scanner(System.in);

   public static void main(String[] args) {
      Homework19 obj = new Homework19();
      obj.process();
   }

   public void process() {
      List<Map<String, Object>> parkList = inputDate();
      Map<String, Integer> parkTimeMap = parkTime(parkList);
      Map<String, Integer> parkPayMap = parkPay(parkTimeMap);
      printResult(parkPayMap);
      
    
     
   }
   
   
   // 2. 차랑별 주차 시간 구하기
   public Map<String, Integer> parkTime(List<Map<String, Object>> parkList) {
       Map<String, Integer> parkTimeMap = new HashMap<>();
       for (Map<String, Object> park : parkList) {
           String carNo = (String) park.get("차량번호");
           String time = (String) park.get("시각");
           String action = (String) park.get("내역");
           if (!parkTimeMap.containsKey(carNo)) {
               parkTimeMap.put(carNo, 0);
           }
           int curTime = getMin(time);
           int preTime = parkTimeMap.get(carNo);
           if (action.equals("입차")) {
               parkTimeMap.put(carNo, curTime);
           } else {
               int totalTime = curTime - preTime;
               parkTimeMap.put(carNo, totalTime);
           }
       }
       return parkTimeMap;
   }
   
   public int getMin(String time) {
	   String[] tokens = time.split(":");
	   int hour = Integer.parseInt(tokens[0]);
	   int min = Integer.parseInt(tokens[1]);
	   return hour*60+min;
   }
   
   // 3. 주차요금 구하기
   public Map<String, Integer> parkPay(Map<String, Integer> parkTime) {
       Map<String, Integer> parkPayMap = new HashMap<>();
       for (Map.Entry<String, Integer> entry : parkTime.entrySet()) {
           String carNumber = entry.getKey();
           int totalTime = entry.getValue();
           int basicTime = 180;
           int basicPay = 5000;
           int unitTime = 10;
           int unitPay = 600;
           int totalPay = 0;
           if (totalTime <= basicTime) {
               totalPay = basicPay;
           } else {
               totalPay = basicPay + ((totalTime - basicTime + unitTime - 1) / unitTime) * unitPay;
           }
           parkPayMap.put(carNumber, totalPay);
       }
       return parkPayMap;
   }
   
   //결과출력
   public void printResult(Map<String, Integer> parkPayMap) {
	   System.out.println("주차 요금 결과");
	   System.out.println("===============================");
	   for (Map.Entry<String, Integer> entry : parkPayMap.entrySet()) {
		String carNo = entry.getKey();
		int pay = entry.getValue();
		System.out.println("차량번호 : "+ carNo +", 주차요금: "+ pay + "원");
	}
   }

   // 1. 데이터 넣기
   public List<Map<String, Object>> inputDate() {
      // 시각      차량번호      내역
      // 05:34   5961   입차
      // 06:00   0000   입차
      // 06:34   0000   출차
      // 07:59   5961   출차
      // 07:59   0148   입차
      // 18:59   0000   입차
      // 19:09   0148   출차
      // 22:59   5961   입차
      // 23:00   5961   출차
      // 23:00   0000   출차
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