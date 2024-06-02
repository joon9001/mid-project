package pack3;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame6 extends Frame {
	public MyFrame6(String msg) {
		super(msg); //Frame 객체에 msg를 전달하게 되는데 이러면 창의 제목이 msg 내용으로 바뀐다.
		
		setSize(300, 250);
		setLocation(200, 200);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() { 
			//내부 익명클래스를 쓰기 위해 new 객체 생성후
			//adapter가 갖고 있는 메소드를 아래에 오버라이딩한다.
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
			//	setBackground(new Color(0, 0, 255)); 아래랑 똑같은 방법
				setBackground(Color.BLUE);
			}
		});
	}
	public static void main(String[] args) {
		// 내부 무명 클래스
		new MyFrame6("내부 무명 클래스");

	}

}
