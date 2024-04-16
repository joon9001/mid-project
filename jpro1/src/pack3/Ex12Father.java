package pack3;

public class Ex12Father extends Ex12GrandFa { //단일 상속만 가능, 다중 상속 불가
	// Ex12GrandFa fa = new Ex12GrandFa(); // 포함관계, 지금은 상속관계 연습이므로 사용 안함
	public String gabo = "꽃병"; // 은닉화, 부모에 선언한 gabo는 실행되지 않는다.
	private int nai = 55;
	private int house = 1;
	
	public Ex12Father() {
		// super(); // 매개변수가 없는 부모 생성자를 호출하는 super()가 생략되어 있음
		System.out.println("아버지 생성자");
	}
	public Ex12Father(int n) {
		System.out.println("아버지 생성자라고 해");
	}
	//@Override 부모가 가지고 있는 메소드를 자식에서 똑같이 선언하여 쓰는 것
//	public int getNai() {
//			return nai;
//		}
	public String say() {
		return "아버지 말씀 : 에러 잡는 연습을 하거라";
	}
	final public String getHouse() {
		return "집 : " + house + "채";
	}
	public void showData() {
		System.out.println("아버지 나이 " + nai); //블럭 내에서 지역변수 찾다가 없으면 멤버필드 검색
		System.out.println("아버지 나이 " + this.nai); //처음부터 멤버필드 검색하고 없으면 부모 클래스에서 멤버필드 검색
		System.out.println("아버지 나이 " + getNai()); // 현재 클래스의 getNai() 찾다가 없으면 부모 클래스 getNai() 검색
		System.out.println("아버지 나이 " + this.getNai()); // 현재 클래스의 getNai() 찾다가 없으면 부모 클래스 getNai() 검색
		//System.out.println("할아버지 나이" + super.nai); // nai가 private이므로 에러
		System.out.println("할아버지 나이 " + super.getNai());// 처음부터 바로 부모 클래스 getNai() 검색
		
		System.out.println();
		String gabo = "물병";
		System.out.println("가보 " + gabo);
		System.out.println("가보 " + this.gabo);
		System.out.println("가보 " + super.gabo);
	}
}
