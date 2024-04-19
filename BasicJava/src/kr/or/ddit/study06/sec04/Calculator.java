package kr.or.ddit.study06.sec04;

public class Calculator {
	//a, b를 파라미터로 하는 + - ; * 각각 메소드 만들기
	
	public double cal(String oper, int a, int b) {
		if(oper.equals("+")) return add(a, b);
		if(oper.equals("-")) return sub(a, b);
		if(oper.equals("x")) return mul(a, b);
		if(oper.equals("÷")) return div(a, b);
		System.out.println("지원하지 않는 연산입니다.");
		return 0;
	}
	
	public int add(int a, int  b) {
		return a+b;
	}
	
	public int sub(int a, int  b) {
		return a-b;
	}
	
	public int mul(int a, int  b) {
		return a*b;
	}
	
	public int div(int a, int  b) {
		return a/b;
	}
}
