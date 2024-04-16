package pack3;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


//어댑터 클래스를 이용한 이벤트 처리 연습
//WindowAdapter 추상 클래스는 WindowListener 인터페이스를 구현한 클래스
//WindowListener의 추상 메소드가 WindowAdapter에서 일반 메소드로 오버라이드됨
public class MyFrame4Adapter extends WindowAdapter { // 상속관계
	private Frame frame;
	
	public MyFrame4Adapter() {
		frame = new Frame("Adapter 연습"); //포함관계
		
		frame.setSize(300, 250);
		frame.setLocation(200, 200);
		frame.setVisible(true);
		
		frame.addWindowListener(this);
	}
	@Override
		public void windowClosing(WindowEvent e) {
		//WindowAdapter를 상속받았기 때문에 선택적으로 필요한 메소드만 오버라이딩 할 수 있다
		System.exit(0);
		}
	
	public static void main(String[] args) {

		 new MyFrame4Adapter(); 
	}
}
