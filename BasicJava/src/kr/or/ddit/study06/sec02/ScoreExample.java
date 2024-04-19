package kr.or.ddit.study06.sec02;

public class ScoreExample {
	public static void main(String[] args) {
		// 2명의 객체를 생성하고		
		Score sc1 = new Score();
		Score sc2 = new Score();
		
		// 국영수 값을 각각 넣어보시오		
		sc1.kor = 90;
		sc1.eng = 70;
		sc1.math = 84;
		
		sc2.kor = 86;
		sc2.eng = 60;
		sc2.math = 100;
		
		//평균값 of s1, s2
		sc1.avg = ((sc1.kor + sc1.eng + sc1.math)/3.0);
//		System.out.println("s1의 평균 : "+sc1.avg);
		
		System.out.println("국어:"+sc1.kor+" 수학:"+sc1.math+" 영어:"+sc1.eng +" 평균: " +sc1.avg);
		
		sc2.avg = ((sc2.kor + sc2.eng + sc2.math)/3.0);
		System.out.println("국어:"+sc2.kor+" 수학:"+sc2.math+" 영어:"+sc2.eng +" 평균: " +sc2.avg);
	}
}
