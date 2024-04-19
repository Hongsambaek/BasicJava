package kr.or.ddit.study03;

import java.util.Scanner;

public class BinaryOperation {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BinaryOperation obj = new BinaryOperation();
		obj.process();
	}

	public void process() {
		// 이항 연산자 : 대부분의 연산자
		// 산술 연산자, 관계 연산자, 논리 연산자, 비트 연산자, 대입 연산자.
//		method1();
//		method2();
//		method3();
//		method4();
// 		method5();
//		method6();
	}
	
	public void method1() {
		//산술 연산자
		//종류 :+, -, /, *, %
		//사칙연산과 마찬가지로/, * 먼저 적용된다.
		
		int a = 5;
		int b = 3;
		
		System.out.println("덧셈\t"+(a+b));
		System.out.println("뺼셈\t"+(a-b));
		System.out.println("나눗셈\t"+(a/b));
		System.out.println("곱셈\t"+(a*b));
		
		System.out.println("나머지\t"+(a%b)); //나머지만 주의해서 실행하기
	}
	public void method2() {
		// 관계 연산자
		// 참, 거짓으로 결과가 나옴.
		// <, >, ==, <=, !=
	
	System.out.println("정수를 입력 하세요: ");
	int num = sc.nextInt();
	
	//100~90 : A
	if(num>=90) {
		System.out.println("A 학점");
		
	}
  }
	public void method3() {
		//논리 연산자
		//&&, ||, !| (!는 부정을 의미한다)
		//&& : 둘 중 하나라도 거짓이면 거짓
		//|| : 둘 중 하나라도 참이면 참
		//! : 부정
		
		boolean a = true ;
		boolean b = false;
		
			System.out.println(a&&b);
			System.out.println(a&&!b);
			System.out.println(a||b);
			System.out.println(!a||b);
		
			System.out.println("점수를 입력하세요");
		int score = sc.nextInt();
		// B 학점
		// 90보다 작으면서 80보다 크거나 같다
		if(score<90 && score >=80) {
			System.out.println("B");
	}
  }
	public void method4(){
		// 대입연산자.
		// = : '=' 오른쪽의 값을  '=' 왼쪽에 저장 우선순위가 가장 늦다
				// '='과 다른연산자가 결합
				// a=a+b => a+=b
				// a=a-b => a-=b
				// a=a/b => a/=b
				// a=a*b => a*=b
				// a=a%b => a%=b
		int x = 10;
		int y = 15;
		int result = x+y;
		System.out.println(result);
		
		int a = 10;
		int b = 4;
		
		System.out.println("a=a+b => a+=b : "+(a+=b));
		System.out.println("a=a-b => a-=b : "+(a-=b));
		System.out.println("a=a/b => a/=b : "+(a/=b));
		System.out.println("a=a*b => a*=b : "+(a*=b));
		System.out.println("a=a%b => a%=b : "+(a%=b));
	}
	
	public void method5() {
		// 논리 연산자
		// !, &, ~
		
		int a = 45;
		int b = 25;
		
		System.out.println(a&b);
		System.out.println(a|b);
		System.out.println(~a);
  }
	
	public void method6() {
		// 쉬프트 연산자
		// >> <<
		// 은행권에서 주로 사용함
		
		int a = 12;
		// 1100 (2진수) 
		System.out.println(a>>2);
		System.out.println(a<<2);
  }
}