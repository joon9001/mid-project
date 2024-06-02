package pack3;
abstract public class Ex17Jepum { // 추상 클래스 선언, abstract 위치는 public 앞이든 뒤든 상관없다.
	// 가전 제품의 원형 클래스 : 추상클래스
	public int volume = 0;
	
	public Ex17Jepum(){
		System.out.println("추상 클래스 생성자");
	}
	
	public abstract void volumeControl(); // body {}가 없는 추상 메소드
	//자식 클래스에서 반드시 오버라이딩하도록 강요
	
	public void volumeShow() {
		System.out.println("소리 크기는 " + volume);
	}
}
