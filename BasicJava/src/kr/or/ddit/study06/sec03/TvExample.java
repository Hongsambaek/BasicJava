package kr.or.ddit.study06.sec03;

public class TvExample {
	public static void main(String[] args) {
		
			
		int b = 10;
		Tv tv1 = new Tv("LG", 60);
		System.out.println(tv1.company+", "+tv1.size);
		
		int a;
		a = 10;
		Tv tv2 = new Tv();
		tv2.company = "삼성";
		tv2.size = 65;
	}
}
