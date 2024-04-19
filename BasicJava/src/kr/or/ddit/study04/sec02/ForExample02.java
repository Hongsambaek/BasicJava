package kr.or.ddit.study04.sec02;

import java.util.Scanner;

public class ForExample02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ForExample02 obj = new ForExample02();
		obj.process();
	}

	public void process() {
//		method01();
//		method02();
//		method03();
//		method04();
//		method05();
		method06();
//		method07();
//		method08();
//		method09();
//		method10();

		//ctrl+shift+o 눌러서 불러오기
	}
	public void method01() {
		
		//continue
		//해당  loop를 종료 시키고 다음 loop로 진행시킨다.
		for(int i=0; i<10; i++) {
			if(i%2==0) continue;
			System.out.println(i);
		}
	}
	
	public void method02() {
		//영어를 입력 하고 모음을 제거하시오.
		//abcde → bcd
		System.out.println("영어를 입력하시오");
		String word = sc.next();
		for(int i =0; i<word.length(); i++) {
			char ch = word.charAt(i);
			if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') continue;
			System.out.print(ch);
			
		}
			
	}
	
	public void method03() {
		
		//break 문
		//반복문을 종료한다.
		for(char ch = 'a'; ch<='z'; ch++) {
			if(ch=='o') break;
			System.out.print(ch);
		}
	}
	
	public void method04() {
		
		//flag 많이 사용함
		boolean flag = true;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(i==30 && j==30) flag = false;
				if(flag) {
					System.out.println(i+", "+j);					
				}
				if(i==30 && j==30) flag = false;
			}
		}
	}
	
	public void method05() {
		//break걸기 //doolean: → 라벨 / 라벨은 자신이 설정해도됨
		END: 
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				System.out.println(i+", "+j);
				if(i==30 && j==30) {
					break END;
				}
			}
		}		
	}
	
	public void method06() {
		//구구단 출력		
		for(int i=1; i<=9; i++) {
			
			System.out.println("======"+i+"단========");
			for(int j=1; j<=9; j++)
			System.out.printf("%d x %d = %d\n", i,j,i*j);
		}
			System.out.println();
	}
	public void method07() {
		//method번호 넣기
	}
}
