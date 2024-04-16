package pack3;

//public class Ex22Radio implements Ex22InterVol, Ex22VolEtc
//interface는 implements를 통해 다중 상속이 가능하다

public class Ex22Radio implements Ex22InterVol{
	
	private int v = 0;
	
	//Ex22InterVol과 Ex22VolEtc인터페이스에 있는 4개의 추상 메소드를 
	//아래 모두 오버라이딩해야 한다.
	@Override
	public void volUp(int v) {
		//추상 메소드 오버라이딩
		this.v += v;
	}@Override
	public void volDown(int v) {
		//추상 메소드 오버라이딩
		this.v -= v;
	}
	@Override
	public void volOn() {
		//추상 메소드 오버라이딩
		v = 1;
	}
	@Override
	public void volOff() {
		//추상 메소드 오버라이딩		
		v = 0;
	}
	
	public void showVol() {
		System.out.println("현재 볼륨은 " + v);
	}
}
