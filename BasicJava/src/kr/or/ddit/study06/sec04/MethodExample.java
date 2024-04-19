package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class MethodExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		MethodExample obj = new MethodExample();
		obj.process();
	}

	public void process() {
		System.out.println("method1 호출");
		method1(10,20);
		System.out.println();
		System.out.println("method2 호출");
		method2("test");

		
	}
	
	public void method1(int a, int b) {
		System.out.println("public void method1(int a, int b)");
		System.out.println("a : "+a+", b : "+b);
	}
	
	public void method2(String str) {
		System.out.println("public void method2(String str)");
		System.out.println("str : "+str);
	}
}
