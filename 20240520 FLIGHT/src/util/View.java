package util;

public enum View {
   MAIN,
   HOME,				//홈
   ADMIN,               //회원관리      
   LOGIN, MEMBER, MEMBER_INFOR, MEMBER_UPDATE, MEMBER_SIGN,	MEMBER_REMOVE,
   
  
	CUSINFO_CUSTOMER,			// 회원
	CUSINFO_SIGN,				// 회원가입
	CUSINFO_REMOVE, 			// 탈퇴
	
   FLIGHT_HOME,			//항공편 홈
   FLIGHT_LIST,			//조회
   FLIGHT_RESERVATION,  //예약
   FLIGHT_REMOVE,		//취소
   RES_LIST , 			//예매조회
   
   FREEBOARD_HOME,				// 홈	
   FREEBOARD_LIST,				// 게시판 출력
   FREEBOARD_DETAIL,			// 게시판 상세
   FREEBOARD_UPDATE,			// 게시판 수정
   FREEBOARD_DELETE,           // 게시판 삭제
   FREEBOARD_INSERT, 			// 게시판 인서트
   
}