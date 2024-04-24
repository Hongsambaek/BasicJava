package kr.or.ddit.Practice;

import java.util.Scanner;

public class practiceMan {
	static Scanner sc = new Scanner(System.in);
	Mem[] memList = new Mem[100];
	int cnt =0;
	public static void main(String[] args) {
		practiceMan h14 = new practiceMan();
		while(true) {
			System.out.println("1. 회원 가입.");
//			System.out.println("2. 회원 탈퇴.");
			System.out.println("3. 정보 수정.");
			System.out.println("4. 회원 전체 정보 출력.");
			int sel = sc.nextInt();
			if(sel==1) {
				h14.addMember();
			}
			if(sel==3) {
				h14.updateMember();
			}
			if(sel==4) {
				h14.printMemberList();
			}
		}
	}
	
	public void addMember() {
		Mem m1 = new Mem();
		System.out.println("아이디를 입력하시오.");
		String id = sc.next();
		System.out.println("PW를 입력하시오.");
		String pass = sc.next();
		System.out.println("이름을 입력하시오.");
		String name = sc.next();
		System.out.println("나이를 입력하시오.");
		int age = sc.nextInt();
				
		m1.setId(id);
		m1.setPass(pass);
		m1.setName(name);
		m1.setAge(age);
		
		memList[cnt] = m1;
		cnt++;
		
	}
	
	
	/*
	 *   회원 전체 정보 출력하기.
	 */
	public void printMemberList() {
		for (int i=0; i<cnt; i++) {
			Mem mem = memList[i];
			System.out.println("아이디\t패스워드\t이름\t나이");
			
			System.out.println(mem.getId()+"\t"+mem.getPass()+"\t"+mem.getName()+"\t"+mem.getAge());
			
		}
	}
	
	/*
	 *   회원 정보 수정하기.
	 */
	
	public void updateMember() {
		/*
		 *  회원 전체 정보 출력하기.
		 */
		printMemberList();
		/*
		 *  정보 수정.
		 */
		
		System.out.print("수정할 회원 번호 입력.");
		int num = sc.nextInt();
		Mem mem = memList[num];
		
		
		System.out.println("수정할 ID를 입력하시오.");
		String id = sc.next();
		
		System.out.println("수정할 PW를 입력하시오.");
		String pass = sc.next();
		
		System.out.println("수정할 이름을 입력하시오.");
		String name = sc.next();
		
		System.out.println("수정할 나이를 입력하시오.");
		int age = sc.nextInt();
		
		mem.setId(id);
		mem.setPass(pass);
		mem.setName(name);
		mem.setAge(age);
		
	}
	
}
class Mem{
	private String id;
	private String pass;
	private String name;
	private int age;

	
	/* 
	 * 생성자 사용x
	 * getter setter 이용할것.  
	 */
	
	
	@Override
	public String toString() {
		return "Mem [id=" + id + ", pass=" + pass + ", name=" + name + ", age=" + age + "]";
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}
	
	
}
