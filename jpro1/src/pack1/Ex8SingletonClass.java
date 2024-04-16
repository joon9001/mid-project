package pack1;

public class Ex8SingletonClass {
	int kor = 90;
	
	public Ex8SingletonClass() {
		// TODO Auto-generated constructor stub
	}
	
	// 객체의 인스턴스가 오직 1개만 생성되는 패턴을 만들기
	// 장점 : 메모리 절약, 데이터 공유 편리
	// 단점 : 테스트가 불편, 유연성이 떨어짐 
	
	private static Ex8SingletonClass class1 = new Ex8SingletonClass();
	//싱글톤으로 매번new 객체를 만들어서 쓰지 않고 대표 객체 1개만 다른 멤버들이 공유하기 위해 
	// 자기 자신의 객체를 자신의 클래스 내에서 생성한다.
	// static 메소드는 static 멤버만 부를 수 있으므로 아래 class1을 return하기 위해서는 위에도 static이 되어야 한다.
	public static Ex8SingletonClass getInstance() {
		return class1;
		//객체를 이용하지 않고 클래스명으로 바로 함수를 불러오기 위해 static으로 선언하였다.
	}
}
