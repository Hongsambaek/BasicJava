package kr.or.ddit.study06.sec03;

public class ScoreExample {
	public static void main(String[] args) {
		
		Score sc1 = new Score(90, 80, 80);
		System.out.println(sc1);
		
		Score sc2 = new Score();
		sc2.kor = 90;
		sc2.eng = 80;
		sc2.math = 80;
		sc2.avg = (sc2.kor+sc2.eng+sc2.math)/3.0;	
		System.out.println(sc2);
	}
}
