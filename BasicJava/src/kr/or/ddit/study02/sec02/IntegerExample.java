package kr.or.ddit.study02.sec02;

public class IntegerExample {
	public static void main(String[] args) {
		//정수형
		//1. byte 	: 	1byte(-128~127)
		//2. short	:	2byte(-32768~32767)
		//3. int	:	4byte(-2^31~2^31)	정수형의 기본타
		//4. long	:	8byte(-2^63~2^63)	뒤에 L(l) 을 붙임
		
		byte b1 = 127;
		System.out.println("b1="+b1);
		
		//컴파일 에러
//		byte b2 = 128;
		
		short s1 = 128;
		System.out.println("s1="+s1);
		short s2 = (short)(s1+10);
		System.out.println("s2="+s2);
		
		int i1 = 1000;
		System.out.println("i1="+i1);
		int i2 = i1+10;
		System.out.println("i2="+i2);
		
		long l1 = 1000;
		System.out.println("l1="+l1);
		long l2 = l1+10;
		System.out.println("l2="+l2);
		long l3 = 1000000000000L;
		System.out.println("l3="+l3);
		
		int var1 = 200;	
		int var2 = 0200;
		int var3 = 0x200;
		int var4 = 0b11011;
		System.out.println("var1="+var1);
		System.out.println("var2="+var2);
		System.out.println("var3="+var3);
		System.out.println("var4="+var4);
	}
}
