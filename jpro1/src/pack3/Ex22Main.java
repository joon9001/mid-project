package pack3;

public class Ex22Main {

	public static void main(String[] args) {
		Ex22Radio radio = new Ex22Radio();
		//2개의 인터페이스를 상속받는 radio 객체를 이용하기 때문에
		//2개의 인터페이스 안에 있는 5개의 메소드를 모두 쓸수있다.
		radio.volOn();
		radio.volUp(5);
		radio.volDown(2);
		radio.showVol();
		radio.volOff();
		radio.showVol();

	}

}
