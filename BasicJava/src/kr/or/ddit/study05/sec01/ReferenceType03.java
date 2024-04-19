package kr.or.ddit.study05.sec01;

import java.util.Scanner;

public class ReferenceType03 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ReferenceType03 obj = new ReferenceType03();
		obj.process();
	}

	public void process() {
		method1();

	}
	
	public void method1() {
		int a = 10;
		//1 stack 에 a=10 저장
		{
			int b = 12;
			int[] c;
			//2 : stzck b=12, int[] c = null 저장
			c= new int[] {1, 2, 3};
			//3 : heap에 저장공간이 생기고 1,2,3배열이 저장됨
//				: stack에는 heap으로의 주소값이 생성됨
			
		}
		//4 : stack에 b와 c의 값이 사라지고 heap은 유지됨
		String d = "test";
		//5 : stack에 d의주소와 heap에 값이 저장
		{
			String[] e = new String[3];
			//6 : heap 에 주소값이 등록됨
			e[0] = d;
			//7 : heap에 e의 첫번째 자리에 d의 주소가 저장
			String f = "test2";
			//8 : stack에 f의 주소와 heap에 값이 저장
			e[1] = f;
			//9 : heap에 e의 첫번째 자리에 f의 주소가 저장
			e[2] = "test";
			//10 : heap에 test의 주소값이 저장됨
		}
	}
}
