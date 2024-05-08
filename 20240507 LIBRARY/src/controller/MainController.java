package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.BookService;
import service.MemberService;
import util.ScanUtil;
import util.View;
import view.Print;

public class MainController extends Print { // 화면이동의 역할 = 메뉴 선택

	static public Map<String, Object> sessionStorage = new HashMap<>();

	MemberService memberService = MemberService.getInstance();
	BookService bookService = BookService.getInstance();

	public static void main(String[] args) {
		new MainController().start();
	}

	private void start() {
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;
			case ADMIN:
				view = admin();
				break;
			case BOOK_INFO:
				view = bookInfo();
				break;
			case BOOK_HOLD:
				view = hold();
				break;
			case LOGIN:
				view = login();
				break;
			case MY_BOOK_LOAN:
				view = myloan();
				break;
			case BOOK_UPDATE:
				view = bookUpdate();
				break;
//			case BOOK_LOAN:
//				view = bookloan();
//				break;
			case BOOK_LIST:
				view = booklist();
				break;
			case MEMBER:
				view = member();
				break;
			case HOLD_LIST:
				view = holdList();
				break;
			
			default:
				break;
			
			}
		}
	}
	
	private View holdList() {
		
		int page = 1;
		if(sessionStorage.containsKey("page")) page = (int) sessionStorage.remove("page");
		int startNo = 1+ (page-1)*5; 
		int endNo = page*5;
		
		List<Object> param = new ArrayList();
		param.add(startNo);
		param.add(endNo);
		List<Map<String, Object>> list = bookService.holdList(param);
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}
		System.out.println("<이전페이지\t다음페이지>");
		System.out.println("1. 홈");
		String sel = ScanUtil.nextLine("메뉴 : ");
		if(sel.equals("<")) {
			if(page != 1) page--;
			sessionStorage.put("page", page);
			return View.HOLD_LIST;
		}
		
		else if(sel.equals(">")) {
			page++;
			sessionStorage.put("page", page);
			return View.HOLD_LIST;
		}
		
		else if(sel.equals("1")) {
			return View.HOLD_HOME;
		}
		
		else return View.HOLD_LIST;
	}
	

	
	private View booklist() {
		List<Map<String, Object>> booklist = bookService.booklist();
		bookListPrint(booklist);
		return View.BOOK_INFO;
		}
	
	
	
	private View bookUpdate() {
		List<Map<String, Object>> booklist = bookService.booklist();
		bookListPrint(booklist);
		
		int bookNo = ScanUtil.nextInt("책 번호 선택");
		System.out.println("1. 제목");
		System.out.println("2. 내용");
		System.out.println("3. 전체");
		
		int sel = ScanUtil.menu();
		
		List<Object> param = new ArrayList();
		
		if(sel == 1 || sel == 3) {
			String title = ScanUtil.nextLine("제목 : ");
			param.add(title);
		}
		if(sel == 2 || sel == 3) {
			String content = ScanUtil.nextLine("내용 : ");
			param.add(content);
		}
		param.add(bookNo);
		bookService.bookUpdate(param,sel);
		
		return View.BOOK_LIST;
		}
		
	
	private View login() {
		String id = ScanUtil.nextLine("ID >>");
		String pw = ScanUtil.nextLine("PASS >>");
		int role  = (int) sessionStorage.get("role");
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		param.add(pw);
		param.add(role);
		memberService.login(param, role);
		boolean loginChk = memberService.login(param, role);
		if(!loginChk) {
			System.out.println("로그인 실패");
			return View.LOGIN;
		}
		if(role == 1) return View.MEMBER;
		else return View.ADMIN;
		
	}



	private View home() {
		printHome();
		
		int cnt = ScanUtil.menu();
		
		if(cnt == 1)
			return View.ADMIN;
		if(cnt == 2)
			return View.MEMBER;
		else
			return View.HOME;
	}
	
	private View admin() {
		if(!sessionStorage.containsKey("admin")) {
			sessionStorage.put("role", 2);
		return View.LOGIN;
		}
		printAdmin();
		
		
		
		int sel = ScanUtil.menu();
		if(sel == 1) return View.BOOK_INFO;
		else if(sel == 2) return View.BOOK_HOLD;
		else return View.ADMIN;
		
	}
	
	private View bookInfo() {
		System.out.println("==========도서 정보==========");
		System.out.println("1. 도서 정보 전체 출력");
		System.out.println("2. 도서 정보 추가");
		System.out.println("3. 도서 정보 변경");
		System.out.println("4. 도서 정보 삭제");
		System.out.println("5. 관리자 홈");
		
		int sel = ScanUtil.menu();
		
		if(sel == 1) return View.BOOK_LIST;
		else if(sel == 2) return View.BOOK_INSERT;
		else if(sel == 3) return View.BOOK_UPDATE;
		else if(sel == 4) return View.BOOK_DELETE;
		else if(sel == 5) return View.HOME;
		else return View.ADMIN;
	}
	
	private View hold() {
		System.out.println("==========도서 보유==========");
		System.out.println("1. 도서 구매");
		System.out.println("2. 도서 폐기");
		System.out.println("3. 보유도서 출력");
		System.out.println("4. 관리자 홈");
		
		int sel = ScanUtil.menu();
		if(sel == 1) return View.HOLD_INSERT;
		else if(sel == 2) return View.HOLD_DELETE;
		else if(sel == 3) return View.HOLD_LIST;
		else if(sel == 4) return View.ADMIN;
		return null;
	}
	
	private View member() {
		System.out.println("==========회원==========");
		System.out.println("1. 내 대여 도서 조회");
		System.out.println("2. 도서 대출");
		
		return null;
	}
	
	private View myloan() {
		System.out.println("==========내 대여 도서 조회==========");
		System.out.println("1. 도서 대출");
		System.out.println("2. 홈");
		
		return null;
	}
	
//	private View bookloan() {
//		System.out.println("==========도서 대출==========");
//		System.out.println("대출 가능 도서 출력");
//	}

}
