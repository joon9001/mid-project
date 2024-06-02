package pack7gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ex47 extends JFrame implements ActionListener{
	JTextField txtName, txtAge;
	ButtonGroup buttonGroup = new ButtonGroup(); // 버튼이 모두 1개로 합쳐지는 것을 방지하기 위해 그룹으로 묶어서 분리하기 위함
	JRadioButton rdoM, rdoF;
	JLabel lblResult;
	
	public Ex47() {
		super("이벤트 연습");
		
		layoutInit();
	
		
		setBounds(200, 200, 400, 300);
		setVisible(true);
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void layoutInit() {
		setLayout(new GridLayout(5, 1));
		
		// 1행
		JLabel lbl1 = new JLabel("이름 : "); //이름 입력 필드 추가
		txtName = new JTextField("", 20);
		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		panel1.add(txtName);
		add(panel1); // Frame에 등록
		
		// 2행
		
		JLabel lbl2 = new JLabel("나이 : "); // 나이 입력 필드 추가
		txtAge = new JTextField("", 20);
		JPanel panel2 = new JPanel();
		panel2.add(lbl2);
		panel2.add(txtAge);
		add(panel2); // Frame에 등록
		
		// 3행
		rdoM = new JRadioButton("남자"); // 라디오버튼은 복수선택 불가, 선택은 필수
		rdoF = new JRadioButton("여자");
		buttonGroup.add(rdoM);//JRadioButton은 그룹화
		buttonGroup.add(rdoF);
		JPanel panel3 = new JPanel();
		panel3.add(rdoM);
		panel3.add(rdoF);
		add(panel3);
		// 4행
		JButton btnok = new JButton("확인"); // 확인 버튼 추가
		btnok.addActionListener(this);
		JPanel panel4 = new JPanel();
		panel4.add(btnok);
		add(panel4);
		
		// 5행
		lblResult = new JLabel("결과 : ", JLabel.CENTER);
		add(lblResult); //앞에 Frame.이 생략됨
		
		txtName.requestFocus(); // 해당 객체로 cursor 이동
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TextField 입력자료 오류검사
		if(txtName.getText().equals("")) {
			lblResult.setText("이름 입력!");
			txtName.requestFocus();
			return;
		}
		if(txtAge.getText().equals("")) {
			lblResult.setText("나이 입력!");
			txtAge.requestFocus();
			return;
		}
		//나이는 숫자 형태 여부 확인
		int nai=0;
		try{
			nai = Integer.parseInt(txtAge.getText());	
		} catch (Exception e2) {
			lblResult.setText("나이는 정수만 가능");
			txtAge.requestFocus();
			return;
		}
		
		// System.out.println(nai);
		// 라디오 버튼 선택 여부 확인
		// System.out.println(rdoM.isSelected() + " " + rdoF.isSelected());
		String gender = "";
		if(rdoM.isSelected()) {
			gender = "남";
		}else {
			gender = "여";
		}
		String message = "결과:" + txtName.getText() + "님의 나이는 " +
							nai + ", 성별은 " + gender;
		lblResult.setText(message);
	}
	
	public static void main(String[] args) {
		new Ex47();
	}
}
