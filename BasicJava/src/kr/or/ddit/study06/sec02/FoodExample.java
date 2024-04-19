package kr.or.ddit.study06.sec02;

public class FoodExample {
	public static void main(String[] args) {
		// 객체 2개 생성후 적절한 값을 넣어보시오. 
		
		Food f1 = new Food();
		Food f2 = new Food();
		
		f1.year = "2024.02.20";
		f1.name = "초코파이";
		f1.price = 2500;
		
		f2.year = "2024.03.02";
		f2.name = "샤오롱만두";
		f2.price = 2000;
		
//		System.out.println(f1.name +" 유통기한 :"+f1.year+" 가격:"+f1.price);
//		System.out.println(f2.name +" 유통기한 :"+f2.year+" 가격:"+f2.price);
		
		System.out.println(f1);
		System.out.println(f2);
	}
}
