package view;

public class Print {
	
	public void printVar() {
		System.out.println("==============================");
	}
	
	public void println(int num) {
		for(int i = 0; i<num; i++) System.out.println();
	}
	
	public void printHome() {
		printVar();
		System.out.println("1. 전체게시판 조회");
		System.out.println("2. 게시판 등록");
		printVar();
	}
	
	public void printAdmin() {
		printVar();
		System.out.println("1. 게시판 관리자");
		System.out.println("2. 회원 관리");
		printVar();
	}
	
}
