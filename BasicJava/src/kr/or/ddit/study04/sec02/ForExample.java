package kr.or.ddit.study04.sec02;

import java.util.Scanner;

public class ForExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ForExample obj = new ForExample();
		obj.process();
	}

	public void process() {
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
//		method6();
//		method7();
//		method8();
//		method9();
//		method10();
//		method11();
	}
		
	public void method1() {
		//
		int i1 = 1;
		int i2 = 2;
		int i3 = 3;
		int i4 = 4;
		int i5 = 5;
		
		int sum = i1+i2+i3+i4+i5;
		System.out.println("1~5까지의 합"+sum);
		
		int sum2 = 0;
//		int i=1 <= 초기화식
//		i<=5; 	      조건식
//		i++		<= 증감식
//		for(int i=1; i<=5; i++) {
		for(int i=1; i<=5; i++) {
			sum2+=i;
		}
		System.out.println("1~5까지의 합 = "+sum2);
		}
	
	public void method2() {
		// 5 ~ 10 까지의 합을 구하시오.
		
		
		int sum3 = 0;
		for(int i=5; i<=10; i++) {
			sum3+=i;
		}
		System.out.println("5~10까지의 합 = "+sum3);
	}
	
	public void method3() {
		// 1 ~ 10까지의 홀수의 합을 구하시오.
		
		int sum4 = 0;
		for(int i=0; i<=10; i++) {
			if(i%2==1) {
				sum4+=i;
			}
		}
		System.out.println("1부터 10까지의 홀수의 합: "+sum4);
	}
	
	public void method4() {
		//1 ~ 10까지의 짝수의 합을 구하시오
		int sum5 = 0;
		for(int i=2; i<=10; i=i+2) {
			sum5+=i;
			}
			System.out.println("1부터 10까지의 짝수의 합: "+sum5);
		}
	
	public void method5() {
		//a~z 까지 출력 해보기
		for(char c ='a'; c<='z'; c++) {
			System.out.println(c);
		}
	
	}
	
	public void method6() {
		//소문자를 입력 받고 해당 문자부터 ~z 까지 출력하시오
		System.out.println("소문자를 입력하시오");
		char c1 = sc.next().charAt(0);
		for(char i = c1; i<='z'; i++) {
			System.out.println(i);
		}
		
		
		
	}
	
	public void method7() {
		//숫자를 입력받고 1 ~ 해당 숫자까지의 총합.
		System.out.println("숫자를 입력하시오");
		int num = sc.nextInt();	
		int sum = 0; 
		for(int i1 = 1; i1<=num; i1++) {
			sum+=i1;
		}
		System.out.println("1부터"+num+"숫자의 합"+sum);
	}
	
	public void method8() {
		System.out.println("단어를 입력하세요");
		String word = sc.next();
		for(int i=0; i<word.length(); i++) {
			System.out.println(word.charAt(i));
		}
	}
	
	public void method9() {
		//문자열 뒤집기
		System.out.println("단어를 입력하세요");
		String word = sc.next();
		for (int i=0; i<word.length(); i++) {
			System.out.print(word.charAt(word.length()-1-i));
		}
	}
	
	public void method10() {
		// 영어를 입력하고 모음을 제거하시오.
		// abcde → bcd
		// 영어모음 → a,e,i,o,u
		
		System.out.println("단어를 입력하시오");
		String word = sc.next();
		
		for (int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
				
			}else
			System.out.println(word.charAt(i));
		}
	}
	
	public void method11() {
		//for 문을 활용하여 문자를 입력받고 숫자를 제거하시오
		System.out.println("문자와 숫자를 입력하시오");
		String word = sc.next();
		
		for(int i=0; i<word.length(); i++) {
			char ch = word.charAt(i);
			if(ch >='0'  && ch<='9') {
				
			}else {
				System.out.println();
			}
		}
	}
	}

