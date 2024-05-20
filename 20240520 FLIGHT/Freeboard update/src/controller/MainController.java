package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import service.FreeBoardService;
import util.ScanUtil;
import util.View;
import view.Print;

public class MainController extends Print {

	static public Map<String, Object> sessionStorage = new HashMap<>();
	boolean debug = true;
	FreeBoardService freeboardService = FreeBoardService.getInstance();

	// 화면이동
	public static void main(String[] args) {
		new MainController().start();
	}

	private void start() {
		View view = View.FREEBOARD_HOME;
		while (true) {
			switch (view) {
			case FREEBOARD_HOME:
				view = home();
				break;
			case FREEBOARD_LIST:
				view = list();
				break;
			case FREEBOARD_INSERT:
				view = insert();
				break;
			case FREEBOARD_UPDATE:
				view = update();
				break;
			case FREEBOARD_DELETE:
				view = delete();
				break;
			case FREEBOARD_DETAIL:
				view = detail();
				break;
			default:
				break;
			}
		}
	}
	public View detail() {
		if(debug)System.out.println("======게시판 상세 조회======");
		
		int boardNo = ScanUtil.nextInt("게시판 번호 입력 :");
		
		List<Object> param = new ArrayList<Object>();
		param.add(boardNo);
		Map<String,Object> detail = freeboardService.detail(param);
		System.out.println(detail);
		
		
		System.out.println("1.게시판 수정");
		System.out.println("2.게시판 삭제");
		System.out.println("3.게시판 조회");
		
		int sel = ScanUtil.menu();
		if(sel == 1) return View.FREEBOARD_UPDATE;
		if(sel == 2) return View.FREEBOARD_DELETE;
		if(sel == 3) return View.FREEBOARD_LIST;
		else return View.FREEBOARD_DETAIL;
		
	}
	public View delete() {
		if(debug)System.out.println("======게시판 삭제======");
		List<Object> param = new ArrayList<Object>();
		int boardNo = ScanUtil.nextInt("삭제할 게시판 번호 입력 :");
		param.add(boardNo);
		freeboardService.delete(param);
		return View.FREEBOARD_LIST;
	}
	
	
	public View update() {
		if(debug)System.out.println("======게시판 수정======");
		List<Object> param = new ArrayList();
		String no = ScanUtil.nextLine("수정할 게시판 번호를 입력해주세요: ");
		String name = ScanUtil.nextLine("제목수정 : ");
		String content = ScanUtil.nextLine("내용수정 : ");
		param.add(name);
		param.add(content);
		param.add(no);

		freeboardService.update(param);

		System.out.println("게시글이 수정되었습니다.");
		return View.FREEBOARD_HOME;
	}
		
	public View insert() {
		System.out.println("게시할 글의 제목과 내용을 입력해주세요");

		List<Object> param = new ArrayList();

		String name = ScanUtil.nextLine("제목 : ");
		String content = ScanUtil.nextLine("내용 : ");
		param.add(name);
		param.add(content);

		freeboardService.insert(param);

		System.out.println("게시글이 작성되었습니다.");
		return View.FREEBOARD_HOME;
	}
	
	
	public View list() {
		System.out.println("=====리스트 페이지=====");
		List<Map<String,Object>>list = freeboardService.list();
		for(Map<String,Object> map : list) {
			System.out.println(map);
		}
		System.out.println("1. 게시판 상세 조회");
		System.out.println("2. 홈");
		int sel = ScanUtil.menu();
		
		if(sel == 1) {
			return View.FREEBOARD_DETAIL;
		}
		else if (sel == 2) return View.FREEBOARD_HOME;
		else return View.FREEBOARD_LIST;
	}
	

	private View home() {
		
		System.out.println("1. 게시글 조회");
		System.out.println("2. 게시글 작성");
		System.out.println("3. 게시글 수정");
		System.out.println("4. 게시글 삭제");
		

		int sel = ScanUtil.nextInt("메뉴선택 : ");
		System.out.println();
		if (sel == 1)
			return View.FREEBOARD_LIST;
		else if (sel == 2)
			return View.FREEBOARD_INSERT;
		else if (sel == 3)
			return View.FREEBOARD_UPDATE;
		else if (sel == 4)
			return View.FREEBOARD_DELETE;
		else
			System.out.println("선택하신 메뉴는 없는 메뉴입니다. \n메뉴를 다시 선택해주세요.");
			return View.FREEBOARD_HOME;
	}

}
//dao는 디비에 접속기능
//컨트롤러 - 서비스 - 다오 연결
//