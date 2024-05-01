package pack7gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

// JDialog : 맞춤형 대화 상자 작성. 커스터마이징이 가능하다.
// Frame에서 자식창으로 호출 가능

public class Ex49MemoAbout extends JDialog implements ActionListener  {
	public Ex49MemoAbout(JFrame frame) {
		super(frame); // 쟤가 부른거라고 알려줘야함 <> 아래꺼 둘중에 하나 사용ㅎ삼 
//		super(frame, "메모장이란", true); // 모달, false : 모델리스 
		
		setTitle("메모장이란");
		setModal(true); // true 모달
//		setModal(false); // false 모달 = modaless 
		
		initLayoutAbout();
		
		setBackground(Color.LIGHT_GRAY);
		setBounds(350, 350, 200, 200);
		setVisible(true);
		
	}
	
	private void initLayoutAbout() {
		JLabel lblMes = new JLabel("미니 메모장 ver 0.9");
		JButton btnConfirm = new JButton("확인");
		btnConfirm.addActionListener(this);
		add("Center", lblMes);
		add("South", btnConfirm);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose(); // JDialog 닫기 
		
	}
}
