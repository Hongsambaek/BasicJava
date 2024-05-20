package controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import service.FlightService;
import service.FreeBoardService;
import service.MemberService;
import util.ScanUtil;
import util.View;
import view.Print;
import view.SeatTableControl;

public class MainController extends Print {

   static public Map<String, Object> sessionStorage = new HashMap<>();
   boolean debug = true;
   FreeBoardService freeBoardService = FreeBoardService.getInstance();
   MemberService memberService = MemberService.getInstance();
   FlightService flightService = FlightService.getInstance();
//   Print p = new Print();
   // 화면이동
   public static void main(String[] args) {
      new MainController().start();
   }
   
   private void start() {
      View view = View.MAIN;
      while (true) {
         switch (view) {
         case MAIN:
        	 view = main();
        	 break;
         case HOME:
        	 view = home();
        	 break;        
         case ADMIN:
             view = admin();
             break;
         case LOGIN:
        	 view = login();
        	 break;
        	 
         case FLIGHT_HOME:
             view = flight_home();
             break;	 
         case FLIGHT_LIST:
             view = list();
             break;
         case FLIGHT_RESERVATION:
             view = reservation();
             break;    
         case RES_LIST:
             view = resList();
             break;   
         case FLIGHT_REMOVE:
             view = resRemove();
             break;
             
         case FREEBOARD_HOME:
             view = board_home();
             break;
		 case FREEBOARD_LIST:
			 view = board_list();
			 break;
		 case FREEBOARD_INSERT:
			 view = board_insert();
			 break;
		 case FREEBOARD_UPDATE:
			 view = board_update();
			 break;
		 case FREEBOARD_DELETE:
			 view = board_delete();
			 break;
		 case FREEBOARD_DETAIL:
			 view = board_detail();
  			 break;    
  			 
         case MEMBER:
             view = member();
             break;
         case MEMBER_SIGN:
        	 view = sign();
        	 break;
         case MEMBER_REMOVE:
        	 view = mem_remove();
        	 break;
         case MEMBER_INFOR:
             view = infor();
             break;
         case MEMBER_UPDATE:
             view = update();
             break;    
         default:
            break;
         }
      }
   }
   
   
   
   private View main() {
	   flightImage();
//	   textImage();
	   
	   System.out.println("1. 로그인");
	   System.out.println("2. 회원가입");
	   
	   int sel = ScanUtil.nextInt(">> ");
	   if(sel == 1) return View.LOGIN;
	   else if(sel == 2) return View.MEMBER_SIGN;
	   else return View.MAIN;
	    
   }

