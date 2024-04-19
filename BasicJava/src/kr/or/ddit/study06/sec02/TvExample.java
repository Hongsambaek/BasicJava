package kr.or.ddit.study06.sec02;

public class TvExample {
	public static void main(String[] args) {
		Tv tv1 = new Tv();
		tv1.company = "LG" ;
		tv1.size = 60;
		
		Tv tv2 = new Tv();
		tv2.company = "삼성";
		tv2.size = 65;
		
		
		System.out.println("회사 이름: "+tv2.company);
		System.out.println("사이즈 : "+tv2.size);
	}
}
