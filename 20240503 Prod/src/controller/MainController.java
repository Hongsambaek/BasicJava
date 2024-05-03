package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.sasl.SaslClient;

import service.MemberService;
import service.ProdService;
import util.ScanUtil;
import util.View;
import view.Print;

public class MainController extends Print { // 화면이동의 역할 = 메뉴 선택

	static public Map<String, Object> sessionStorage = new HashMap<>();

	MemberService memberService = MemberService.getInstance();
	ProdService prodService = ProdService.getInstance();

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
			case GOODS_ADD:
				view = add();
				break;
			case GOODS_DELETE:
				view = delete();
				break;
			case GOODS_UPDATE:
				view = update();
				break;
			case GOODS_PRINT:
				view = adminList();
				break;
			case MEMBER :
				view = member();
				break;
			case LOGIN :
				view = login();
				break;
			default:
				break;
			}
		}
	}

	private View adminList() {
		List<Map<String,Object>> list = prodService.list();
		for(Map<String, Object> map : list) {
			System.out.println(map);
		}
		System.out.println("1. 다음 페이지");
		System.out.println("2. 이전 페이지");
		System.out.println("3. 홈(관리자)");
		
		int sel = ScanUtil.menu();
		if(sel == 1) return View.GOODS_PRINT;
		else if(sel == 2) return View.GOODS_PRINT;
		else if(sel == 3) return View.ADMIN;
		else return View.GOODS_PRINT;
		
	
	}

	private View home() {
		System.out.println("★★★★★★★★★★홈 페이지★★★★★★★★★★");
		System.out.println("1. 관리자");
		System.out.println("2. 일반 회원");
		int cnt = ScanUtil.menu();
		
		if(cnt == 1)
			return View.ADMIN;
		if(cnt == 2)
			return View.MEMBER;
		else
			return View.HOME;
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
	private View admin() {
		if(!sessionStorage.containsKey("admin")) {
			sessionStorage.put("role", 2);
			return View.LOGIN;
		}
		
		System.out.println("★★★★★★★★★★관리자 페이지★★★★★★★★★★");
		System.out.println("1. 상품 추가");
		System.out.println("2. 상품 삭제");
		System.out.println("3. 상품 변경");
		System.out.println("4. 상품 전체 출력");
		System.out.println("5. 로그아웃");
		
		int sel = ScanUtil.menu();
		if(sel == 1)
			return View.GOODS_ADD;
		else if(sel == 2)
			return View.GOODS_DELETE;
		else if(sel == 3)
			return View.GOODS_UPDATE;
		else if(sel == 4)
			return View.GOODS_PRINT;
		else if(sel == 5) {
			sessionStorage.remove("admin");
			return View.HOME;
		}
		else return View.ADMIN;
	}

	private View add() {
		System.out.println("★★★★★★★★★★상품 추가 출력★★★★★★★★★★");
		
		List<Object> param = new ArrayList();
		String name = ScanUtil.nextLine("상품명 : ");
		String type = ScanUtil.nextLine("타입 : ");
		int price = ScanUtil.nextInt("가격 : ");
		
		param.add(name);
		param.add(type);
		param.add(price);
		
		prodService.insert(param);
		
			return View.GOODS_PRINT;
	}

	private View delete() {
		System.out.println("★★★★★★★★★★상품 삭제 출력★★★★★★★★★★");
		List<Map<String,Object>> list = prodService.list();
		for(Map<String, Object> map : list) {
			System.out.println(map);
		}
		int prodNo = ScanUtil.nextInt("상품 번호 : ");
		List<Object> param = new ArrayList();
		param.add(prodNo);
		
		int result = prodService.delete(param);
		
		if(result == 0) {
			System.out.println("Delete Fail Man~~");
		}
			return View.GOODS_PRINT;
	}

	private View update() { 
		System.out.println("★★★★★★★★★★상품 변경 출력★★★★★★★★★★");
		List<Map<String,Object>> list = prodService.list();
		for(Map<String, Object> map : list) {
			System.out.println(map);
		}
		int prodNo = ScanUtil.nextInt("상품 번호 : ");
		String name = ScanUtil.nextLine("상품명 : ");
		String type = ScanUtil.nextLine("타입 : ");
		int price = ScanUtil.nextInt("가격 : ");
		
		List<Object> param = new ArrayList();
		param.add(name);
		param.add(type);
		param.add(price);
		param.add(prodNo);
		prodService.update(param);
		
			return View.GOODS_PRINT;
	}

	private View print() {
		System.out.println("1. 다음 페이지");
		System.out.println("2. 이전 페이지");
		System.out.println("3. 홈(관리자)");
		
		return View.HOME;
	}
	
	private View member() {
		System.out.println("1. 상품 전체 출력");
		System.out.println("2. 상품 구매");
		System.out.println("3. 구매 상품 조회");
		int num = ScanUtil.menu();
		
		if(num == 1) 
			return View.GOODS_PRINT;
		else if(num == 2)
			return View.GOODS_ADD;
		else if(num == 3)
			return View.GOODS_PRINT;
		else
			return View.HOME;
	}
}
