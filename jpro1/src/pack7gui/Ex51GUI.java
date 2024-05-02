// 연습문제 https://cafe.daum.net/flowlife/HqLo/35

package pack7gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Ex51GUI extends JFrame implements ActionListener{
	JTextField txtName, txtkor, txteng, txtmath;
	ButtonGroup buttonGroup = new ButtonGroup(); // 버튼이 모두 1개로 합쳐지는 것을 방지하기 위해 그룹으로 묶어서 분리하기 위함
	JRadioButton rdoM, rdoF;
	JLabel lblResult, lbltot, lblavg, lblrate;
	
	public Ex51GUI() {
		super("이벤트 연습");
		
		layoutInit();
	
		
		setBounds(200, 200, 400, 300);
		setVisible(true);
		
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void layoutInit() {
		setLayout(new GridLayout(5,3));
		
		// 1행
		JLabel lbl1 = new JLabel("이름 : "); //이름 입력 필드 추가
		txtName = new JTextField("", 5);
		JPanel panel1 = new JPanel();
		panel1.add(lbl1);
		panel1.add(txtName);
		add(panel1); // Frame에 등록
		
		// 2행
		JLabel lbl2 = new JLabel("국어 : "); // 나이 입력 필드 추가
		txtkor = new JTextField("", 5);
		JLabel lbl3 = new JLabel("영어 : ");
		txteng = new JTextField("", 5);
		JLabel lbl4 = new JLabel("수학 : ");
		txtmath = new JTextField("", 5);
		JPanel panel2 = new JPanel();
		panel2.add(lbl2);
		panel2.add(txtkor);
		panel2.add(lbl3);
		panel2.add(txteng);
		panel2.add(lbl4);
		panel2.add(txtmath);
		add(panel2); // Frame에 등록
		
		// 3행
		JLabel lbl5 = new JLabel("총점 : "); 
		lbltot =  new JLabel("", 5); // 여기서 lbltot 변수를 선언했으므로 재활용합니다.
		JLabel lbl6 = new JLabel("평균 : ");
		JLabel lbl7 = new JLabel("평가 : ");
		txteng = new JTextField("", 5); // 여기서 txteng 변수를 선언했으므로 재활용합니다.
		txtmath = new JTextField("", 5); // 여기서 txtmath 변수를 선언했으므로 재활용합니다.
		JPanel panel3 = new JPanel();
		panel3.add(lbl5);
		panel3.add(lbltot); // lbltot 변수로 수정합니다.
		panel3.add(lbl6);
		panel3.add(txteng); // txteng 변수로 수정합니다.
		panel3.add(lbl7);
		panel3.add(txtmath); // txtmath 변수로 수정합니다.
		add(panel3); // Frame에 등록
		
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
		int intkor = 0;
		int inteng = 0;
		int intmath = 0;
		int inttot = 0;
		int intavg = 0;
		char grade;
		
		 try{
		        intkor = Integer.parseInt(txtkor.getText()); 
		    } catch (Exception e2) {
		        lblResult.setText("국어 점수는 정수만 가능");
		        txtkor.requestFocus();
		        return;
		    }

		    try{
		        inteng = Integer.parseInt(txteng.getText()); 
		    } catch (Exception e2) {
		        lblResult.setText("영어 점수는 정수만 가능");
		        txteng.requestFocus();
		        return;
		    }
		    try{
		        intmath = Integer.parseInt(txtmath.getText()); 
		    } catch (Exception e2) {
		        lblResult.setText("수학 점수는 정수만 가능");
		        txtmath.requestFocus();
		        return;
		    }
		

	    inttot = intkor + inteng + intmath; // 총점 계산

	    intavg = inttot / 3; // 평균 계산

	    switch (intavg / 10) {
	        case 10:
	        case 9:
	            grade = 'A';
	            break;
	        case 8:
	            grade = 'B';
	            break;
	        case 7:
	            grade = 'C';
	            break;
	        case 6:
	            grade = 'D';
	            break;
	        default:
	            grade = 'F';
	    }

	    lbltot.setText(Integer.toString(inttot)); // 총점 출력
	    txteng.setText(Integer.toString(intavg)); // 평균 출력
	    txtmath.setText(String.valueOf(grade)); // 등급 출력

	    System.out.println("등급: " + grade);
		 }
	
	

	


		
	
		
	public static void main(String[] args) {
		new Ex51GUI();
	}}

