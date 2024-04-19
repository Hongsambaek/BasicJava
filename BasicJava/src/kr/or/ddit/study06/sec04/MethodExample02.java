package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class MethodExample02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MethodExample02 obj = new MethodExample02();
		obj.process();
	}

	public void process() {
		// 스캐너를 통해 a, b 값을 입력 받고
		System.out.println("숫자 a의 값을 입력 : ");
		int a = sc.nextInt();
		System.out.println("숫자 b의 값을 입력 : ");
		int b = sc.nextInt();
		add(a, b);
		subt(a, b);
		mult(a, b);
		divd(a, b);
		
	}
	
		// add 메소드를 수정하여 a+b 값을 출력하시오
	public void add(int a, int b) {	
		System.out.println("합 : "+a+"+"+b+"="+(a+b));
		
	}
	
	public void subt(int a, int b) {
		System.out.println("차 : "+a+"-"+b+"="+(a-b));
	}
	
	public void mult(int a, int b) {
		System.out.println("곱 : "+a+"x"+b+"="+(a*b));
	}
	
	public void divd(int a, int b) {
		System.out.println("나 : "+a+"÷"+b+"="+(a/b));
	}
}
