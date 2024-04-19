package kr.or.ddit.homework;

import java.util.Random;
import java.util.Scanner;

public class Homework11 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Homework11 obj = new Homework11();
		obj.process();
	}

	public void process() {
		Deck deck1 = new Deck();
		deck1.suffle();
//		deck1.printCardList();
		
		// 내 카드랑 랜덤 카드랑 비교해서 
		// 숫자가 높다면 이김
		
		// 내 카드 = 0번째
		Card myCard = deck1.getCard(0);
		// 컴퓨터 카드 랜덤 카드
		Random random = new Random();
		Card ComCard = deck1.getCard(random.nextInt(52)+1);
		print(myCard, ComCard);
	}
	public void print(Card my, Card com) {
		// 결과값 출력
		// 내카드 스페이드A 컴퓨터 다이아5
		// 같으면 lose
		// 결과 : lose;
		System.out.println();
		System.out.println("내 카드 : "+my);
		System.out.println("컴퓨터 카드 : "+com);
		if (my.num < com.num) {
			System.out.println("lose");
		}else if(my.num > com.num) {
			System.out.println("win");
		}else if(my.num == com.num ) {
			System.out.println("draw");
		}
	}
	
}
class Card {
	String type;
	int num;
	
	// 생성자 type, num 입력 할것.
	public Card(String type, int num) {
		this.type = type;
		this.num = num;
	}
	@Override
	public String toString() {
		// type ♤ ♡♧◇
		// num 1~13
		// 1 > A 로 출력
		// 11 > j , 12 > Q , 13 > K 로 출력
		String result = type+num;
		if(num == 1) result = type+"A";
		if(num == 11) result = type+"J";
		if(num == 12) result = type+"Q";
		if(num == 13) result = type+"K";
		return result;
	}
}

class Deck{
	Card[] cardList;
	
	public Deck() {
		cardList = new Card[52];
		String[] type = {"♤ ","♡","♧","◇"};
		int cnt = 0;
		for(String t : type) {
			for (int i=1; i<=13; i++) {
				cardList[cnt++] = new Card(t,i);
			}
		}
	}
	
	public void suffle() {
		// 카드 섞기for
		for (int i=0; i< 1000; i++) {
			int ran = new Random().nextInt(cardList.length);
			Card temp = cardList[0]; 
			cardList[0] = cardList[ran];
			cardList[ran] = temp;
		}
	}
	
	public void printCardList() {
		for(int i=0; i<cardList.length; i++) {
			System.out.print(cardList[i]+",");
			if ((i+1)%10 == 0 && i!=0) {
				System.out.println();
			}
		}
	}
	public Card getCard(int ran) {
		return cardList[ran];
	}
	
}