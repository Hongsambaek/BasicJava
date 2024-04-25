package kr.or.ddit.homework;

import java.util.Scanner;

public class Homework17 {
	Scanner sc = new Scanner(System.in);
	int cnt = 0;
	Member[] memList = new Member[100];

	public static void main(String[] args) {
		Homework17 obj = new Homework17();
		obj.process();
	}

	public void process() {
		while (true) {
			System.out.println("1. 회원 가입.");
			System.out.println("2. 회원 탈퇴.");
			System.out.println("3. 정보 수정.");
			System.out.println("4. 회원 전체 정보 출력.");
			int sel = sc.nextInt();
			if (sel == 1) {
				addMember();
			}
			if (sel == 2) {
				removeMember();
			}
			if (sel == 3) {
				updateMember();
			}
			if (sel == 4) {
				printMemberList();
			}
		}
	}

	public void addMember() {
		Member mem = new Member();
		String id, pass, name, nickName;
		int age;
		// id 입력시 4~8자 입력 받을것.
		System.out.println("ID를 4~8자로 입력하시오.");

		while (true) {
			id = sc.next();
			try {
				idCheck(id);
				mem.setId(id);
				break;
			} catch (Exception e) {
				System.out.println("요구조건에 맞지않습니다.");
				e.printStackTrace();
			}
		}
		// pass 입력시 4~ 8자 입력

		while (true) {
			System.out.println("PassWord를 입력하시오.");
			pass = sc.next();
			try {
				passCheck(pass);
				mem.setPass(pass);
				break;
			} catch (Exception e) {
				System.out.println("PassWord 다시입력하쇼");
			}
		}
		// name 입력시 2~5자 입력

		while (true) {
			System.out.println("이름을 입력하시오.");
			name = sc.next();
			try {
				nameCheck(name);
				mem.setName(name);
				break;
			} catch (Exception e) {
				System.out.println("이름을 2~5자로 입력하시오.");
			}
		}
		// nickName 입력시 욕설등 금지어 체크

		while (true) {
			System.out.println("닉네임을 입력하시오.");
			nickName = sc.next();
			try {
				nickNameCheck(nickName);
				mem.setNickName(nickName);
				break;
			} catch (Exception e) {
				System.out.println("닉네임을 2~5자내로 입력하시오.");
			}
		}
		// age 숫자 입력 체크
		while (true) {
			System.out.println("나이를 입력하시오.");
			age = sc.nextInt();
			try {
				ageCheck(age);
				mem.setAge(age);
				break;
			} catch (Exception e) {

			}
		}
		memList[cnt++] = mem;
	}
	
	
	public void idCheck(String id) throws Exception {
		if (id.length() < 4 || id.length() > 8) {
			throw new Exception();
		}

	}

	public void passCheck(String pass) throws Exception {
		if (pass.length() < 4 || pass.length() > 8) {
			throw new Exception();
		}
	}

	public void nameCheck(String name) throws Exception {
		if (name.length() < 2 || name.length() > 5) {
			throw new Exception();
		}
	}

	public void nickNameCheck(String nickName) throws Exception {
		if (nickName.length() < 2 || nickName.length() > 5) {
			throw new Exception();
		}
		else if(nickName.contains("야발")){
			throw new Exception();
		}
	}

	

	public void ageCheck(int age) throws Exception {
		if (age < 0) {
			throw new Exception();
		}
	}

	public void removeMember() {
		Member[] temp = new Member[100];
		printMemberList();
		System.out.println("삭제할 회원 번호를 입력하세요.");
		int num = sc.nextInt();
		int add = 0;
		for (int i = 0; i < cnt; i++) {
			if (i == num)
				add++;
			temp[i] = memList[i + add];
		}
		memList = temp;
		cnt--;
		printMemberList();
	}

	public void updateMember() {
		/*
		 * 회원 전체 정보 출력하기.
		 */
		printMemberList();

		System.out.print("수정할 회원 번호 입력.");
		int num = sc.nextInt();
		Member mem = memList[num];
		/*
		 * 정보 수정.
		 */

		System.out.println("수정할 ID를 입력하세요");
		String id = sc.next();

		System.out.println("수정할 PW를 입력하세요");
		String pass = sc.next();

		System.out.println("수정할 이름을 입력하세요");
		String name = sc.next();

		System.out.println("수정할 나이를 입력하세요");
		int age = sc.nextInt();

		System.out.println("수정할 닉네임을 입력하세요.");
		String nickName = sc.next();

		mem.setId(id);
		mem.setPass(pass);
		mem.setName(name);
		mem.setAge(age);
		mem.setNickName(nickName);
	}

	public void printMemberList() {
		for (int i = 0; i < cnt; i++) {
			Member mem = memList[i];
			System.out.println("아이디\t비밀번호\t이름\t나이\t닉네임");

			System.out.println(mem.getId() + "\t" + mem.getPass() + "\t" + mem.getName() + "\t" + mem.getAge() + "\t"
					+ mem.getNickName() + "\t");
		}
	}

}

class Member {
	private String id;
	private String pass;
	private String name;
	private String nickName;
	private int age;

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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
