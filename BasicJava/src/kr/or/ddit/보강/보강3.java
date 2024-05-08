//package kr.or.ddit.보강;
//
//public class 보강3 {
//	int[] d = new int[6]; //멤버 필드
//	
//	char[][] histo;
//	Dice() {
//		for(int i = 0; i<50; i++) {
//			int r = (int)(Math.random()*6+1); //1~6 사이의 난수 (주사위 눈)
//			d[r-1]++; //순서는 0쿠터 0은 1의눈 1은 2의눈.....
//		}
//	}
//	//1차원배열의 d의 값을 이용하여 2차원배열 선언(행은 d배열의 최대값, 열은 6으로 고정)
//	void createTwoDimension() {
//		int rowCount = 0;
//		rowCount = d[0];
//		for(int i = 1; i<d.length; i++) {
//			if(rowCount<d[i]) {
//				rowCount = d[i];		 
//			}
//		}
//		
//		char[][] histo = new char[rowCount][6];
//	}
//	
//	// '*'(아스키코드)@histo배열에 삽입
//	void insertChar() {
//		for(int i = 0; i<6; i++) {
//			for(int j = 0; j<d[i]; j++){
//				histo[j][i] = '*';
//			}
//		}
//	}
//	
//	public void displayHisto(){
//	      for( int i=histo.length-1; i>=0; i--  ) {
//	         for(int j=0;  j<histo[i].length; j++) {
//	            System.out.printf("%5c", histo[i][j]);
//	         }
//	         System.out.println();
//	      }
//	      
//	}
//	
//}