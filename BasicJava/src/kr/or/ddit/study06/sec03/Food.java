package kr.or.ddit.study06.sec03;

public class Food {
	// 제조일자
	int manuYear ;
	int lastYear ;
	String name;
	int price;
	
	//기본생성자
	public Food () {
	
	}
	// manuYear name price
	// lastYear 값은 입렬 받은 제조년에서 3년 추가할 것
	public Food (int manuYear,  String name, int price) {
		this.manuYear = manuYear;
		lastYear = manuYear+3;
		this.name = name;
		this.price = price;
		
	}
	@Override
	public String toString() {
		return "Food [manuYear=" + manuYear + ", lastYear=" + lastYear + ", name=" + name + ", price=" + price + "]";
	}
	
}