package pack3;

public class Ex17Radio extends Ex17Jepum {
	public Ex17Radio() {
System.out.println("라디오 생성자");
}
	
	//오버라이드
	public void volumeControl() {
		System.out.println("라디오 소리 조정");
	}; 
	//자식 클래스에서 반드시 오버라이딩하도록 강요당함
}
