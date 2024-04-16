package pack1;

public class Ex4SingerType { // 가수들이 가져야할 기본 멤버를 클래스로 작성
	private String name = "무명 가수"; // 이름
	private String title = "아 대한민국"; // 곡 제목
			
	//...
	
	//아래 생성자를 통해 멤버 변수에 값을 저장하는 방법
	public Ex4SingerType(String name, String title) { 
		
		this.name = name;
		this.title = title;
	//객체 생성시 전달받은 인수를 위의 전역변수에 저장
	}
	
	public String getName() { //getter함수
		return name; //원래는 this.name이지만 name으로 써도 무방함
	}
			
	public String getTitle() {//getter함수
		return title; //원래는 this.title이지만 title로 써도 무방함
	}
			
	public void sing() {
		System.out.println(name + " is singing " + title + "...");
	}
			
	public static void main(String[] args) {
		//응용 프로그램 시작용 메소드
		// Ex4SingerType 멤버는 아님
		Ex4SingerType bts = new Ex4SingerType("BTS", "Dynamite"); 
		//인수를 생성자 인수에 전달
		bts.sing();
		// "BTS is singing Dynamite..." 출력
		System.out.println("가수 이름 : " + bts.getName()); 
		//getter함수를 통해 private으로 선언한 name 출력가능
		System.out.println("곡 제목 : " + bts.getTitle());
		//getter함수를 통해 private으로 선언한 title 출력가능
		System.out.println();
		Ex4SingerType blackpink = new Ex4SingerType("Blackpink", "How you like that");
		//인수를 생성자 인수에 전달
		blackpink.sing();
		//"Blackpink is singing How you like that..." 출력
		System.out.println("가수 이름 : " + blackpink.getName());
		//getter함수를 통해 private으로 선언한 name 출력가능
		System.out.println("곡 제목 : " + blackpink.getTitle());
		//getter함수를 통해 private으로 선언한 title 출력가능
    }
}
