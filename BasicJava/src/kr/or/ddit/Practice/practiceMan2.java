package kr.or.ddit.Practice;

import java.util.Calendar;
import java.util.Scanner;

import kr.or.ddit.homework.Homework15;

public class practiceMan2 {

	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Homework15 obj = new Homework15();
		obj.process();
	}

	public void process() {
		Calendar cal = Calendar.getInstance();
		while (true) {
			// <이전달 다음달>
			System.out.println("================"+cal.get(Calendar.YEAR)+"년"+cal.get(Calendar.MONTH)+"월"+"=========================");
			System.out.println("<이전달\t\t\t\t\t다음달>");
			System.out.println("일\t월\t화\t수\t목\t금\t토");
			System.out.println("=======================================================");
			cal.set(Calendar.DATE, 1);
			int day = cal.get(Calendar.DAY_OF_WEEK);
			for(int i = 1; i<day; i++) {
				System.out.print("\t");
			}
			// 이번달의 마지막 일
			int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);	
			for (int i = 1; i < lastDay; i++) {
				int weekDay = cal.get(Calendar.DAY_OF_WEEK);
				System.out.print(i+"\t");
				if(weekDay == 7) {
					System.out.println();
			}
			if(i!=lastDay) cal.add(Calendar.DATE,1);

			}
			
			String str = sc.next();
			if (str.equals(">")) {
				cal.add(Calendar.MONTH, -1);
			} else if (str.equals("<")) {
				cal.add(Calendar.MONTH, 1);
			}
		}
	}
}
