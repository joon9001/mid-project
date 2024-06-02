package pack3;

public class Ex17Main {

	public static void main(String[] args) {
		// 추상 클래스 연습
		//Ex17Jepum jepum = new Ex17Jepum(); 추상 클래스는 인스턴스 생성 불가
		Ex17Jepum jepum; //추상 클래스에서 변수 선언은 가능
		
		Ex17Radio radio = new Ex17Radio(); //기본생성자 블럭에 있는 "라디오 생성자" 출력 
		jepum = radio; //radio 객체 주소를 jepum에 전달
		jepum.volumeControl(); //radio.volumeControl() 실행
		
		System.out.println();
		Ex17Tv tv = new Ex17Tv();
		jepum = tv; //Tv 객체 주소를 jepum에 전달
		jepum.volumeControl(); //Tv.volumeControl() 실행
		
		System.out.println();
		Ex17Jepum jepumArr[] = {radio, tv};
		for(Ex17Jepum j:jepumArr) {
			j.volumeControl();
		}
		
	}

}
