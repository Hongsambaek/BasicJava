package kr.or.ddit.study05.sec01;

import java.util.Scanner;

public class ReferenceType02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ReferenceType02 obj = new ReferenceType02();
		obj.process();
	}

	public void process() {
//		method1();
		method2();
		

		//ctrl+shift+o 눌러서 불러오기
	}
	
	
	public void method1() {
		int a = 10;
		//1 - stack
		int b = 15; 
		
		{
			//2 -stack
			String c = "test";
			//3 -stack(address), heap
		}
		//4 - c가 stack에서 사라지고 d가 대체됨
		String d = "test";
		
		{
			int e = 4;
			//5 - stack
			{
				int f = 10;
				//6 - stack
			}
			int g = 3;
			//7 - f=10 제거후 stack g=3
			d = "test2";
			//8 = 의 주소가 heap의 test2의 주소로 이동
		}
	}
	
	public void method2() {
		
//		String a = ""; 
		String a = null; //연결된 값이 없음
				
		if (a==null || a.isEmpty()) {
			System.out.println("빈 문자열");
		}
		
  }
}