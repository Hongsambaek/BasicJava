package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class MethodExample04 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MethodExample04 obj = new MethodExample04();
		obj.process();
	}

	public void process() {
		// 스캐너를 통해 a, b 값을 입력 받고
		// add 메소드를 수정하여 a+b 값을 리턴 받아 출력하시오
		System.out.println("a : ");
		int a = sc.nextInt();
		System.out.println("b : ");
		int b = sc.nextInt();
		int add = add(a, b);
		int subt = subt(a, b);
		int mult = mult(a, b);
		double divd = divd(a, b);
		System.out.println("합 : "+a+"+"+b+"="+add);
		System.out.println("차 : "+a+"-"+b+"="+subt);
		System.out.println("곱 : "+a+"x"+b+"="+mult);
		System.out.println("몫 : "+a+"÷"+b+"="+divd);
		
		
	}
	
	public int add(int a, int b) {
		return a+b;
	}
	
	public int subt(int a, int b) {
		return a-b;
	}
	
	public int mult(int a, int b) {
		return a*b;
	}
	
	public double divd(int a, int b) {
		return (double)a/b;
	}
}
