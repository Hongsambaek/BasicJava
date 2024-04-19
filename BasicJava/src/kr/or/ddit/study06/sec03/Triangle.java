package kr.or.ddit.study06.sec03;

public class Triangle {
	Point p1;
	Point p2;
	Point p3;
	
	double area;
	// 기본생성자 x
	// 1. Point를 파라미터로 하는 생성자 만들기
	
	public Triangle (Point p1, Point p2, Point p3) {
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		
		area = ((p1.x*p2.y + p2.x*p3.y + p3.x*p1.y) - (p1.x*p3.y + p2.x*p1.y + p3.x*p2.y))/2.0;
	    area = Math.abs(area);

//	      if(area < 0) area = -area;
	}
	
	// 2. int x1, y1, x2, y2, x3, y3 을 파라미터로 사용하는 생성자 만들기
	
	public Triangle (int x1, int y1, int x2, int y2, int x3, int y3) {
//		this.p1 = new Point(x1, y1);
//		this.p2 = new Point(x2, y2);
//		this.p3 = new Point(x3, y3);
		this(new Point(x1, y1), new Point (x2, y2), new Point(x3, y3));
	}
	
	@Override
	public String toString() {
//		return "("+p1.x+", "+p1.y+"), "+"("+p2.x+", "+p2.y+"), "+"("+p3.x+", "+p3.y+")";
		return p1+", "+ p2 +", "+ p3;
		
	}
	
	
}
