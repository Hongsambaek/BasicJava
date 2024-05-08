/* 단어 맞추기 게임
 *  5개의 단어를 배열에 저장한 후 임의의 한 단어를 선택
 *  선택된 단어의 철자를 섞어 사용자에게 제시하면,
 *  사용자는 해당 철자를 보고 단어를 입력한다.
 *  사용자가 정확한 단어를 맞출때까지 반복하며 맞추면 "You Correct!!" 문자열과 시도횟루를
 *  출력하고 프로그램을 종료
 */
package kr.or.ddit.보강;


import java.util.*;

public class 보강4 {
	
	public static void main(String[] args) {
		Scramble s = new Scramble();
		String w1 = s.SelectWord();
		String question = s.shuffle(w1);
		
		
		s.checkSpelling(w1, question);
		
		//String 배열 : 객체 배열
	}
}


class Scramble {
	String[] word = {"hope", "love", "apple", "banana", "persimmon"};
	Random random = new Random();
	
	public String SelectWord() {
		
		int idx = random.nextInt(5);
		
		return word[idx]; 
	}
	
	public String shuffle(String w1) {
		char[] tar = new char[w1.length()];
		for(int i = 0; i<tar.length; i++) {
			tar[i] = w1.charAt(i);
		}
		
		char[] tar1 = w1.toCharArray();
		
		//문자 섞기
		for(int i = 0; i<10000; i++) {
			int idx = random.nextInt(tar1.length);
			char temp = tar1[0];
			tar[0] = tar1[idx];
			tar1[idx] = temp;
		}
		
		//문자배열을 문자열로 변환 -> 문자열클래스의 생성자 메소드 사용
		return new String(tar1);
	}
	
	public void checkSpelling(String w1, String question) {
		System.out.println("제시어 : "+question);
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while(true) {
			count++;
			
			System.out.println("정답입력 : ");
			String answer = sc.nextLine();
			
			if(w1.equalsIgnoreCase(answer)) {
				System.out.println("==========================");
				System.out.println("You Correct!!");
				System.out.println("시도 횟수: "+count);
				break;
			}else {
				System.out.println("==========================");
				System.out.println("정답이 아닙니다.");
			}
		}
		System.out.println("프로그램을 종료합니다...");
	}
	
}
