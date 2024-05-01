package controller; //화면이동의 역할

import java.util.*;

import service.MemberService;
import util.ScanUtil;
import util.View;
import view.Print;

public class MainController extends Print {
	
	static public Map<String, Object> sessionStorage = new HashMap<>();
	MemberService memberService = MemberService.getInstance();
	

	public static void main(String[] args) {
		new MainController().start();
	}

	private void start() {
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home();
			case LOGIN:
				view = login();
			case SIGN:
				view = sign();
				break;
			default:
				break;
			}
		}
	}
	
	public View login() {
		System.out.println("LogIn Menu");
		
		List<Object> param = new ArrayList();
		String id = ScanUtil.nextLine("ID : ");
		String pw = ScanUtil.nextLine("PW : ");
		param.add(id);
		param.add(pw);
		boolean loginChk = memberService.login(param);
		if(loginChk) {
			Map<String, Object> member = (Map<String, Object>) sessionStorage.get("member");
			System.out.println(member.get("NAME"+"")+"님 환영합니다.");
		}
		else {
			System.out.println("Login Failed");
			return View.LOGIN;
		}
		
		return View.HOME;
	}
	
	public View sign() {
		System.out.println("Sign Menu ");
		
		List<Object> param = new ArrayList<Object>();
		
		String id = ScanUtil.nextLine("ID >>");
		String name = ScanUtil.nextLine("NAME >>");
		String pw = ScanUtil.nextLine("PASS >>");
		
		param.add(id);
		param.add(name);
		param.add(pw);
		memberService.sign(param);
		
		return View.HOME;
	}

	private View home() {
		
		System.out.println("1. 로그인");
		System.out.println("2. 회원가입");
		
		int sel = ScanUtil.nextInt("Select Menu : ");
		if(sel == 1) return View.LOGIN;
		else if(sel == 2) return View.SIGN;
		else return View.HOME;
		
		
	}

}
