package pack1;

//접근 지정자
// -public : 같은 프로젝트 내에서 유효, 패키지가 달라도 됨
// -protected : 같은 프로젝트 내에서 유효, 패키지가 다른 경우 자식 클래스만 유효
// -default: 같은 프로젝트 내에서만 유효, 
// -private: 현재 클래스 내에서만 유효, 다른 클래스에서는 참조 불가


public class Ex1Car { //[접근지정자][기타제한자] 클래스 이름과 파일명은 무조건 같아야 하며 첫글자는 대문자여야 한다.
	int wheel; // 멤버 필드(전역 변수) : default 접근 지정자, 값을 따로 안줬기 때문에 초기값은 0이다. int wheel = 0과 같음 
	private int airBag = 1; // [접근지정자][기타제한자] 타입 변수명
	private int speed; //private하고 주면 캡슐화가 된다.
	public String irum;
	
	public Ex1Car() { //클래스와 이름이 같고 반환형이 없는 메소드를 생성자라 부른다. //생성자는 블럭 안에 쓸 내용이 없으면 안써도 된다.
		System.out.println("생성자 : 객체 생성 시 초기화를 담당. 1회 호출됨");
	}//생성자 함수는 첫글자를 대문자로 써야하고 나머지 함수는 무조건 소문자로 시작
	public void abc() {  // [접근지정자][기타제한자] 반환타입(형) 메소드명([타입 매개변수...])
		System.out.println("abc 메소드 수행");
		System.out.println("에어백 수는 " + airBag); // private 멤버지만 같은 class이기 때문에 호출 가능
		def(); // private 멤버는 현재 클래스 내에서만 사용 가능
	}
	private void def() {
		System.out.println("def 메소드 수행");
	}
}
