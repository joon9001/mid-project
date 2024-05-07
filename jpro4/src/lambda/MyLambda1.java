// https://cafe.daum.net/flowlife/HqLo/72
package lambda;

// Lambda Expression : 이름이 없는 익명 함수(메소드)
// 람다 표현식은 함수형 인터페이스의 구현으로만 가용할 수 있다.
// 1개의 추상 메소드를 가져야 하며, 람다 표현식은 해당 메소드의 구현으로 동작한다.

@FunctionalInterface // 아래가 함수형 인터페이스임을 명시적으로 알리고 있음, 
// @FunctionalInterface를 명시적으로 선언하였으므로 아래 HelloInter 인터페이스에서 2개의 추상 메소드를 쓰면 에러가 난다.
interface HelloInter{ // Lambda Expression을 사용할 인터페이스
	//추상 메소드는 1개여야만 하며 이것을 함수형 인터페이스라고 부른다.
	int calcData(int a, int b);
	// int calcData2(int a, int b); 
}

public class MyLambda1 implements HelloInter{
	

	@Override
	public int calcData(int a, int b) {
		// 인터페이스의 추상 메소드를 오버라이딩 : 전통적 방법
		return a + b;
	}
	
	
	public static void main(String[] args) {
		MyLambda1 my = new MyLambda1();
		System.out.println(my.calcData(3, 4)); // 전통적 방법
		
		System.out.println(); 
		// 인터페이스 변수 = 람다식
		// 람다 표현식의 일반적인 구문  :  (parameter ,,,) -> { body }
		HelloInter inter = (x, y) -> x + y; // (인수) -> return 값;
		System.out.println(inter.calcData(4, 5));
		
		HelloInter inter2 = (x, y) -> x * y; 
		System.out.println(inter2.calcData(4, 5));
	}

}
