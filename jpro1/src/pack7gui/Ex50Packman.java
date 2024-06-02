package pack7gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Ex50Packman extends JFrame implements KeyListener{
	Image image;
	int x = 100, y = 100;
	int selImage = 1;
	
	public Ex50Packman() {
		
		super("상하좌우 화살표를 사용하세요");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack1.jpg"));
		// frame 창의 제목 왼쪽에 있는 아이콘 이미지를 설정한다.
		setLayout(null); // 배치관리자 없음
		setResizable(false); // 최대, 최소화 기능 없앰
		setBounds(200, 200, 300, 300);
		setBackground(Color.WHITE);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// TODO Auto-generated constructor stub
		addKeyListener(this);
	
		x = super.getWidth() / 2; // frame 너비의 절반
		y = super.getHeight() / 2; // frame 높이의 절반
	}
	@Override
	public void paint(Graphics g) {
	switch(selImage) {
	case 1: // Frame에 뭔가를 그려주는 메소드로 자동 호출
		image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack1.jpg");
		break;
	case 2:
		image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack2.jpg");
		break;
	case 3: 
		image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack3.jpg");
		break;
	case 4:
		image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack4.jpg");
		break;
	case 5:
		image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack5.jpg");
		break;
	case 6:
		image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack6.jpg");
		break;
	case 7:
		image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack7.jpg");
		break;
	case 8:
		image = Toolkit.getDefaultToolkit().getImage("C:\\work\\jsou\\jpro1\\src\\pack7gui\\pack8.jpg");
		break;
		
	}
		
	
	g.clearRect(0, 0, getWidth(), getHeight()); 
	// 화면 전체를 선택 후 클리어 : 잔상 해결
	
	g.drawImage(image, x - image.getWidth(this) / 2, 
			y - image.getHeight(this) / 2, this);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		//System.out.println("key : " + key);
		
		// 오른쪽 화살표
		if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_NUMPAD6) {
			// System.out.println("go");
			selImage = (selImage == 1)?2:1; 
			//삼항연산자를 써서 selImage는 1과 2사이를 왔다갔다 하게 되므로
			//selImage가 오른쪽 키를 누를때마다 1번 그림과 2번 그림으로 왔다갔다 바뀐다.
 			//x = x + 10;
			//x = (x < getWidth())? x += 10:0; 
			// 위에는 삼항연산자를 써서 그림이 frame의 너비보다 작을 때에는 오른쪽버튼을 누르면 x좌표만큼 10씩 커지므로
			// 오른쪽으로 이동하고 frame의 너비보다 커질 때에는 x좌표 값이 0으로 바뀌므로 오른쪽 화면을 벗어나게 되면 반대쪽 화면에서 시작하게 된다.
			x = (x < getWidth())? x += 10:image.getWidth(this); 
			//화면 너비 안쪽에 있을때는 x좌표로 10씩 커지므로 오른쪽으로 이동하다가 
			// 화면 너비보다 커지면 x좌표 0에서 팩맨 이미지 크기만큼 더한 좌표로부터 시작하게 된다.
			// 근데 -음수를 썼으므로 0보다 작은 왼쪽 화면 바깥 부분부터 출발하게 된다.
		}
		
		if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_NUMPAD4) {
			
			selImage = (selImage == 3)?4:3; 
			x = (x >= 0)? x -= 10:getWidth(); 
			
		}
		
		if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_NUMPAD2) {
			
			selImage = (selImage == 5)?6:5; 
			y = (y >= 0)? y +=10:getHeight(); 
			
		}
		if(key == KeyEvent.VK_UP || key == KeyEvent.VK_NUMPAD8) {
			
			selImage = (selImage == 7)?8:7; 
			y = (y <= 0)? y -=10:getHeight(); 
			
		}
		
		repaint(); // paint() 호출, 화면이 새로고침
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Ex50Packman();
	}

}
