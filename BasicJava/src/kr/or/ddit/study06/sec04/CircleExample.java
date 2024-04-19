package kr.or.ddit.study06.sec04;

import java.util.Scanner;

public class CircleExample {

   Scanner sc = new Scanner(System.in);

   public static void main(String[] args) {
      CircleExample obj = new CircleExample();
      obj.process();
   }

   public void process() {
      
      Circle c1 = new Circle();
      
      double r = 0;
      System.out.println("반지름을 입력하세요 : ");
      r = sc.nextDouble();
      double area = c1.area(r);
      double circumference = c1.circumference(r);
      System.out.println("원의 넓이   :   "+area);
      System.out.println("원의 둘레   :   "+circumference);

   }
}