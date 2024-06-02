package pack3;

public class Ex25Person {
	public Ex25Saram getSaram() {
		//return new Ex25Saram();  //Ex25Saram()객체의 주소를 리턴
		return new Ex25Saram() //객체 주소 반환 후 내부 무명클래스가 아래처럼 올 수 있다.
		{    //내부 무명 클래스
			public String getIr() { //Ex25Saram 클래스의 메소드를 오버라이딩할 수 있음
				return "홍길동"; //위에 리턴되는 클래스에 소속되어있는 메소드만 오버라이딩 할 수 있음
			}
			};
	
		}

	}
