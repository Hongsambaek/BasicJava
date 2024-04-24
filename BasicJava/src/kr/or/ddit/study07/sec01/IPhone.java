package kr.or.ddit.study07.sec01;

public class IPhone extends SmartPhone{
	public void apstore() {
		System.out.println("앱스토어");
	}
	
	@Override
	public void camera() {
//		// TODO Auto-generated method stub
		System.out.println("1000만 화소 카메라");
		super.camera();
	}
	
	@Override
	public void tell() {
		// TODO Auto-generated method stub
		System.out.println("1000분 통화가능");
		super.tell();
	}	
	
	
	//IPhone2 클래스 만들고 IPhone 상속받기
	
	// camera 2000만 화소로 업그레이드하기
	
}
