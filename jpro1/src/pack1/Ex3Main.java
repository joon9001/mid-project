package pack1;

public class Ex3Main {

	public static void main(String[] args) {
		// 클래스 기본 연습 중
		Ex3Programmer programmer = new Ex3Programmer();
//		객체 생성시 생성자가 호출되면서 생성자 블럭에 결과값이 출력된다.
//      출력결과
//		난 생성자야 역할은 객체 생성시 초기화를 담당해
		
//		초기화 없을 때는 생략 가능
		programmer.displayData();
//		출력결과
//		별명이 null, 나이는 22살, 보유 기술은 자바
//		보유기술 재확인 : 프로그래밍 언어 : 자바(커피 아님)
		System.out.println();
		programmer.setAge(33);
		System.out.println("나이는 " + programmer.getAge());
//		출력결과
//		나이는 33
		programmer.displayData();
//		출력결과
//		나이는 33
//		별명이 null, 나이는 33살, 보유 기술은 자바
//		보유기술 재확인 : 프로그래밍 언어 : 자바(커피 아님)
		
		System.out.println("---------1");
		Ex3Programmer tom = new Ex3Programmer();
		tom.nickName=  " 톰 아저씨";
		tom.displayData();
//		출력결과
//		난 생성자야 역할은 객체 생성시 초기화를 담당해
//		초기화 없을 때는 생략 가능
//		별명이  톰 아저씨, 나이는 22살, 보유 기술은 자바
//		보유기술 재확인 : 프로그래밍 언어 : 자바(커피 아님)
		
		System.out.println("---------2");
		Ex3Programmer james = new Ex3Programmer();
		james.nickName=  "제임스 형";
		james.displayData();
//		출력결과
//		난 생성자야 역할은 객체 생성시 초기화를 담당해
//		초기화 없을 때는 생략 가능
//		캠프 이름 : 에이콘 아카데미
//		별명이 제임스 형, 나이는 22살, 보유 기술은 자바
//		보유기술 재확인 : 프로그래밍 언어 : 자바(커피 아님)
		System.out.println();
		System.out.println("너의 모토는 " + james.motto);
		// static 멤버는 클래스이름.멤버 하고 사용한다(권장)
		System.out.println("너의 모토는 " + Ex3Programmer.motto);
		// motto를 Ex3Programmer.java 파일에서 static 멤버로 선언하였기 때문에 
		// 객체 james를 이용하지 않고도 클래스명(Ex3Programmer).멤버변수(motto)로 바로 불러올 수 있다.
		// 단, static에 저장용량 한계로 인해 꼭 필요한 멤버만 static으로 선언한다.
		Ex3Programmer.goodMethod(); //static 멤버는 goodMethod처럼 글씨가 기울어져있다.
//		출력결과
//		너의 모토는 자바에 미치는 것이다
//		너의 모토는 자바에 미치는 것이다
//		스태틱 메소드임을 널리 알리노라
	}

}
