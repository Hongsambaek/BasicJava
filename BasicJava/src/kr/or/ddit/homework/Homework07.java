package kr.or.ddit.homework;

import java.util.Random;
import java.util.Scanner;

public class Homework07 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Homework07 obj = new Homework07();
		obj.process();
	}

	public void process() {
		method1();

		//ctrl+shift+o 눌러서 불러오기
	}
	
	public void method1() {
		/*
		 *   6개의 단어가 제공되며 
		 *   이중 임의의 단어가 선택된다. 
		 *   
		 *   사용자는 이를 보고 원래의 단어를 입력한다. 
		 *   사용자가 단어를 맞출때까지 반복하며 단어를 맞추었을때 시도 횟수 출력
		 */	
		String[] words = 
			  { "deserve", "cart", "he", "jet", "fright", "frustrate", "blossom", "scrub", "choir", "amount",
				"mechanism", "long", "chip", "blink", "too", "chop", "pave", "flavor", "habitat", "neither",
				"slip", "paragraph", "apply", "pad", "role", "from", "peak", "happen", "blonde", "organ",
				"format", "assess", "laugh", "manipulat", "meat", "column", "jar", "undergo", "fan", "through",
				"tend", "consensus", "quit", "oblige", "mood", "resort", "knight", "hat", "broad", "theater",
				"versus", "against", "via", "quarter", "hundred", "decade", "teenage", "billion", "dozen",
				"century", "dose", "double", "may", "the", "could", "should", "would", "dare", "shall", "can",
				"ought", "bit", "whereas", "criteria", "protein", "notion", "without" };
		
		int ran = new Random().nextInt(words.length);
		
		String select = words[ran];
		
		/*
		 *  String -> char 배열로 바꿔줌
		 *  toCharArray
		 */
		//decade => 'd', 'e', 'c' , 'a', 'd', 'e' 
		
		char[] ch = select.toCharArray();
		/*
		 *  문자 섞기 
		 *  'd', 'e', 'c' , 'a', 'd', 'e' 
		 *  ran2 => 3
		 *  |'a'|, 'e', 'c' , |'d'|, 'd', 'e' 
		 */
		
		
		for(int i=0; i< 10000000; i++) {
			int ran2 = new Random().nextInt(ch.length);
			//0번 째 배열의 값과 ran 2번째 배열의 값을 바꾸기
			char a = ch[0];
			ch[0] = ch[ran2];
			ch[ran2] = a;
		}
		
		String a = String.valueOf(ch);
		int cnt = 0;
		System.out.println("섞인 단어 : "+a);
		while(true) {
			/*
			 *   ch 배열 출력하기 
			 *   정답 : abort
			 *   섞인 단어 : bator
			 */
			System.out.println("입력 : ");
			String answer = sc.next();
			cnt++;
			if(answer.equals(select)) {
				break;
			}
			else
				System.out.println("아닙니다.");
		}
		System.out.println(cnt + "회 시행되었습니다.");
		System.out.println("정답입니다.");
		
	}
}