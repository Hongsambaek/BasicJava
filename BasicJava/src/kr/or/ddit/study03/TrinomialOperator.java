package kr.or.ddit.study03;

import java.util.Scanner;

public class TrinomialOperator {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		TrinomialOperator obj = new TrinomialOperator();
		obj.process();
	}

	public void process() {
		method1();
		
	}
	public void method1() {
		// 삼항 연산자 : 3개의 피연산자를 필요로 하는 연산
		//			 삼항 연산자는 '?' 앞의 조건식의 결과에 따라 콜론 앞뒤의
		//			 피연산자가 선택 조건 연산식이라고도 함.
		String str = true ? "참" : "거짓" ; //true false
		System.out.println(str);
		
		System.out.println("나이를 입력 하세요 : ");
		int age = sc.nextInt();
		
		// 3항 연산자를 이용해서
		// 18세 이상이면 성년 아니면 미성년자를 저장 하시오
		String adult = age >=18 ? "성년" : "미성년자";
		System.out.println(adult);
		
		//
		System.out.println("숫자를 입력하세요 : ");
		int a = sc.nextInt();
		System.out.println("숫자를 입력하세요 : ");
		int b = sc.nextInt();
		
		//a 값이 짝수라면 a+b
		//	      홀수라면 a*b
		
		int result = a%2 ==0 ? a+b : a*b;
		System.out.println(a+", "+b+" =>"+result);
	}
}
