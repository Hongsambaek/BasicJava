package kr.or.ddit.study06.sec04;

import java.util.Date;
import java.util.Scanner;

public class RecursionExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		RecursionExample obj = new RecursionExample();
		obj.process();
	}

	public void process() {
//		method(5);
//		int add = add(5);
//		System.out.println(add);
//		long mul = mul(5);
//		System.out.println(mul);
		long pbo = pbo(100);
		long pbo2 = pbo2(100);
		System.out.println(pbo);
		Date d1 = new Date();
		Date d2 = new Date();
		System.out.println(d2.getTime() - d1.getTime());
		
		
	}
	
	long[] pboList = new long[3000];
	
	
	
	
	//5 → 5+4+3+2+1 결과값 리턴
	public int add(int num) {
		if(num == 1) return 1;
		return num+add(num-1);
			
		}
	
	public long mul(int num) {
		if(num == 1) return 1;
		return num*mul(num-1);
	}
	
	
	// 1 2 3 5 8 13 21
	// 1+2 => 3
	// 2+3 => 5....
	public long pbo(int num) {

	      if (num == 2)
	         return 2;
	      if (num == 1)
	         return 1;
	      return pbo(num - 1) + pbo(num - 2);

	   }
	
	public long pbo2(int num) {
		if(num==2) return 2;
		if(num==1) return 1;
		
		if(pboList[num]!= 0) {
			return pboList[num];
		}
		
		long result = pbo2(num-1) + pbo2(num-2);
		pboList[num] = result;
		return result;
	}	
	
	
	
	
	
	public void method(int num) {
		System.out.println(num);
		if(num>0) {
			method(num-1);
		}
		
	}
}
