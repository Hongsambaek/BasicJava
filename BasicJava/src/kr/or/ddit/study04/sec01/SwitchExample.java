package kr.or.ddit.study04.sec01;

import java.util.Scanner;

public class SwitchExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SwitchExample obj = new SwitchExample();
		obj.process();
	}

	public void process() {
//		method1();
//		method2();
//		method3();
//		method4();
		method5();
		//ctrl+shift+o 눌러서 불러오기
	}
	
	public void method1() {
		int select = 1; 
		switch(select) {
		case 1 : 
			System.out.println("1");
			break;
		case 2 :
			System.out.println("2");
			break;
		}
	}
	
	public void method2() {
		//월을 입력 받고 마지막 일을 출력 하시오.
		//1,3,5,7,8,10,12 => 끝나는 날짜 31일입니다.
		//4,6,9,11 => 끝나는 날짜 30일입니다.
		//2 => 끝나는 날짜가 28, 또는 29일입니다.
		int month = sc.nextInt();
		switch(month) {
			case 1 : 
			case 3 :
			case 5 :
			case 7 :
			case 8 :
			case 10 : 
			case 12 :
				System.out.println("끝나는 날짜는 31일 입니다.");
				break;
			
			case 4 : 
			case 6 :
			case 9 :
			case 11 : 
				System.out.println("끝나는 날짜는 30일 입니다.");
				break;
			
			case 2 : 
				System.out.println("끝나는 날짜가 28일 또는 29일입니다.");
				break;
				
			default : 
				System.out.println("Error");
				break;
		}
		
	}
	
	public void method3() {
		// KOR,ENG,JPN,CHN => 각각 한국, 영국, 일본, 중국
		System.out.println("약자 입력");
		String str = sc.next();
		switch(str) {
			case "KOR" : case "kor" :
				System.out.println("한국");
				break;
			case "ENG" : case "eng" :
				System.out.println("영국");
				break;
			case "JPN" : case "jpn" :
				System.out.println("일본");
				break;
			case "CHN" : case "chn" :
				System.out.println("중국");
				break;
		}
	}
	
	public void method4() {
		// 90 ~ 100 A
		// 80 ~ 90 B
		// 70 ~ 80 C
		// 60 ~ 70 D
		// 60 미만  F
		System.out.println("점수를 입력하세요");
		int score = sc.nextInt();
		switch(score/10) {
		
			case 10 : case 9 :
				System.out.println("A학점");
				break;
			case 8 : 
				System.out.println("B학점");
				break;
			case 7 :
				System.out.println("C학점");
				break;
			case 6 : 
				System.out.println("D학점");
				break;
			default : 
				System.out.println("F학점");
				break;
		}
	}
	
	public void method5() {
		System.out.println("점수를 입력하세요");
		int score = sc.nextInt();
		String grade = "";
		
		switch(score/10) {
		case 10 : 
			grade="A+";
			
			case 9 :
				grade="A";
				switch(score%10) {
				case  0 : case 1 : case  2 :
					grade += "-";
					break;
				case  3 : case 4 : case  5 :
					grade += "0";
					break;
				case  6 : case 7 : case  8 : case 9:
					grade += "+";
					break;
					
				}
				System.out.println(grade+"학점");
				break;
			case 8 : 
				System.out.println("B학점");
			break;
			case 7 :
				System.out.println("C학점");
				break;
			case 6 : 
				System.out.println("D학점");
				break;
			default : 
				System.out.println("F학점");
				break;
		}
	}
}
