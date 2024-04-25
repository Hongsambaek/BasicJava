package kr.or.ddit.study10;

import java.util.Scanner;

public class ExceptionExample01 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ExceptionExample01 obj = new ExceptionExample01();
		obj.process();
	}

	public void process() {
		int a = 10;
		int[] b = {1, 2, 0};
		try {
			System.out.println("출력");
			for(int i = 0; i<b.length; i++) {
				double result = a/b[i];
				System.out.println("결과 값 : "+result);
			}
			
		} 
		catch (ArithmeticException e) {
			System.out.println("잘못된 숫자로 나눴습니다.");
		}
		catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위가 벗어남. ");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("종료 되었습니다.");
	}
}
		
		
			
		
