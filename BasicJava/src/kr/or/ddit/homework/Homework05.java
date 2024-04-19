package kr.or.ddit.homework;

import java.util.Scanner;

public class Homework05 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Homework05 obj = new Homework05();
		obj.process();
	}

	public void process() {
//		method1();
//		method2();
//		method3();
//		method4();
//		method5();
//		method6();
//		method7();
//		method8();
//		method9();
//		method10();
//		method11();

		
	}
	
	public void method1() {
		/*
		 *    *
		 *    **
		 *    ***
		 *    ****
		 *    .
		 *    .
		 *    .
		 *    ***********
		 */
		int row = sc.nextInt();
		for(int i=0; i<row; i++) {
			for(int j=0; j<i+1; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	public void method2() {
		/*
		 *         *
		 *        **
		 *       ***
		 *      ****
		 *     *****
		 *     # 힌트 * 앞에 공백 출력하기.
		 */
		int row = sc.nextInt();
		for(int i=0; i<row; i++) {
			for(int space = 0; space>i+1; space++) {
				System.out.print(" ");
			}
			for(int star = 0; star<=i+1; star++) {
				System.out.print("*");
			}
			System.out.println();
			}
		
		}
	
	public void method3() {
		/*
		 *     *****
		 *      ****
		 *       ***
		 *        **
		 *         *
		 */
		int row = sc.nextInt();
		for(int i=0; i<row; i++) {
			for(int j =0; j<i; j++) {
				System.out.print(" ");
			}
			for(int j =row; j > i; j--) {
				System.out.print("*");
				
			}	System.out.println("");
		}
	}
	public void method4() {
		/*
		 *     *****
		 *     ****
		 *     ***
		 *     **
		 *     *
		 */
		int row = sc.nextInt();
		for(int i = row; i>0; i--) {
			for(int j = 0; j<i; j++) {
				
				System.out.print("*");
			 }
		}		System.out.println();
	}
	public void method5() {
		/*
		 *         *
		 *        ***
		 *       *****
		 *      *******
		 *     *********
		 */
		int row = sc.nextInt(); //row는 피라미드 층수
		for(int i=0; i<row; i++) {
			for(int star=1; star<row-i; star++) {
				System.out.print(" ");
			}
			for(int k=0; k<i*2+1;k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
 
	public void method6() {
		/*
		 *      
		 *     *********
		 *      *******
		 *       *****
		 *        ***
		 *         *
		 */
		int row = sc.nextInt();
		for(int i=row; i>0; i--) {
			for(int j=row-i; j>0; j--) {
				System.out.print(" ");
			}
			for(int k=i*2-1; k>0; k--) {
				System.out.print("*");
				
			}	System.out.println();
	}
  }
	public void method7() {
		/*
		 *      
		 *     ******
		 *     *    *
		 *     *    * 
		 *     *    *
		 *     *    * 
		 *     ******
		 */
		int row = sc.nextInt();
		int i;
		int j;
		for(i=1; i<=row; i++) {
			for(j=1; j<=row; j++) {
				if(j==1||j==row||i==1||i==row)
			
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.print("\n");
		}
	}
	public void method8() {
		// 1  2  3  4  5
		// 6  7  8  9  10 
		// 11 12 13 14 15
		// 16 17 18 19 20 
		// 21 22 23 24 25 
		// 출력하기
		for(int i=0; i<5; i++) {
			int sum = i*5;
			for(int j = 1; j<=5; j++) {
				System.out.print(j+sum+"	");
			}
			System.out.println("");
		}
		
	}
	
	public void method9() {
		for(int i = 1; i <= 5; i++) {
	         for(int j = 0; j < 5; j++) {
	            int sum = j*5;
	            System.out.print(sum+i+"	");
	         }
	         System.out.println("");
	      }
	}
	
	public void method10() {
		// 1  10 11  20 21
		// 2    . 
		// 3 
		// 4 
		// 5  6  16  17 25
		// 출력하기 
		for(int h=0; h<5; h++) {
			for(int w=0; w<5; w++) {
				if(w%2==0) {
					System.out.print(1+h+w*5+"	");
					
				}else {
					System.out.print(5+w*5-h+"	");
				}
				
			}
			System.out.println();
		}
	}
	
	
	public void method11() {
		// 1  2  3  4  5
        // 10          6	
		// 11          15  
		// 20          16
		// 21          25 
		// 출력하기
		 for(int i = 0; i < 5; i++) {
		     if(i%2 == 1) {
		        for(int j = 5; j > 0; j--) {
		           int a = i*5+j;
		          System.out.print(a+"	");
		            }
		       }else {
		          for(int j = 0; j < 5; j++) {
		             int b = j+i*5;
		             b += 1;
		             System.out.print(b+"	");
		            }
		         }System.out.println();
		      }
	}
}

