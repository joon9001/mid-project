package pack3;

public class Ex21James implements Ex21Resume{//인터페이스 Ex21Resume를 상속받는 클래스 Ex21Tom
	private String irum, phone, skill;
	
	public Ex21James () {
		
	}
	
	@Override
	public void setIrum(String irum) {
		if(irum.equals(null)) {
		this.irum = "아무개";
		}else {
			this.irum = irum;
		}
		//Ex21Resume 인터페이스에 선언된 추상 메소드를 오버라이딩
	}
	
	@Override
	public void setPhone(String phone) {
	this.phone = phone;
	//Ex21Resume 인터페이스에 선언된 추상 메소드를 오버라이딩
	}
	
	public void setSkill(String s) {
		skill = s; //james 만의 고유메소드, 오버라이딩x
	}
	@Override
	public void printData() {
		//Ex21Resume.SIZE = "b5";
		// 에러, Ex21Resume에서 final로 선언하였으므로 값을 바꿀수 업다 
		System.out.println("이력서 규격은 " + Ex21Resume.SIZE);
		System.out.println("이름: " + irum + ", 전화: " + phone +
		", 보유기술:" + skill);
	}
}
