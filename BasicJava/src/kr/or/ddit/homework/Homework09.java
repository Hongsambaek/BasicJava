package kr.or.ddit.homework;

import java.util.Scanner;

public class Homework09 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Homework09 obj = new Homework09();
		obj.process();
	}

	public void process() {
		Score s1 = new Score();
		s1.name = "나연";
		s1.kor = 80;
		s1.eng = 70;
		s1.math = 80;
	
		
		Score s2 = new Score();
		s2.name = "정연";
		s2.kor = 90;
		s2.eng = 90;
		s2.math = 80;
	
		
		Score s3 = new Score();
		s3.name = "채영";
		s3.kor = 80;
		s3.eng = 70;
		s3.math = 60;
		
		
		Score s4 = new Score();
		s4.name = "다연";
		s4.kor = 65;
		s4.eng = 75;
		s4.math = 85;
		
		
		Score s5 = new Score();
		s5.name = "미나";
		s5.kor = 76;
		s5.eng = 80;
		s5.math = 86;
		
		Score s6 = new Score();
	
		
		Score[] scores = {s1, s2, s3, s4, s5};
		// 1. 총점/평균
		
		for (int i = 0; i < scores.length; i++) {
			scores[i].sum = scores[i].kor+scores[i].eng+scores[i].math; 
			scores[i].avg = scores[i].sum/3.0;
		
		
		//선생님 풀이
//		for(Score s : scores) {
//			s.sum = s.kor + s.eng + s.math;
//			s.avg = s.sum/3.0;
			
		}
		
		//정렬
		//총점 기준으로 등수 정렬
		for(int i = 0; i<scores.length-1; i++) {
			boolean flag = true;
			for (int j = 0; j<scores.length-1; j++) {
				if(scores[j].sum < scores[j+1].sum) {
					s6 = scores[j];
					scores[j] = scores[j+1];
					scores[j+1] = s6;
					flag = false;
			}
		}
			if(flag) break;
		}
		
		// 2. 등수 구하기
		int rank = 1; 
		for(int i = 0; i<scores.length; i++) {
			for(int j = 0; j<scores.length; j++) {
				scores[i].rank = rank;
			}rank++;
		}
		
		
		//선생님 풀이
//		for(int i = 0; i<scores.length; i++) {
//			for(int j = 0; j<scores.length; j++) {
//				if(scores[i].sum < scores[j].sum) {
//					scores[i].rank++;
//				}
//			}
//		}
		
		
		// 3. 출력
			for(int i = 0; i<scores.length; i++) {
				System.out.println(scores[i]);
			}
//			for(Score s : scores) {
//			System.out.println(s);
//			}
		
		// 4. 정렬
		
		
		
		// 5. 출력
		
		
  }
	
	
	
class Score {
	//이름 국영수 총점 평균 등수
	String name;
	int kor;
	int eng;
	int math;
	int sum;
	
	double avg;
	int rank;
	
	// toString 만들기
	public String toString() {
		return "이름 : "+name+", 국어 : "+kor+", 영어 : "+eng+", 수학 : "+math+", 총점 : "+sum+", 평균 : "+avg+", 등수 : "+rank;

	}
	
	public int ranks() {
		return rank;
	}
	
	}
}