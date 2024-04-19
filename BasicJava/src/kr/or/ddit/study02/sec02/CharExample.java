package kr.or.ddit.study02.sec02;

public class CharExample {
	public static void main(String[] args) {
		//char : 부호 없는 2byte 정수 0~65535
		//		  문자 표현을 위해 사용됨
		
		char c1 = 66;
		System.out.println(c1);
		
		char c2 = 'B'+32; //문자 여러개 안됨 1개만 사용가능, 32를 더하면 대소문자 변경가능
		System.out.println(c2);
		
		char c3 = '가';
		System.out.println(c3);
		
		int i3 = c3;
		System.out.println(i3);
		
	}
}
