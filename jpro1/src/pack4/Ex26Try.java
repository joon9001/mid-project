package pack4;

import java.io.FileNotFoundException;
import java.io.FileReader;

// 예외처리 : 키보드, 파일 처리, 네트워크, DB 연동 처리 등 외부와 접속을 통한 프로그래밍 작업 중
// 예상치 못한 에러가 발생할 수 있는데 이와 같은 경우에 사용한다.
// try ~ catch 구문을 사용
public class Ex26Try {
	
	public void testMethod() {
		System.out.println("testMethod");
		try { //main 함수의 try ~catch 구문보다 함수 내의 지역 try ~ catch의 우선순위가 높기 떄문에 에러가 날 경우 함수 내 catch 구문이 실행된다.
		int a[] = {1,2,3};
		System.out.println("배열 요소 값 출력 : " + a[0]);
		System.out.println("배열 요소 값 출력 : " + a[3]);
	} catch(ArrayIndexOutOfBoundsException e) {
		System.out.println("testMethod 오류 : " + e);
	}
	}
 //  public static void main(String[] args) throws Exception{ // throw로 자바JVM에게 예외처리를 던져버림으로써 try ~ catch구문을 안써도 됨
	   public static void main(String[] args) { 
	   //FileReader로 보조기억장치의 파일을 읽으려면 반드시 try ~ catch 문장 안에 써야 한다.
	   try {
	   FileReader fr = new FileReader("c:/work/aa.txt");
	   
	   //객체가 인스턴스의 주소를 갖지 않은 경우
	   Ex26Try try1 = new Ex26Try();
	   try1.testMethod();
	   
	   int re = 10/0; //o으로 나눌 수 없기 때문에 에러 메세지를 하단의 ArithmeticException e에서 catch하여 연산 오류를 출력한다.
	   System.out.println("re : " + re);
	} 
//	   catch (FileNotFoundException e1) {
//		System.out.println("해당 파일이 없어요");
//
//	} 
//	  
//   catch (NullPointerException e2){
//		//e2.printStackTrace(); 시스템 에러 메세지 출력
//		System.out.println("객체 변수 에러 원인은 " + e2);
//	   }
//	   catch (ArrayIndexOutOfBoundsException e3) {
//		   System.out.println("배열 처리 중 에러 : " + e3);
//	   }
//	   catch (ArithmeticException e) {
//		   System.out.println("연산 오류 " + e);
//	   }
	   catch (Exception e) {
		   System.out.println("오류 " + e);
	   } // 위에 각종 catch 구문처럼 개별적으로 에러 코드를 잡기 귀찮을 경우 최상위 부모인 Exception e로 모든 에러를 잡아서 처리할 수도 있다.
	   
	   finally {
		   System.out.println("에러와 상관없이 반드시 출력");
		   //finally는 에러가 나든 안나든 무조건 실행되는 구문이다.
	   }
	  System.out.println("프로그램 종료");
	  
   }
}
