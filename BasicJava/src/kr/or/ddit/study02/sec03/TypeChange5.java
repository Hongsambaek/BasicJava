package kr.or.ddit.study02.sec03;

public class TypeChange5 {
	public static void main(String[] args) {
		// 소수점 버림
		double d = 10.1231;
		System.out.println("원래 숫자: "+d);
		
		int i10 = (int)(d*10);
		double d10 = i10/10.0;
		
		// double d1 = (double)((int)*(d*10))/10;
		double d1 = (double)((int)(d*10));
		System.out.println("소수점 첫자리 출력 : "+d10);
		
		// 소수점 둘째짜리 까지 출력
		
		int i100 = (int)(d*100);
		double d100 = i100/100.0;
		double d2 = (double)((int)(d*100))/100;
		
	//	double d2 = (int)(d*100)/100.0;
		
		System.out.println("소수점 둘째자리 출력: "+d100);
		
	}
}
