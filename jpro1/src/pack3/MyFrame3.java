package pack3;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

//인터페이스를 이용한 이벤트 처리 연습
public class MyFrame3 extends Frame implements WindowListener, MouseListener{
	public MyFrame3() {
		//생성자
		//super("상속 사용"); //이렇게 title을 설정할 경우 title 값 변경이 안된다
		super.setTitle("상속 사용"); //부모인 Frame 클래스에 선언된 title 멤버필드 값을 바꿔줌
		//상위 frame 클래스의 setter함수를 사용하여 title 값 주기
		//super는 생략가능
		display();
		
		super.addWindowListener(this); //현재 클래스에 이벤트 리스너를 장착한다는 의미로 this를 인수로 줬다.
		//frame 클래스에 존재하는 addWindowListener 함수를 써서 WindowListener 메소드를 사용할 수 있도록 한다.
		//super는 생략가능
		addMouseListener(this);
		//앞에 super는 생략가능
		//현재 클래스에서 쓴다는 의미로 this 사용
	}
	
	void display () {
	setSize(500, 300);
	setLocation(200, 150);
	setVisible(true);
	//앞에 super. 을 붙여줘야 하지만 생략 가능, 현재 클래스에서 찾아보고 없으면 자동으로 부모 클래스에서 찾기 때문
	};
	
	//windowLister가 가진 추상메소드 오버라이딩
	@Override
	public void windowActivated(WindowEvent e) {
		
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		//System.out.println("종료");
		//setTitle("안녕 종료는 아직..."); 종료버튼을 누르면 창 title이 안녕 종료는 아직... 으로 바뀐다.
		System.exit(0); //창 종료 기능 활성화
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("windowDeiconified");
		//최소화 할때마다 windowDeiconified 출력
	}
	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("windowIconified");
		//최소화 해제 할때마다 windowIconified 출력
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("windowOpened");
		
	}
	//위의 추상메소드를 오버라이딩하였으므로 MyFrame3 클래스에서 객체 생성 가능
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//System.out.println("클릭 성공 후 점심 먹기");
		//frame 창의 흰 부분을 클릭할 경우 "클릭 성공 후 점심 먹기"가 출력된다.
		//setBackground(new Color(255, 0, 0)); frame 창의 흰 부분을 찍으면 빨간색으로 바뀐다.
		//System.out.println(int)(Math.random() * 255); frame 창의 흰 부분을 찍으면 console 창에 random 정수가 찍힌다
		int r = (int)(Math.random() * 255);
		int g = (int)(Math.random() * 255);
		int b = (int)(Math.random() * 255);
		setBackground(new Color(r, g, b));
	} //frame 창의 흰 부분을 찍을때마다 랜덤 색상이 나타난다.
	
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	public static void main(String[] args) {
		//상속으로 Frame 띄우기
//		MyFrame2 frame = new MyFrame2();
//		frame.display();
	//	new MyFrame3().display(); //위의 코드 2줄을 줄인 것
		 new MyFrame3(); //객체를 만들었으므로 위의 기본 생성자에서 display()함수를 사용가능하다
	}
}
