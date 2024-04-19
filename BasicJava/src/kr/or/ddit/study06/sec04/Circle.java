package kr.or.ddit.study06.sec04;

public class Circle {
	final double PI = Math.PI;


	
	

	//ctrl+shift+o 눌러서 불러오기
	// 반지름을 파라미터로 받고 원의 넓이를 구하시오.
	// 넓이 3.14*r*r
	// 메소드 명 area
	public double area(double r) {
		return PI*r*r;
	}
	
	// 반지름을 파라미터로 받고 원의 둘레를 구하시오.
	// 둘레 2*3.14*r
	// 메소드 명 circumference
	public double circumference(double r) {
		return 2*PI*r;
	}
	
}