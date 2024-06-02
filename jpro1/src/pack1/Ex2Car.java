package pack1;

public class Ex2Car {
	private int speed;
	public String irum;
	private double weight; //private이므로 getter, setter함수를 이용하여 외부 클래스에서 참조한다.
	
	public Ex2Car() {
		irum = "홍길동";
		speed = 10;
	}
	public void showData() {
		System.out.println("이름은 " + irum + ", 속도는 " + speed);
	}
	
	public void setSpeed(int s) { // 위의 int speed가 private이므로 public함수를 통해 
								  // speed 값에 접근할 수 있도록 도와주므로 setter 메소드
		
		speed = s;
			
	}
	public int getSpeed() { //getter 메소드, public으로 설정하여 외부에서 바로 가져다 쓸 수 있는 함수
		return speed; //위의 getSpeed()의 자료형과 return 값의 자료형이 일치해야한다. 
	}				 // 여기서는 return값도 int형이어야 한다.
	public double getWeight() {
		return weight; //마우스 오른쪽 버튼 - source - generate getter/setter를 누르면 
					   // getter/setter함수 양식을 자동으로 만들어준다.
	}
	public void setWeight(double weight) {
		this.weight = weight; // this.weight는 맨 위에 선언한 멤버 필드 private double weight이고  
							// 매개변수 double weight와 블럭의 weight는 지역변수이다.
	}						// 멤버필드 weight에 지역변수 weight 값은 치환
							// this는 원래 생략가능하나 지역변수와 멤버 필드 변수의 이름이 똑같으면 생략 불가능하다

}
	