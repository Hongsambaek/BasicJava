package kr.or.ddit.homework.home16;

import java.util.Scanner;

public class StageB extends Stage{
	Scanner sc = new Scanner(System.in);
	@Override
	public void game() {
		// TODO Auto-generated method stub
		System.out.println("죽음의 가위바위보 게임을 시작하지");
		System.out.println("가위, 바위, 보!");
		
			// 0 → 가위
			// 1 → 바위
			// 2 → 보
			
			// 컴퓨터가 랜덤으로 내는 가위 바위 보
			// 내가 입력한 가위 바위 보를 비교해서 승패를 출력하시오.
			// if 문 사용
			// ex) 컴퓨터 : 가위, 사람: 보 → 결과:졌다/이겼다/비겼다.
			
			System.out.println("0(가위), 1(바위), 2(보)를 입력하세요. ");
			int hum = sc.nextInt();
			// Human
				if (hum==0) {
				System.out.println("Hum : 가위");
			}
			
				if (hum==1) {
				System.out.println("Hum : 바위");
			}
			
				if (hum==2) {
				System.out.println("Hum : 보");
			}
			//Computer
			int com=(int)(Math.random()*3);
				
				if (com==0) {
					System.out.println("Com : 가위");
				}
				
				if (com==1) {
					System.out.println("Com : 바위");
				}
				
				if (com==2) {
					System.out.println("Com : 보");
				}
			//결과
			if(com==0) {
				if(hum==0) {
					System.out.println("Draw");
				}
				
				if(hum==1) {
					System.out.println("Lose");
					
				if(hum==2)	{
					System.out.println("Win");
					Homework16.money+=10000;
				}
				}
			}
			
			if(com==1) {
				if(hum==0) {
					System.out.println("Lose");
				}
				
				if(hum==1) {
					System.out.println("Draw");
				}
				
				if(hum==2) {
					System.out.println("Win");
					Homework16.money+=10000;
				}
			}
			
			if(com==2) {
				if(hum==0) {
					System.out.println("Win");
					Homework16.money+=10000;
				}
				
				if(hum==1) {
					System.out.println("Lose");
				}
				
				if(hum==2) {
					System.out.println("Draw");
				}
			}
		}
	
	

	
	
	@Override
	public void gameMoney() {
		// TODO Auto-generated method stub
		Homework16.money-=6000;
		
			
		}
		

	}

