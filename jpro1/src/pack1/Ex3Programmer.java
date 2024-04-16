package pack1;

public class Ex3Programmer {
	//public String nickName = "";
	public String nickName; 
	// String 값을 지정해주지 않으면 위의 공백 들어간것과 똑같은 null이 초기값이 된다.
	//private int age = 0;
	private int age; // int 값을 지정해주지 않으면 초기 값은 0 <- 기본형
	String spec = "자바";
	public static String motto = "자바에 미쳐 버리자";
	public final String campName = "에이콘 아카데미"; // final이 붙었으므로 변수 수정 불가
	
	public Ex3Programmer() {
		System.out.println("난 생성자야 역할은 객체 생성시 초기화를 담당해");
		System.out.println("초기화 없을 때는 생략 가능");
		age = 22;
		//displayData();
		//campName = "도토리"; 
		// 위에 전역변수 campName이 final이므로 변수 수정 불가이므로 에러
		System.out.println("캠프 이름 : " + campName);
	}
	public void displayData() {
		System.out.println("별명이 " + nickName + ", 나이는 " + age + "살, "
				+ "보유 기술은 " + spec);
		//메소드가 다른 메소드 호출 가능
		System.out.println("보유기술 재확인 : " + showSpec());
	}
	private String showSpec() {
		String msg = "프로그래밍 언어 : " + spec;
		return msg + "(커피 아님)";
	}
	
	//private age에 대한 getter, setter
	public void setAge(int age) {
		this.age = age;
	}
	public int getAge() {
		return age;
	}
	
	
	static public void goodMethod() {
		System.out.println("스태틱 메소드임을 널리 알리노라");
		System.err.println(motto);
		//System.out.println(age); //에러
		//Static이 stack, heap보다 먼저 만들어지기 때문에 static 메소드는 
		//static 멤버만 부를 수 있다.
	}
	public void niceMethod() {
		System.out.println(age); //일반 메소드는 일반 멤버 호출 가능
		System.err.println(motto);//일반 메소드는 static 멤버 호출 가능
	//일반 멤버보다 static 멤버가 먼저 만들어지기 때문에 일반 메소드가 static 멤버를 호출 가능한것이다.
	}
}
