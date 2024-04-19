package kr.or.ddit.study05.sec02;

import java.util.Random;
import java.util.Scanner;

public class ArrayExample02 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample02 obj = new ArrayExample02();
		obj.process();
	}

	public void process() {
//		method1();
//		method2();
//		method3();
//		method4();
		method5();
//		method6();
//		method7();

		//ctrl+shift+o 눌러서 불러오기
	}
	
	public void method1() {
		// 얕은 복사 / 깊은 복사
		// 얕은 복사 (swallow copy)
		// 복사된 배열이나 원본 배열이 변경될 때 서로간의 값이 같이 변경
		
		int[] source = {1, 2, 3, 4, 5};
		int[] target = new int[source.length];
		
		for(int i = 0; i<source.length; i++) {
			target[i] = source[i];
		}
		
		System.out.println("원본 배열");
		for(int i = 0; i<source.length; i++) {
			System.out.println(source[i]+"\t");
		}
		System.out.println();
		
		System.out.println("복사된 배열");
		for(int i = 0; i<target.length; i++) {
			System.out.println(source[i]+"\t");
		}
		System.out.println();
		
		target[2] = 10;
		System.out.println("원본 배열");
		for(int  i = 0; i<source.length; i++)
			System.out.println(source[i]+"\t");
		
		System.out.println();	
		System.out.println("복사된 배열");
		for(int i = 0; i<source.length; i++) {
			System.out.println(source[i]+"\t");
		}
	}
	
	public void method2() {
		// 깊은 복사
		// 배열공간을 별도로 확보
		// 1. 반복문이용
		// 2. system.arraycopy()
		// 3. clone()
		int[] source = {1, 2, 3, 4, 5};
		int[] target = new int[source.length];
		
		System.arraycopy(source, 0, target, 0, 3);
		
		for(int i = 0; i<source.length; i++) {
			target[i] = source[i];
		}
		
		System.out.println("원본 배열");
		for(int i = 0; i<source.length; i++) {
			System.out.println(source[i]+"\t");
		}
		System.out.println();
		
		System.out.println("복사된 배열");
		for(int i = 0; i<target.length; i++) {
			System.out.println(source[i]+"\t");
		}
		System.out.println();
		
		target[2] = 10;
		System.out.println("원본 배열");
		for(int  i = 0; i<source.length; i++)
			System.out.println(source[i]+"\t");
		
		System.out.println();
		System.out.println("복사된 배열");
		for(int i = 0; i<source.length; i++) {
			System.out.println(source[i]+"\t");
		
		}
	}	
	
	public void method3() {
		//method번호 넣기
		int[] source = {1, 2, 3, 4, 5};
		int[] target = new int[source.length];
		
		System.arraycopy(source, 0, target, 0, source.length);
		
		
		for(int i = 0; i<source.length; i++) {
			target[i] = source[i];
		}
		
		System.out.println("원본 배열");
		for(int i = 0; i<source.length; i++) {
			System.out.print(source[i]+"\t");
		}
		System.out.println();
		
		System.out.println("복사된 배열");
		for(int i = 0; i<target.length; i++) {
			System.out.print(target[i]+"\t");
		}
		System.out.println();
		
		target[2] = 10;
		System.out.println("원본 배열");
		for(int  i = 0; i<source.length; i++)
			System.out.print(source[i]+"\t");
		
		System.out.println();
		System.out.println("복사된 배열");
		for(int i = 0; i<target.length; i++) {
			System.out.print(target[i]+"\t");
	}
  }
	
	public void method4() {
		//clone
		int[] source = {1, 2, 3, 4, 5};
		int[] target = source.clone();
		
		System.arraycopy(source, 0, target, 0, source.length);
		
		for(int i = 0; i<source.length; i++) {
			target[i] = source[i];
		}
		
		System.out.println("원본 배열");
		for(int i = 0; i<source.length; i++) {
			System.out.print(source[i]+"\t");
		}
		System.out.println();
		
		System.out.println("복사된 배열");
		for(int i = 0; i<target.length; i++) {
			System.out.print(target[i]+"\t");
		}
		System.out.println();
		
		target[2] = 10;
		System.out.println();
		System.out.println("원본 배열");
		for(int  i = 0; i<source.length; i++)
			System.out.print(source[i]+"\t");
		
		System.out.println();
		System.out.println("복사된 배열");
		for(int i = 0; i<target.length; i++) {
			System.out.print(target[i]+"\t");
		}
		
	}
	
	public void method5() {
		// 버블 정렬
		
		int[] num = {67, 55, 9, 86, 98};
		for(int i = 0; i<num.length-1; i++) {			
			for(int j = 0; j<num.length-1; j++) {
				if(num[j]<num[j+1]) {
					int temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
				}
			}
		}
			for(int i = 0; i<num.length; i++) {
				System.out.print(num[i]+" ");
		}
	}
	
	public void method6() {
		// 버블 정렬
		
		int[] num = {67, 55, 9, 86, 98};
		for(int i = 0; i<num.length-1; i++) {
			boolean flag = true;
			for(int j = 0; j<num.length-1; j++) {
				if(num[j]<num[j+1]) {
					int temp = num[j];
					num[j] = num[j+1];
					num[j+1] = temp;
					flag = false;
						}
					}
					if(flag) break;
				}
			for(int i = 0; i<num.length; i++) {
			System.out.print(num[i]+" ");
			}
	}
	
	
	public void method7() {
		//45 짜리 temp 배열만들기
		int[] temp = new int[45];
		//1~45까지 값 넣기
		for(int i = 0; i<45; i++) {
			temp[i] = i+1;
		}
		
		for(int i = 0; i<temp.length; i++)
			System.out.print(temp[i] + " ");
		System.out.println();
		
		
		for(int i = 0; i<temp.length; i++) {
			temp[i] = i+1;
		}
		for(int i = 0; i<temp.length; i++)
			System.out.print(temp[i] + " ");
		System.out.println();
		//배열섞기
		for(int i = 0; i<10000; i++) {
			int ran = new Random().nextInt(temp.length);
			int t = temp[0];
			temp[0] = temp[ran];
			temp[ran] = t;
		} 
		//6자리 lotto 만들기
		int[] lotto = new int [6];
		//lotto 배열에 temp 0~5 까지 값을 복사
		System.arraycopy(temp, 0, lotto, 0, 6);
		
		for(int i = 0; i<lotto.length; i++) {
			System.out.print(lotto[i]+", ");
		}
		System.out.println();
		//lotto 배열 정렬 하기
		for(int i=0; i<lotto.length-1; i++) {
			for(int j = 0; j<lotto.length-1; j++) {
				if(lotto[j]>lotto[j+1]) {
					
				}
					int t = lotto[j];
					lotto[j] = lotto[j+1];
					lotto[j+1] = t;
			}
		}
		for(int i = 0; i<lotto.length; i++) {
			System.out.print(lotto[i]+", ");
		}
		System.out.println();
	}
}