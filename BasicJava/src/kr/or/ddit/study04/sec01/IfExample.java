package kr.or.ddit.study04.sec01;

import java.util.Scanner;

public class IfExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		IfExample obj = new IfExample();
		obj.process();
	}

	public void process() {
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
		method6();

		//ctrl+shift+o 눌러서 불러오기
	}
	
	public void method1() {
		if(false) {
			System.out.println("IF안 실행문 ");
		}
		System.out.println("IF밖 실행문 ");
	}
	
	public void method2() {
		//점수를 입력 받아 60점 이상이면 합격 아니면 불합격 출력
		System.out.println("점수를 입력하세요 : ");
		int score = sc.nextInt();
//		if(score>=60) {
//			System.out.println("합격");
//		}
//		if(score<60) {
//			System.out.println("불합격");
//		}
		
		if(score>=60) {
			System.out.println("합격");
		}
		else {
			System.out.println("불합격");
		}
	}
	
	public void method3() {
		// 점수를 입력받고 학점을 출력하세요. //else 입력시 뒤에는 생략 if문이 성립하지 않을때
		// 90이상 A+
		// 80이상 B
		// 70이상 C
		// 60이상 D
		// 60미만 F
		int score = sc.nextInt();
		if (score>=90) {
			System.out.println("A 학점");	
		}		
		else if (score>=80) {
			System.out.println("B 학점");
		}		
		else if (score>=70) {
			System.out.println("C 학점");
		}
		
		
		else if (score>=60) {			
			System.out.println("D 학점");
		}
		
		else {
			System.out.println("F 학점");
		}
	}
	
	public void method4() {
		//월을 입력 바다 봄(3~5) 여름(6~8) 가을(9~11) 겨울(12~2)을 출력하시오
		System.out.println("월을 입력하세요");
		int month = sc.nextInt();
		if (month==3 || month==4 || month==5) {
			System.out.println("봄");
		}
		
		if (month==6 || month==7 || month==8) {
			System.out.println("여름");
		}
		
		if (month==9 || month==10 || month==11) {
			System.out.println("가을");
		}
		
		if (month==12 || month==1 || month==2) {
			System.out.println("겨울");
		}
		
	}
	
	public void method5() {
		// 키와 체중을 입력 하여 BMI 지수를 구하고
		// BMI 지수에 따른 정상, 과체중, 비만, 고도비만 정보를 출력하시오.
		// BMI 지수 = 체중(kg)/키(cm)*키
		
		// 0이상 ~ 18.4미만 : 저체중
		// 18.5이상 ~ 22.9미만 : 정상
		// 23.0이상 ~ 24.9미만 : 과체중
		// 25.0이상 ~ 29.9미만 : 비만
		// 30이상		   : 고도비만
		
		System.out.println("몸무게 : ");
		double weight = sc.nextDouble();
		System.out.println("키 : ");
		double height = sc.nextDouble();
		
		// height 값이 100보다 크다면 100나눠주기
		if(height>100)
		   height/=100;
		
		double bmi = weight/height/height;
		System.out.println(bmi);
		
		if (bmi<18.5) {
			System.out.println("저체중");
		}
	
		else if(bmi<23) {
			System.out.println("정상");
		}
		
		else if(bmi<25) {
			System.out.println("과체중");
		}
		
		else if(bmi<30) {
			System.out.println("비만");
		}
		
		else if(bmi>=30) {
			System.out.println("고도비만");
		}
	}	
	
	public void method6() {
		// 점수를 입력받고 학점을 출력하세요. //else 입력시 뒤에는 생략 if문이 성립하지 않을때
		// 90이상 A+
		// 80이상 B
		// 70이상 C
		// 60이상 D
		// 60미만 F
		// 끝자리가
		// 0 ~ 2 -
		// 3 ~ 6 0
		// 7 ~ 9 +
		int score = sc.nextInt();
		String grade = "";
		if(score == 100) {
			grade="A+";
		}
		else if(score>=90) {
			grade="A";
		}
		else if (score>=80) {
			grade="B";
		}
		else if (score>=70) {
			grade="C";
		}
		else if (score>=60) {
			grade="D";
		}
		else {
			grade="F";
		}
		
		if(score>60 && score !=100) {
			if(score%10<=2) {
				grade +="-";
		}
			else if(score%10<=5) {
				grade +="0";
		}
			else if(score%10<=9) {
				grade +="+";
		}
	}
	System.out.println(grade);
	}
}
