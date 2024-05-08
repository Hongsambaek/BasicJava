package view;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class Print {
	
	
	public void printVar() {
		System.out.println("==============================");
	}
	
	public void println(int num) {
		for(int i = 0; i<num; i++) System.out.println();
	}
	
	public void printAdmin() {
		printVar();
		System.out.println("1. 도서 정보 ");
		System.out.println("2. 도서 보유 ");
		println(5);
		printVar();
	}
	
	public void printHome() {
		printVar();
		System.out.println("1. 관리자");
		System.out.println("2. 일반 회원");
		println(5);
		printVar();
	}
	
	public void bookListPrint(List<Map<String, Object>> booklist) {
		for(Map<String, Object> map : booklist) {
			BigDecimal bookno = (BigDecimal) map.get("BOOK_NO");
			String title = (String) map.get("TITLE");
			String content = (String) map.get("CONTENT");
			String pubdate = (String) map.get("PUBDATE");
			System.out.println(bookno+"\t"+title+"\t"+content+"\t"+pubdate);
		}
		printVar();
	}
	
	
}
