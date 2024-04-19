package kr.or.ddit.homework;

import java.util.Scanner;

public class Homework06 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Homework06 obj = new Homework06();
		obj.process();
	}

	public void process() {
//		method1();
//		method2();
//		method3();
		method4();

		// ctrl+shift+o 눌러서 불러오기
	}

	public void method1() {
		// 스캐너를 통해 숫자를 입력받고 해당 숫자에 해당하는 구구단을 출력하시오.
		System.out.println("숫자를 입력하시오.");
		int sum = sc.nextInt();
		for (int num = 1; num < 10; num++) {
			System.out.println(sum + "x" + num + "=" + (sum * num));
		}

	}

	public void method2() {
		// for문 2개를 이용하여 구구단 전체를 출력하시오.
		// 2*1=2 ......................... 9*9=81
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				System.out.print(j + "x" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}

	}

	public void method3() {
		// 3입력시 3단을 제외한 나머지 구구단출력, 4입력시 4단을 제외한 구구단출력
		System.out.println("숫자를 입력하세요");
		int a = sc.nextInt();
		for (int i = 1; i < 10; i++) {
			for (int j = 2; j < 10; j++) {
				if (j == a)
					continue;
				System.out.print(j + "x" + i + "=" + i * j + "\t");

			}
			System.out.println();
		}
	}

	public void method4() {
		// 양의 정수 n이 매개변수로 주어질때
		// n이홀수라면 n이하의 홀수인 모든 양의 정수 합
		// → n = 5
		// 1 + 3 + 5 = 9
		// n이 짝수라면 n 이하의 짝수인 모든 양의 정수제곱의 합
		// → n = 4
		// 2*2 + 4*4 = 20

		int n = (int) (Math.random() * 100) + 1;
		int sum = 0;
		System.out.println("매개변수는" + n + "입니다.");
		for (int a = 1; a <= n; a++) {
			if (n % 2 == 1) {
				for (int b = 1; b <= n; b++) {
					if (b % 2 == 0)
						continue;
					sum += b;
				}
				System.out.println(n + "이하의 모든 양의 홀수의 합 : " + sum + "입니다. ");
				break;
			}else {
				for(int b = 1; b<=n; b++) {
					if(b%2==1) 
					continue;
				sum += b*b;
				}
				System.out.println(n + "이하의 짝수인 모든 양의 정수제곱의 합 : "+sum+ "입니다. ");
				break;
			}
		}
	}
}
