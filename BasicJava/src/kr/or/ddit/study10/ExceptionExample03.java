package kr.or.ddit.study10;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample03 {

	public static void main(String[] args) {
		ExceptionExample03 obj = new ExceptionExample03();
		obj.process();
	}

	public void process() {
		String[] name = {"홍길동", "이순신", "강감찬"};
		for(int i = 0; i<name.length; i++) {
			System.out.println(i+". "+name[i]);
		}
	while(true){
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose Number");
		try {
			int sel = sc.nextInt();
			if(sel <0 || sel >name.length ) {
				System.out.println();
			}
			String n = name[sel];
			System.out.println(n);
			
			
		} catch (InputMismatchException e) {
			System.out.println("ERROR");		
			
	}
		
		  catch(ArrayIndexOutOfBoundsException e) {
			  System.out.println("ERROR");
		  }
		
		  catch (Exception e) {
					
			e.printStackTrace();
	}
	}	
}
}