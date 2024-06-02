package pack3;

public class Ex15PolyTaxi extends Ex15PolyCar{
	private int passenger = 2;
	
	public Ex15PolyTaxi() {
		//super(); 부모 클래스 생성자 먼저 수행하는 super()가 생략되있는 상태
		System.out.println("난 택시라고 해~");
	}
	
	@Override
	public void displaySpeed() {
		System.out.println("택시 승객은 " + passenger + "명");
		
	}
}
