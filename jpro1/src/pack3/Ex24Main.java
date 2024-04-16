package pack3;

public class Ex24Main {

	public static void main(String[] args) {
		// 내부 클래스 연습용 
		Ex24Outer outer = new Ex24Outer();
		outer.aa();
		outer.bb();
		//outer.cc(); cc가 outer 객체 클래스 안의 inner 클래스 안에 있는 함수이므로 사용 불가
		
		System.out.println();
	//	Inner inner = new Inner(); // 내부 클래스는 독립적으로 인스턴스 불가
		
		//아래의 소스로 내부클래스 생성 및 수행은 가능하나 현실적으로 사용하지는 않음
	//	Ex24Outer.Inner inner = outer.new Inner();
	//	inner.cc();
		System.out.println("$$$$$$$$$$");
		outer.aa();
		
		
		
	}

}
