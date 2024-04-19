package kr.or.ddit.study06.sec03;

public class Student {
	String nation; // 국가
	String roomNo; // 호실
	String name; // 이름
	int age; // 나이
	
	public Student(String name, int age) {
//		this.name = name;
//		this.age = age;
//		nation = "한국";   //this가 붙지 않은것은 기본값으로 설정하므로 입력할때는 넣지않음
//		roomNo = "306호";
		this("306호", name, age);
		System.out.println("파라미터 2개 생성자");
	}
	
	public Student(String roomNo, String name, int age) {
//		this.name = name;
//		this.age = age;
//		nation = "한국";   //this가 붙지 않은것은 기본값으로 설정하므로 입력할때는 넣지않음
//		this.roomNo = roomNo;
		this("한국", roomNo, name, age);
		System.out.println("파라미터 3개 생성자");
	}
		
		public Student(String roomNo, String nation, String name, int age) {
			this.name = name;
			this.age = age;
			this.nation = nation;   //this가 붙지 않은것은 기본값으로 설정하므로 입력할때는 넣지않음
			this.roomNo = roomNo;
			System.out.println("파라미터 4개 생성자");
		}
	@Override
	public String toString() {
		return "Student [nation=" + nation + ", roomNo=" + roomNo + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
	
	
}
