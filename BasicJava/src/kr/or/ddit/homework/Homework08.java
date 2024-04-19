package kr.or.ddit.homework;

import java.util.Scanner;

public class Homework08 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Homework08 obj = new Homework08();
		obj.process();
	}

	public void process() {
		
		String[] stuName = {"나연","정연","채영","다연","미나"};
		// 국 영 수 총점 평균 등수
		int[][]score = 
		{	
			{80, 70, 80, 0, 0, 1},		
			{90, 90, 80, 0, 0, 1},
			{80, 70, 60, 0, 0, 1},
			{65, 75, 85, 0, 0, 1},
			{76, 80, 86, 0, 0, 1}
		};
		
		// 1. 총점/평균 계산

		for(int i = 0; i<score.length; i++) {
		score[i][3] = score[i][0] + score[i][1] + score[i][2];
		score[i][4] = score[i][3]/3;		
		}
		
		
		// 2. 등수 구하기
		for(int i = 0; i<score.length; i++) {
			for(int j = 0; j<score.length; j++) {
				if(score[i][3]<score[j][3]) {
					score[i][5]++;
				}
			}
		}
		
		// 3. 출력
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등수");
	      System.out.println("===================================================");
	      for(int i = 0; i < score.length; i++) {
	         System.out.print(stuName[i]+" : \t");
	         for(int j = 0; j < score[i].length; j++) {
	            System.out.print(score[i][j]+"\t");
	         }
	         System.out.println();
	      }
		// 4. 정렬 후 출력 하기
		
		int[] num = new int[6];
		String n;
		for(int i = 0; i<score.length; i++) {
			for(int j = 0; j<score.length-1; j++) {
				if(score[j][3] < score[j+1][3]) {
					int[] temp = score [j];
					score[j] = score[j+1];
					score[j+1] = temp;
					
					String tempS = stuName[j];
					stuName[j] = stuName[j+1];
					stuName[j+1] = tempS;
				}
			}
		}		
				
	      System.out.println("===================================================");
	      for(int i = 0; i < score.length; i++) {
	         System.out.print(stuName[i]+" : \t");
	         for(int j = 0; j < score[i].length; j++) {
	            System.out.print(score[i][j]+"\t");
	         }
	         System.out.println();
		}
		
		
		
	}
		
		
	}

