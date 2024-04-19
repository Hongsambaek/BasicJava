package kr.or.ddit.homework;

import java.util.Scanner;

public class Homework02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Homework02 obj = new Homework02();
//		obj.method1();
//		obj.mehtod2();
//		obj.mehtod3();
		obj.mehtod4();
//		obj.mehtod5();
	}

	public void method1() {
		/*
		 *  스캐너를 통해서 문자(실수)를 입력 받고.
		 *  소수점 2째 짜리에서 버림  
		 *  ex ) 12.23123 - > 12.23
		 */
		System.out.println("실수 를 입력해주세요.");
		String str = sc.next();
		double d1 = Double.parseDouble(str);
		double d2 = (int)(d1*100)/100.0;
		System.out.println("입력받은 실수의 소수점 두 번째 자리까지는 :"+ d2);
		

	
	}
	
	public void mehtod2() {
		/*
		 *  스캐너를 통해서 대문자를 입력 받고 소문자로 변환 
		 *  ex) A-> a  
		 */
		System.out.println("대문자를 입력 해주세요.");
		String s = sc.next();
		char c1 = s.charAt(0);
		int i1 = c1+32;
		char c2 = (char)i1;
		
//		String s = sc.next();
//		char ch = (char)(s.charAt(0)+32);
		
		
//		System.out.println("입력받은 문자의 소문자는 : "+ ch);
		System.out.println("입력받은 문자의 소문자는 : "+ c2);
		
		
		
	}
	public void mehtod3() {
		/*
		 *  스캐너를 통해서 소문자를 입력 받고 대문자로 변환 
		 *  ex) f-> F  
		 */
		System.out.println("소문자를 입력 해주세요.");
		String s = sc.next();
		char c1 = s.charAt(0);
		int i1 = c1-32;
		char c2 = (char)i1;
		
		System.out.println("입력받은 문자의 대문자는"+c2);
		
		
	}
	
	public void mehtod4() {
		/*
		 *  스캐너를 통해서 숫자 3자리를 입력 받고 각 자리수의 합을 구하시오
		 *  ex) 123 -> 1+2+3
		 */
		System.out.println("세자리 숫자를 입력해주세요.");
		String s = sc.next();
		
		char c1 = s.charAt(0);
		char c2 = s.charAt(1);
		char c3 = s.charAt(2);
		

		int i1 = c1-'0';
		int i2 = c2-'0';
		int i3 = c3-'0';
		
		System.out.println(i1+i2+i3);
		
//		int a = c1-48;
//		int b = c2-48;
//		int c = c3-48;
		
//		int sum = a + b + c;
//		System.out.println("세 자리 숫자의 합은: "+sum);
		
		
	}
	
	public void mehtod5() {
		/*
		 *  스캐너를 통해서 문자(실수)를 입력 받고.
		 *  소수점 2째 짜리에서 반올림  
		 *  ex ) 12.2623 - > 12.3
		 */
		System.out.println("실수를 입력해주세요: ");
		String str = sc.next();
		double d1 = Double.parseDouble(str);
		double d2 = d1*10.0;
		int i1 = (int)d2;
		double d3 = d2-i1;
		double d4 = (d2+(int)(d3*2)-d3)/10;
		
		System.out.println("소수점 둘째자리에서 반올림 한 값은"+d4);
		
//		double num = 13.5;
//		int result = (int)(num+0.5);
		
		
		

	}
	
	
}