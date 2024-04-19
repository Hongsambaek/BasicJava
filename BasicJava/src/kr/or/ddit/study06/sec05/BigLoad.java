package kr.or.ddit.study06.sec05;

public class BigLoad {
	private static BigLoad instance;

	private BigLoad() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
	}

	public static BigLoad getInstance() {
		if (instance == null) {
			instance = new BigLoad();
		}
		return instance;
	}

}


//%1명만 예약 가능한 가게의 예약 시스템
//샵 오픈 했으면 처음엔 손님이 x  -> 완
//예약이 들어오면 예약 등록
//누가 예약을 하면 손님을 못받아    
//그리고 예약이 끝나고 처리 해야 다시 손님 받을 수 있음	