   private View home() {
	
	   int sel = ScanUtil.nextInt(" ");
	   if(sel == 1) return View.LOGIN;
//	   else if(sel == 2) return 
	   else return View.HOME;
	   
   }

private View mem_remove() {
	   System.out.println("회원 탈퇴");

		List<Object> param = new ArrayList();
		String id = ScanUtil.nextLine("탈퇴할아이디 : ");
		String pw = ScanUtil.nextLine("패스워드 : ");
		param.add(id);
		param.add(pw);

		boolean loginChk = memberService.remove(param);
		if (loginChk) {
//			Map<String, Object> member = (Map<String, Object>) sessionStorage.get("member");
//			System.out.println("\n" + member.get("NAME") + " 만나서 반가웠어요!");
			System.out.println("회원탈퇴가 완료되었습니다. 이용해주셔서 감사합니다"
					+ "");
		} else {
			System.out.println("회원탈퇴가 정상적으로 완료되지 않았습니다. 아이디와 비밀번호를 다시 확인해주세요");
			//시뻘건거 보기 싫으면 예외처리 해야 함
			return View.CUSINFO_REMOVE;
		}

		return View.FLIGHT_HOME;
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
   
   private View sign() {
	   System.out.println("────────────회원가입────────────");

		List<Object> param = new ArrayList<Object>();
		String no = randomCUS_NO();
		String name = ScanUtil.nextLine("성함을 입력해주세요 : ");
		if(name.length()>20) {
			System.out.println("입력오류입니다. 다시 입력해주세요");
			return View.CUSINFO_SIGN;
		}
		String pass = ScanUtil.nextLine("여권번호를 입력해주세요 (영어1 + 숫자8): ");
		
		String id = ScanUtil.nextLine("아이디를 입력해주세요 (~20글자): ");
		if(id.contains("admin")) {
			System.out.println("ID에"+" admin은 포함될 수 없습니다.");
			 return View.MEMBER_SIGN;
		}
		String pw = ScanUtil.nextLine("패스워드를 입력해주세요 (~15글자) : ");
		String telno = ScanUtil.nextLine("전화번호를 입력해주세요 (예 : 010-1111-2222): ");
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
		
		return View.FLIGHT_HOME;
}

   private View board_home() {
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

   private View board_detail() {
	   if(debug)System.out.println("───────────게시판 상세 조회───────────");
		
		int boardNo = ScanUtil.nextInt("게시판 번호 입력 :");
		
		List<Object> param = new ArrayList<Object>();
		
		param.add(boardNo);
		Map<String,Object> detail = freeBoardService.detail(param);
		
		System.out.println(detail);
		
		System.out.println("─────────────────────────────────");
		System.out.println("1.게시판 수정");
		System.out.println("2.게시판 삭제");
		System.out.println("3.게시판 조회");
		
		int sel = ScanUtil.menu();
		if(sel == 1) return View.FREEBOARD_UPDATE;
		if(sel == 2) return View.FREEBOARD_DELETE;
		if(sel == 3) return View.FREEBOARD_LIST;
		else return View.FREEBOARD_DETAIL;
   }

   private View board_delete() {
	    System.out.println("────────────게시판 삭제────────────");
		List<Object> param = new ArrayList<Object>();
		int boardNo = ScanUtil.nextInt("삭제할 게시판 번호 입력 :");
		param.add(boardNo);
		freeBoardService.delete(param);
		return View.FREEBOARD_LIST;
   }

   private View board_update() {
	   if(debug)System.out.println("────────────게시판 수정────────────");
		List<Object> param = new ArrayList();
		String no = ScanUtil.nextLine("수정할 게시판 번호를 입력해주세요: ");
		String name = ScanUtil.nextLine("제목수정 : ");
		String content = ScanUtil.nextLine("내용수정 : ");
		param.add(name);
		param.add(content);
		param.add(no);

		freeBoardService.update(param);

		System.out.println("게시글이 수정되었습니다.");
		return View.FREEBOARD_HOME;
   }

   private View board_insert() {
	   System.out.println("게시할 글의 제목과 내용을 입력해주세요");

		List<Object> param = new ArrayList();

		String name = ScanUtil.nextLine("제목 : ");
		String content = ScanUtil.nextLine("내용 : ");
		param.add(name);
		param.add(content);

		freeBoardService.insert(param);

		System.out.println("게시글이 작성되었습니다.");
		return View.FREEBOARD_HOME;
   }
   
   private View board_list() {
	   System.out.println("──────────────────리스트 페이지──────────────────");
		List<Map<String,Object>>list = freeBoardService.list();
		int i = 1;
		System.out.println("게시판 번호       제목                             게시일");
		for(Map<String,Object> map : list) {
//			map.get("BOARD_NO")
			System.out.println(i+"\t"+map.get("BOARD_NAME")+"\t"+map.get("REGDATE"));
			i++;
		} System.out.println("──────────────────────────────────────────────");
		println();
		System.out.println("┌───────────────────────┐");
		System.out.println("│1. 게시판 상세 조회                 │");     
		System.out.println("│2. 홈                                     │");
		System.out.println("└───────────────────────┘");
		int sel = ScanUtil.menu();
		
		if(sel == 1) {
			return View.FREEBOARD_DETAIL;
		}
		else if (sel == 2) return View.FREEBOARD_HOME;
		else return View.FREEBOARD_LIST;
   }

   private View login() {
	   
	   System.out.println           ("─────LOGIN──────");
	   String id = ScanUtil.nextLine("ID :");
	   String pw = ScanUtil.nextLine("PASS :");
	   System.out.println           ("────────────────");

	   List<Object> param = new ArrayList();
	   param.add(id);
	   param.add(pw);
	   
		boolean loginChk = memberService.login(param);
		if(!loginChk) {
			System.out.println		  ("┌────────────────┐");
			System.out.println		  ("│1. 재로그인              │");
			System.out.println		  ("│2. 회원가입              │");
			System.out.println		  ("└────────────────┘");
			int sel = ScanUtil.nextInt("메뉴선택:");
			if(sel == 1) return View.LOGIN;
			else if(sel == 2) return View.MEMBER_SIGN;
			else return View.LOGIN;
		}
		
		sessionStorage.get("아이디");
		return View.FLIGHT_HOME;
}

   private View update() {
	   System.out.println("┌───────회원정보변경────────┐");
	   System.out.println("│       ID,PW재확인               │");
	   System.out.println("└────────────────────────┘");   
	   String id = ScanUtil.nextLine("ID >>");
	      String pw = ScanUtil.nextLine("PASS >>");
	      if(id.equals(sessionStorage.get("CUS_ID")) && pw.equals(sessionStorage.get("CUS_PW"))) {
	         
	      } else {
	          System.out.println("Access_Denied");
	          return View.MEMBER_UPDATE;
	      }
	   List<Object> param = new ArrayList();
	   String no = (String)sessionStorage.get("CUS_NO");
	   param.add(no);
	   
		// 아이디 비밀번호 이름 여권번호 전화번호 주소
		List<Object> param2 = new ArrayList();
		String id2 = ScanUtil.nextLine("새로운 아이디를 입력해주세요 : ");
		String pw2 = ScanUtil.nextLine("새로운 비밀번호를 입력해주세요 : ");
		String name = ScanUtil.nextLine("성함을 입력해주세요 : ");
		String pass = ScanUtil.nextLine("여권번호를 입력해주세요 : ");
		String telno = ScanUtil.nextLine("전화번호를 입력해주세요 : ");
		String address = ScanUtil.nextLine("주소를 입력해주세요 : ");
		
		param2.add(id2);
		param2.add(pw2);
		param2.add(name);
		param2.add(pass);
		param2.add(telno);
		param2.add(address);
		
		param2.add(no);
		
		memberService.update(param2);
		
		System.out.println("회원정보 수정이 완료되었습니다.");
		sessionStorage.put("id",id2);
		
		return View.MEMBER;		
   }

   private View infor() {
	return null;
	}

   private View member() {
	   System.out.println("───────────회원정보확인───────────");
	   List<Object> param = new ArrayList();
	   String id = (String) sessionStorage.get("CUS_NO");
	   param.add(id);
	   Map<String,Object> member = memberService.member(param);
		System.out.println(member);
	   
	   return View.ADMIN;
   }

   private View resList() {
	   System.out.println("┌───────회원정보변경────────┐");
	   System.out.println("│ID,PW재확인                             │");
	   System.out.println("└────────────────────────┘");  
	   String id = ScanUtil.nextLine("ID >>");
	   String pw = ScanUtil.nextLine("PASS >>");
	   if(id.equals(sessionStorage.get("CUS_ID")) && pw.equals(sessionStorage.get("CUS_PW"))) {
			
	   } else {
			 System.out.println("Access_Denied");
			 return View.RES_LIST;
	   }
	   
	   List<Object> resParam = new ArrayList();
	   resParam.add(id);
	   resParam.add(pw);
	    
		 List<Map<String, Object>> resList = flightService.resList(resParam);
		 System.out.println("────────────────────────────────────────────항공편 목록────────────────────────────────────────────");
		 int i=1;
		 System.out.println("번호             출발지                                     출발 시간                        도착지                              도착 시간                           좌석");
		    for(Map<String,Object> reservation : resList) {  
		    	System.out.print(" "+i+"\t");
		        System.out.print(reservation.get("SCHE_DEPART")+"\t");
		        System.out.print(reservation.get("SCHE_DEPARTTIME")+"\t");
		        System.out.print(reservation.get("SCHE_ARRIVE")+"\t");
		        System.out.print(reservation.get("SCHE_ARRIVETIME")+"\t");
		        String seat = (String) reservation.get("SEAT_NO");
		        System.out.println(seat.substring(0, 4)+"-"+seat.substring(4, 8));
		        reservation.get("TICKET_NO"); // TICKET_NO 저장
		        i++;    
		    }
		    System.out.println("────────────────────────────────────────────────────────────────────────────────────────────────");
	System.out.println("1. 홈");
	System.out.println("2. 예약 취소");	    
	int sel = ScanUtil.nextInt("메뉴선택 : ");
    
	if (sel == 1) {
        return View.FLIGHT_HOME;
    } else if (sel == 2) {
        int flightNum = ScanUtil.nextInt("지울 개체 선택 (번호 입력) : ");
        if (flightNum > 0 && flightNum <= resList.size()) {
            String ticketNo = (String) resList.get(flightNum - 1).get("TICKET_NO");
            if (ticketNo != null) {
                System.out.println("선택한 티켓 번호: " + ticketNo);
                // ticketNo를 반환
                List<Object> removeParam = new ArrayList<>();
                removeParam.add(id);
                removeParam.add(pw);
                removeParam.add(ticketNo);
                flightService.remove(removeParam);

                System.out.println("항공편이 취소되었습니다.");
                return View.FLIGHT_HOME;
            } else {
                System.out.println("티켓 번호가 유효하지 않습니다.");
                return View.RES_LIST;
            }
        } else {
            System.out.println("유효하지 않은 선택입니다.");
            return View.RES_LIST;
        }
    } else {
        return View.RES_LIST;
    }
   }

   


   private View reservation() {
	    System.out.println("──────항공편 예약──────");   

	    String depart = getDepart();
	    String arrive = getArrive();
	    int ticketPrice = tiekckPrice(depart, arrive);

	    // 출발지와 도착지를 파라미터로 넘겨 항공편 목록을 조회
	    List<Object> param = new ArrayList<>();
	    param.add(depart);
	    param.add(arrive);
	    
	    List<Map<String, Object>> flightList = flightService.list(param);
	    
	    // 조회된 항공편 목록 출력
	    System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────");
	    System.out.println("번호\t출발지\t\t출발 시간\t\t도착지\t\t도착 시간\t\t항공편 운항 기체");
	    int i = 1;
	    for (Map<String, Object> flight : flightList) {
	        System.out.print(i + "\t");
	        System.out.print(flight.get("SCHE_DEPART") + "\t" + flight.get("SCHE_DEPARTTIME") + "\t");
	        System.out.print(flight.get("SCHE_ARRIVE") + "\t" + flight.get("SCHE_ARRIVETIME") + "\t");
	        System.out.println(flight.get("PLANE_NAME"));    
	        i++;
	    }
	    System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────");
	    
	    // 예약할 항공편 선택
	    String cusNo = (String) sessionStorage.get("CUS_NO");
	    
	    int choice = ScanUtil.nextInt("예약할 번호를 입력하세요: ");
	    
	    // 선택된 항공편의 SCHE_NO 얻기
	    if (choice > 0 && choice <= flightList.size()) {
	        BigDecimal scheNoBigDecimal = (BigDecimal) flightList.get(choice - 1).get("SCHE_NO");
	        int scheNo = scheNoBigDecimal.intValue();

	        SeatTableControl.runSeatTableControl();
	        String seatNO4 = ScanUtil.nextLine("예약할 좌석을 입력해주세요. (예 : 003F, 009A) : ");  // 4자리. 001A ~ 009F
	        String planeName = (String) flightList.get(choice - 1).get("PLANE_NAME");
	        String seatNo = seatNO4 + planeName;

	        // 티켓 저장 난수생성
	        String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	        int charsetLength = charset.length();
	        Random random = new Random();
	        StringBuilder randomString = new StringBuilder();
	        // 6자리의 난수 생성
	        for (int j = 0; j < 6; j++) {
	            randomString.append(charset.charAt(random.nextInt(charsetLength)));
	        }
	        String ticket = randomString.toString();
	        
	        // 티켓 정보 저장을 위한 파라미터 설정   
	        List<Object> ticketingParam = new ArrayList<>();
	        ticketingParam.add(ticket);
	        ticketingParam.add(ticketPrice);
	        ticketingParam.add(scheNo);
	        ticketingParam.add(cusNo);
	        flightService.ticketing(ticketingParam);
	        
	        // 예약 정보 저장을 위한 파라미터 설정
	        List<Object> reservationParams = new ArrayList<>();
	        reservationParams.add(resID());
	        reservationParams.add(scheNo); 
	        reservationParams.add(cusNo);
	        reservationParams.add(ticket);
	        reservationParams.add(seatNo);
	        flightService.reserve(reservationParams);
	        
	        // FlightService를 통해 예약 정보 저장
	        System.out.println("예약이 완료되었습니다."); // 예외처리 필요
	        
	        return View.FLIGHT_HOME; // 예약 완료 후 홈 화면으로 이동
	    } else {
	        System.out.println("유효하지 않은 선택입니다.");
	        return View.FLIGHT_LIST; // 유효하지 않은 선택인 경우 다시 항공편 목록 화면으로 이동
	    }
	}



	


	private View list() {
		System.out.println("──────항공편 조회──────");   	  
		String depart = getDepart();
		System.out.println("────────────────────");
		String arrive = getArrive();
		
		List<Object> param = new ArrayList();
		param.add(depart);
		param.add(arrive);
		
		List<Map<String,Object>> list = flightService.list(param);
		System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────");
		System.out.println("번호"+"              출발지"+"\t"+"                           출발 시간"+"\t"+"                도착지"+"\t"+"                         도착 시간"+"\t"+"          항공편 운항 기체");
	    int i = 1;
		for(Map<String,Object> flight : list) {
	    	System.out.print(i+"\t");
	    	System.out.print(flight.get("SCHE_DEPART")+"\t"+flight.get("SCHE_DEPARTTIME")+"\t");
	    	System.out.print(flight.get("SCHE_ARRIVE")+"\t"+flight.get("SCHE_ARRIVETIME")+"\t");
	        System.out.println(flight.get("PLANE_NAME"));    
	        i++;
	    } System.out.println("─────────────────────────────────────────────────────────────────────────────────────────────────");
		
		System.out.println("1. 항공편 예약");
		System.out.println("2. 홈");
		int sel = ScanUtil.nextInt(""); 
		if(sel == 1) return View.FLIGHT_RESERVATION;
	    else if(sel == 2) return View.FLIGHT_HOME;
	    else return View.FLIGHT_LIST;
	
	}

	private View admin() {
		String id = (String) sessionStorage.get("CUS_ID");
//		String pw = (String) sessionStorage.get("CUS_PW");
		 if(id.contains("admin")) {
	         System.out.println("┌───────관리자페이지────────┐");
	         System.out.println("│1. 회원 정보 확인                      │");
	         System.out.println("│2. 회원 정보 찾기                      │");
	         System.out.println("│3. 회원 정보 수정                      │");
	         System.out.println("└────────────────────────┘");
	         
	         int sel = ScanUtil.nextInt("메뉴 선택 : ");
	         if(sel == 1) return View.MEMBER;
	         else if(sel == 2) return View.MEMBER_INFOR;
	         else if(sel == 3) return View.MEMBER_UPDATE;
	         
	      } else {
	          System.out.println("Access_Denied(Not admin)");
	          return View.MEMBER;
	      }
		 System.out.println  ("┌───────회원정보확인────────┐");
		   System.out.println("│1. 로그인                                 │");
		   System.out.println("│2. 정보 찾기                             │");
		   System.out.println("│3. 정보 수정                             │");
		   System.out.println("└────────────────────────┘");  
		  

	      int sel = ScanUtil.nextInt("메뉴선택 : ");
	      System.out.println();
	      if(sel == 1) return View.LOGIN;
	      else if(sel == 2) return View.MEMBER;
	      else if(sel == 3) return View.MEMBER_INFOR;
	      else if(sel == 4) return View.MEMBER_UPDATE;
      
	      else return View.ADMIN;
	}

	private View flight_home() {
	  homeVar();
      int sel = ScanUtil.nextInt("메뉴선택 : ");
      
      System.out.println();
      if(sel == 1) return View.ADMIN;
      else if(sel == 2) return View.FLIGHT_LIST;
      else if(sel == 3) return View.FLIGHT_RESERVATION;
      else if(sel == 4) return View.RES_LIST;
      else if(sel == 5) return View.FREEBOARD_HOME;
      else if(sel == 6) return View.LOGIN;
      else return View.HOME;
    }
	
	
	
	
	
	private View resRemove() {
		 System.out.println("──────항공편 조회──────");  	 
		 String id = (String) sessionStorage.get("CUS_ID");
		 String pw = (String) sessionStorage.get("CUS_PW");
		 List<Object> resParam = new ArrayList();
		 resParam.add(id);
		 resParam.add(pw);	
		
		 List<Map<String, Object>> resList = flightService.resList(resParam);
		 System.out.println("──────항공편 목록──────");
		 int i = 1;   
		 for(Map<String,Object> reservation : resList) {  
		    	System.out.println("번호 : "+i);
		        System.out.println("출발지: " + reservation.get("SCHE_DEPART"));
		        System.out.println("도착지: " + reservation.get("SCHE_DEPARTTIME"));
		        System.out.println("출발 시간: " + reservation.get("SCHE_ARRIVE"));
		        System.out.println("도착 시간: " + reservation.get("SCHE_ARRIVETIME"));
		        System.out.println("좌석: " + reservation.get("SEAT_NO"));
		        System.out.println("=====================");
		        i++;
		    }
		    int flightNum = ScanUtil.nextInt("지울 개체 선택 : ");
		    String scheNo = (String)resList.get(flightNum).get("SCHE_NO"); //왜 에러인지는 알겠는데... 나중에 하자
		    System.out.println(scheNo);
//		    List<Object> removeParam = new ArrayList<>();
//		    removeParam.add(scheNo);
//		    flightService.remove(removeParam);

		    return View.FLIGHT_REMOVE;
		}
}

//dao는 디비에 접속기능
//컨트롤러 - 서비스 - 다오 연결
//
// 