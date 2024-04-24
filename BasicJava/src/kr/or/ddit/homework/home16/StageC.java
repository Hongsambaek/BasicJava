package kr.or.ddit.homework.home16;

import java.util.Random;
import java.util.Scanner;

public class StageC extends Stage{
	@Override
	public void game() {
		Scanner sc = new Scanner(System.in);
		// TODO Auto-generated method stub
		Random random = new Random();
		int com = random.nextInt(6);
		System.out.println("주사위를 입력하시오(1~6)");
		int hum = sc.nextInt();
		System.out.println("휴먼"+hum+"컴퓨터"+hum);
		if(com==hum) {
			System.out.println("승리하셨습니다.");
			Homework16.money+=10000;
		}
		else {
			System.out.println("패배하였습니다.");
		}
		
		
		
		
	}
	
	@Override
	public void gameMoney() {
		// TODO Auto-generated method stub
		Homework16.money-=10000;
		
	}
}
