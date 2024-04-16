package pack3;

import java.awt.Frame;

public class MyFrame2 extends Frame {
	public MyFrame2() {
		//생성자
		super("상속 사용");
	}
	
	void display () {
	setSize(500, 300);
	setLocation(200, 150);
	setVisible(true);
	//앞에 super. 을 붙여줘야 하지만 생략 가능, 현재 클래스에서 찾아보고 없으면 자동으로 부모 클래스에서 찾기 때문
	};
	public static void main(String[] args) {
		//상속으로 Frame 띄우기
//		MyFrame2 frame = new MyFrame2();
//		frame.display();
		new MyFrame2().display(); //위의 코드 2줄을 줄인 것
		
	}
}
