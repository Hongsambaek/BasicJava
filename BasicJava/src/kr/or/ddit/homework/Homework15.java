package kr.or.ddit.homework;

import java.util.Calendar;
import java.util.Scanner;

public class Homework15 {
	
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Homework15 obj = new Homework15();
		obj.process();
	}

	public void process() {
		Calendar cal = Calendar.getInstance();
		int month = 0;
		
		while(true) {
			// < 이전달     다음달>
	
	
			
			//달 입력
			System.out.println("입력");
			String str = sc.next();
			if (str.equals(">")) {
				cal.add(month, 1);
			}
			else if (str.equals("<")) {
				cal.add(month, -1);
			}
			else {
				month = Integer.parseInt(str);
			}
			//첫날의 요일 구하기
			cal.set(Calendar.DATE, 1);
			int day = cal.get(Calendar.DAY_OF_WEEK);
			
			//입력달 마지막일
			int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
			//출력
			System.out.println("----------------------------------------------");
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			System.out.println("----------------------------------------------");
			for (int i = 1; i < day-1; i++) {
				System.out.print("\t");
			}
			for (int i = 1; i <= lastDay; i++) {
				System.out.print(i+"\t");
				
				if (day%7==0) {
					System.out.println();	
				}
				day++;
			}
			System.out.println();
			System.out.println("----------------------------------------------");
			
		}
	}
}
