package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.FreeService;
import util.ScanUtil;
import util.View;
import view.Print;

public class MainController extends Print { // 화면이동의 역할 = 메뉴 선택

	static public Map<String, Object> sessionStorage = new HashMap<>();

	FreeService freeservice = FreeService.getInstance();

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
			case LIST:
				view = list();
				break;
			case INSERT:
				view = insert();
				break;
			case UPDATE:
				view = update();
				break;
			case DELETE:
				view = delete();
				break;
			case DETAIL:
				view = detail();
				break;
			default:
				break;
			}
		}
	}

	private View home() {
		System.err.println("---------------자유게시판 (홈)------------------");
		System.out.println("1. 게시판 전체 출력");
		System.out.println("2. 게시판 추가");

		int sel = ScanUtil.menu();
		if (sel == 1)
			return View.LIST;
		else if (sel == 2)
			return View.INSERT;
		else
			return View.HOME;
	}

	private View list() {
		System.err.println("---------------게시판 전체 출력------------------");
		List<Map<String, Object>> list = freeservice.list();
		for (Map<String, Object> map : list) {
			System.out.println(map);
		}

		System.out.println("1. 게시판 상세조회");
		System.out.println("2. 홈");

		int sel = ScanUtil.menu();
		if (sel == 1) {
			int boardno = ScanUtil.nextInt("게시판 번호 입력 : ");
			sessionStorage.put("boardno", boardno);
			return View.DETAIL;
		} else if (sel == 2)
			return View.HOME;
		else
			return View.HOME;
	}

	private View detail() {
		System.err.println("---------------게시판 상세 조회------------------");
		int boardno = (int) sessionStorage.get("boardno");
		
		List<Object> param = new ArrayList<Object>();
		param.add(boardno);
		Map<String,Object > detail = freeservice.detail(param);
		System.out.println(detail);
		
		
		System.out.println("1. 게시판 수정");
		System.out.println("2. 게시판 삭제");
		System.out.println("3. 게시판 전체 출력");
		int a = ScanUtil.menu();
		if (a == 1)
			return View.UPDATE;
		else if (a == 2)
			return View.DELETE;
		else if (a == 3)
			return View.LIST;
		else
			return View.HOME;
	}

	private View update() {
		System.err.println("---------------게시판 수정------------------");
		return View.DETAIL;
	}

	private View delete() { //상세조회 이후에 들어와서 boarno이 존재
		System.err.println("---------------게시판 삭제------------------");
		
		int boardno = (int) sessionStorage.get("boardno");
		List<Object> param = new ArrayList();
		param.add(boardno);
		freeservice.delete(param);
		return View.LIST;
	}

	private View insert() {
		System.err.println("---------------게시판 추가 ------------------");
		
		
		String name = ScanUtil.nextLine("제목 : ");
		String content = ScanUtil.nextLine("내용 : ");
		String writer = ScanUtil.nextLine("작성자 : ");		
		List<Object> param = new ArrayList();
		param.add(name);
		param.add(content);
		param.add(writer);
		
		freeservice.insert(param);
		
		return View.LIST;
	}
}
