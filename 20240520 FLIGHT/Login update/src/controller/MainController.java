package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

import service.CusInfoService;
import util.ScanUtil;
import util.View;
import view.Print;

public class MainController extends Print {

	static public Map<String, Object> sessionStorage = new HashMap<>();
	CusInfoService memberService = CusInfoService.getInstance();

	// 화면이동
	public static void main(String[] args) {
		new MainController().start();
	}

	private void start() {
		View view = View.CUSINFO_HOME;
		while (true) {
			switch (view) {
			case CUSINFO_HOME:
				view = home();
				break;
			case CUSINFO_LOGIN:
				view = login();
				break;
			case CUSINFO_SIGN:
				view = sign();
				break;
			case CUSINFO_REMOVE:
				view = remove();
				break;
			default:
				break;
			}
		}
	}

	public View login() {
		System.out.println("\n로그인 메뉴");

		List<Object> param = new ArrayList();
		String id = ScanUtil.nextLine("아이디 : ");
		String pw = ScanUtil.nextLine("패스워드 : ");
		param.add(id);
		param.add(pw);

		boolean loginChk = memberService.login(param);
		if (loginChk) {
			Map<String, Object> member = (Map<String, Object>) sessionStorage.get("member");
			System.out.println("\n" + member.get("NAME") + "님 환영합니다");
			System.out.println();
		} else {
			System.out.println("로그인에 실패했습니다.");
			return View.CUSINFO_LOGIN;
		}

		return View.CUSINFO_HOME;
	}
	
	public View remove() {
		System.out.println("정말 가시게요?");

		List<Object> param = new ArrayList();
		String id = ScanUtil.nextLine("탈퇴할아이디 : ");
		String pw = ScanUtil.nextLine("패스워드 : ");
		param.add(id);
		param.add(pw);

		boolean loginChk = memberService.remove(param);
		if (loginChk) {
			Map<String, Object> member = (Map<String, Object>) sessionStorage.get("member");
//			System.out.println("\n" + member.get("NAME") + " 만나서 반가웠어요!");
			System.out.println("회원탈퇴가 완료되었습니다. 이용해주셔서 감사합니다"
					+ "");
		} else {
			System.out.println("회원탈퇴가 정상적으로 완료되지 않았습니다. 아이디와 비밀번호를 다시 확인해주세요");
			//시뻘건거 보기 싫으면 예외처리 해야 함
			return View.CUSINFO_REMOVE;
		}

		return View.CUSINFO_HOME;
	}
	
	public static String randomCUS_NO() {
        // 랜덤한 문자열을 생성할 문자셋
        String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int charsetLength = charset.length();
        Random random = new Random();
        StringBuilder randomString = new StringBuilder();
        // 7자리의 난수 생성
        for (int i = 0; i < 7; i++) {
            // 랜덤한 인덱스를 생성하여 해당 인덱스의 문자를 추출하여 문자열에 추가
            randomString.append(charset.charAt(random.nextInt(charsetLength)));
        }
        return randomString.toString();
    }

	public View sign() {
		System.out.println("회원가입");

		List<Object> param = new ArrayList<Object>();
		String no = randomCUS_NO();
		String name = ScanUtil.nextLine("성함을 입력해주세요 : ");
		if(name.length()>20) {
			System.out.println("입력오류입니다. 다시 입력해주세요");
			return View.CUSINFO_SIGN;
		}
		String pass = ScanUtil.nextLine("여권번호를 입력해주세요 : ");
		String id = ScanUtil.nextLine("아이디를 입력해주세요 : ");
		String pw = ScanUtil.nextLine("패스워드를 입력해주세요 : ");
		String telno = ScanUtil.nextLine("전화번호를 입력해주세요 : ");
		String address = ScanUtil.nextLine("주소를 입력해주세요 : ");
		String rating = "3"; //기본 등급 3 관리자가 등급 설정할 수 있도록 할 거임
		
		param.add(no);
		param.add(name);
		param.add(pass);
		param.add(id);
		param.add(pw);
		param.add(telno);
		param.add(address);
		param.add(rating);	

		memberService.sign(param);

		System.out.println();
		System.out.println("회원가입 완료!");
		System.out.println();
		
		return View.CUSINFO_HOME;
	}

	private View home() {
// 오늘은 세션 스토리지까지 하고 마무리하자
		System.out.println("1. 로그인 - 수정완료");
		System.out.println("2. 회원가입 - 수정완료");
		System.out.println("3. 회원탈퇴 - 수정완료");
		
		System.out.println("4. 회원정보 수정 / 미구현");
		System.out.println("5. 아이디 찾기 / 비밀번호 찾기/ 미구현");
		
		int sel = ScanUtil.nextInt("메뉴선택 : ");
		System.out.println();
		if (sel == 1)
			return View.CUSINFO_LOGIN;
		else if (sel == 2)
			return View.CUSINFO_SIGN;
		else if (sel == 3)
			return View.CUSINFO_REMOVE;
		else
			return View.CUSINFO_HOME;
		
		
	}

}
//dao는 디비에 접속기능
//컨트롤러 - 서비스 - 다오 연결
//