package kr.or.ddit.보강;

public class 보강1 {
   
   public static void main(String[] args) {
    A a = new A();   
      a.printHisto();
      }
   }


class A{  //생성자메소드
   int[] d = new int[6];
   A()  {                //파라메타
      for(int i=0; i<50; i++) {
         int r = (int)(Math.random()*6)+1;
         d[r-1]++;
      }
   }
   
   public void printHisto() {    //void = 내부에서 처리가 끝낼 수 있을떄,  호출한 곳에 값을 넘겨줘야 할 떄 반환타입
      //for문안에 for문이라면 바깥은 행 안쪽은 열
      for(int i=0; i<d.length; i++){
      }
   }
}