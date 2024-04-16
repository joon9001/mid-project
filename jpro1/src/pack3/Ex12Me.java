package pack3;

public class Ex12Me extends Ex12Father { //
	final int score = 90;
	public Ex12Me() {
		// super(); 생략 가능
		System.out.println("내 생성자");
		//score = 80; // 멤버 필드 score에 final을 줬기 때문에 값 수정이 불가하므로 에러
	}
	public void biking() {
		System.out.println("자전거로 전국일주~~~");
	}
//	public String getHouse() {
//		return "집"; // 부모에서 final해서 오버라이딩 불가
//	}
	
}
