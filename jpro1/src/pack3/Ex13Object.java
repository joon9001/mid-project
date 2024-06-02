package pack3;

//최상위 클래스 object
//public class Ex13Object extends object //object 클래스는 최상위 클래스로 클래스 생성 시 
	// 항상 자동으로 상속하며 보통 생략되어있다. object 클래스는 클래스에 필요한 기본 메서드를 갖고 있다.
	
public class Ex13Object{
@Override
	public String toString() {
		// 부모(object)의 본래 기능을 자식이 원하는 명령으로 재정의하는 오버라이딩
		return "자바여 영원하라";
	}
	
	public static void main(String[] args) {
	//최상위 슈퍼 클래스 object
	//모든 클래스는 자동으로 object 클래스를 상속받는다. - 진리
		Ex13Object obj = new Ex13Object();
		System.out.println(obj); //뒤에 .toString이 생략된 것과 똑같음
		System.out.println(obj.toString()); // toString은 앞의 변수의 참조 주소를 불러온다.
	}
//  원래 출력 결과는
//	pack3.Ex13Object@1ee0005
//	pack3.Ex13Object@1ee0005
//  이지만 위의 toString()함수에서 원래 부모 object 클래스의 toString()함수의 기본 기능인 
//  객체 주소를 불러오는 기능을 "자바여 영원하라";가 출력되도록 오버라이딩을 하였으므로 다음과 같이 출력된다.
//  자바여 영원하라
//	자바여 영원하라

}
