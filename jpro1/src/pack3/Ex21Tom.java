package pack3;

public class Ex21Tom implements Ex21Resume{//인터페이스 Ex21Resume를 상속받는 클래스 Ex21Tom
	private String irum, phone, juso;
	
	public Ex21Tom () {
		
	}
	
	@Override
	public void setIrum(String irum) {
		this.irum = irum;
		//Ex21Resume 인터페이스에 선언된 추상 메소드를 오버라이딩
	}
	
	@Override
	public void setPhone(String phone) {
	this.phone = phone;
	//Ex21Resume 인터페이스에 선언된 추상 메소드를 오버라이딩
	}
	
	public void setJuso(String juso) {
		this.juso = juso; //tom 만의 고유메소드
	}
	@Override
	public void printData() {
		//Ex21Resume.SIZE = "b5";
		// 에러, Ex21Resume에서 final로 선언하였으므로 값을 바꿀수 업다 
		System.out.println("용지 규격은 " + Ex21Resume.SIZE);
		System.out.println("이름: " + irum + ", 전화: " + phone +
		", 주소:" + juso);
	}
}
