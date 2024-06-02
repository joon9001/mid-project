package pack3;

public class Ex17Tv extends Ex17Jepum {
	public Ex17Tv() {
System.out.println("TV 생성자");
}
	
	//오버라이드
	public void volumeControl() {
		System.out.println("TV 소리 변경");
	}; //부모 클래스인 Ex17Jepum에서 volumeControl()이 추상 메소드이므로 반드시 오버라이딩해야 함
	//자식 클래스에서 반드시 오버라이딩하도록 강요당함
	
	@Override
	public void volumeShow() {
		//오버라이딩 선택, 필수 아님
		System.out.println("소리 크기는 적당히 : 부모 메소드 내용 대신 새로운 내용으로 대체" );
	}
}