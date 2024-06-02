package pack3;

public interface Ex21Resume { //이력서 표준 양식
	String SIZE = "A4"; // public final static String 인 SIZE
	//int kor = 90;	// interface 안에 선언한 변수는 무조건 final static이다.

	void setIrum(String irum);
	void setPhone(String phone);
	void printData();
	
	//java 1.8 이후에 가능한 기술로 default를 선언하면 일반 함수를 인터페이스에서 사용 가능
	default void display(boolean b) {
		if(b) {
			System.out.println("참");
		}else {
			System.out.println("거짓");
		}
	}
	static void play() { //static을 써도 인터페이스에 일반 메소드를 사용할 수 있다.
		System.out.println("play 메소드");
	}
}
