package kr.or.ddit.homework;

import java.util.Random;
import java.util.Scanner;

public class StageA_16 extends Stage_16{
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void game() {
		// TODO Auto-generated method stub
		Random random=new Random();
		int com=random.nextInt(2);
		System.out.print("0(짝수),1(홀수)중 하나를 입력하세요: ");
		int hum=sc.nextInt();
		if(com==hum) {
			System.out.println("승리하셧습니다.");
			Homework16.money+=4000;
		}
		else {
			System.out.println("패배하였습니다.");
		}
	}
	
	@Override
	public void gameMoney() {
		Homework16.money-=2000;
	}
}
