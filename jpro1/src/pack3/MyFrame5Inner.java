package pack3;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.*;

public class MyFrame5Inner extends Frame {
// private Wevent wevent = new Wevent(); 이렇게 객체 생성해도 되고 아래 방식으로 객체 생성해도 됨
	private Wevent wevent;
	private String[] names= {"정재형", "이원재", "지명기", "김성하", "김서현"};
	int x, y; // mouseClicked에서 발생한 x, y좌표를 기억

	public MyFrame5Inner() {
		setTitle("내부 클래스");

		setSize(300, 250);
		setLocation(200, 200);
		setVisible(true);
		wevent = new Wevent();
		addWindowListener(wevent);
		// addWindowListener(new Wevent()); 객체 변수를 만들지 않고 객체만 생성하여도 무방
		addMouseListener(new Mevent());
	}

	class Wevent extends WindowAdapter {

		public void windowClosing(WindowEvent e) {
			System.exit(0);

		}
	}

	class Mevent extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			// setTitle("클릭"); Frame 창을 클릭하면 창의 제목이 "클릭"으로 바뀜

//		 int x = e.getX(); //사용자가 클릭한 부분의 x좌표 값을 x에 저장, 지역변수에 값을 치환
//		 int y = e.getY(); //사용자가 클릭한 부분의 y좌표 값을 y에 저장
			x = e.getX(); // 멤버필드(전역변수)에 값을 치환, 아래 paint(Graphics g)함수에 사용하기 위함.
			y = e.getY(); // 멤버필드(전역변수)에 값을 치환, 아래 paint(Graphics g)함수에 사용하기 위함.
			setTitle("X: " + x + ",y:" + y); // 사용자가 클릭한 부분의 x,y좌표 값을 창 제목에 출력

			paint(getGraphics());// 자동 호출되는 paint()를 명시적으로 호출, 클릭되는 곳에 그림 그리기
			repaint(); // Graphics 객체를 가진 paint()를 호출, refresh 역할, 화면을 초기화

		}
	}

	public void paint(Graphics g) { // 창을 실행하면 자동 호출이 기본값
		// Graphics : Frame이 제공하는 그림 그리기 객체
		//g.setFont(new Font("굴림", Font.BOLD, (int)(Math.random() * 50 +8)));
		//g.drawString("홍길동", x, y); 
		int n = (int)(Math.random() * 5);
		g.drawString(names[n], x, y);
	}

	public static void main(String[] args) {

		new MyFrame5Inner();

	}

}