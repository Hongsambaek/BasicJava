package kr.or.ddit.study05.sec02;

import java.util.Scanner;

public class ArrayExample01 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample01 obj = new ArrayExample01();
		obj.process();
	}

	public void process() {
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
//		method6();
//		method7();


		//ctrl+shift+o 눌러서 불러오기
	}
	
	public void method1() {
		//변수 5개 만들고 각각에 0~100 사이 값을 넣을것.
		int a = 20;
		int b = 40;
		int c = 50;
		int d = 70;
		int e = 80;
		//총합 구하기
		int sum = a+b+c+d+e;
		System.out.println(sum);
	}
	
	public void method2() {
		
//		int[] students = new int[5];
//		int[] 			<- 	1차원 배열
//		students 		<- 	배열 이름(변수)
//		new int[배열크기] 	<- 	배열 생성
		
		int[] students = new int[5];
		students[0] = 20;
		students[1] = 40;
		students[2] = 50;
		students[3] = 70;
		students[4] = 80;
		
		int sum = 0;
		for(int i=0; i<students.length; i++) {
			sum+=students[i];
		}

	}
	
	public void method3() {
		//크기 3짜리 배열을 만들고
		//3개의 값을 입력해보시오
		//array
		int[] array = new int[3];
		array[0] = 10;
		array[1] = 20;
		array[2] = 30;
		
		int sum = 0;
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
	}
	
	public void method4() {
//		int a;
//		a=10;
//		int b = 10;
		int[] array = {1,2,3,4,5};
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		}
		
		//역순으로 출력 5 4 3 2 1
		for(int i=0; i<array.length; i++) {
			System.out.println(array[array.length-1-i]+"\t");
		}
	}
	
	public void method5() {
		int a = 10;
		int b = 7;
		
		int c = a; 
		a = b;
		b = c;
		// a 값과 b 값을 바꿔보기
		
		System.out.println("a :"+a+", b : "+b);
	}
	
	public void method6() {
		int [] score = {60,70,80,90,100};
		//최대값 구하기
		int max = score[0]; //or Integer.Min_VALUE;
		
		for(int a = 0; a<score.length; a++) {
			if(max<score[a]) {
				max = score[a];
			}
		}
		System.out.println("최대값은 : "+max);
		
		//최소값 구하기
		for(int b = 0; b<score.length; b++) {
			if(max>score[b]) {
				max = score[b];				
			}
		}
		System.out.println("최소값은 : "+max);
		
	}
	
	public void method7() {
		//거스름돈을 입력 받아 화폐 단위별로 개수를 구하시오.
		//ex) 77650원 → 10000원 7개, 5000원 1개, 1000원 2개,
		//	  500원 1개, 100원 1개, 50원 1개
		
		int [] coin = {10000, 5000, 1000, 500, 100, 50, 10};
			System.out.print("거스름돈을 입력 하세요 : ");
			int money = sc.nextInt();
			
			for(int i =0; i<coin.length; i++) {
				int result = money / coin [i]; 
				money%=coin[i];
				if(result == 0) continue;
				System.out.println(coin[i]+ " "+result+"개");
			}	
		}
}
