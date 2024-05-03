package pack;

import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DBTest7_1 extends JFrame implements ActionListener{

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	JTextArea txtFinal = new JTextArea(15, 55);
	JTextField txtResult1, txtResult2, txtResult3, txtResult4, txtResult5;
	
	
	public DBTest7_1() {
	  super("상품 처리");
	  try {  
		  
		  Class.forName("org.mariadb.jdbc.Driver");
      String url ="jdbc:mariadb://localhost:3306/mydb";
      conn = DriverManager.getConnection(url, "root", "123");
      String sql = "select code, sang, su, dan, su*dan as tot from sangdata";
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
	
	} catch (Exception e) {
		// TODO: handle exception
	}
	    
		layInit();
		
		
		setBounds(200, 200, 500 ,350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void layInit() {
		
		JLabel code = new JLabel("코드: ");
		txtResult1 = new JTextField(5);
		JLabel sang = new JLabel("품명: ");
		txtResult2 = new JTextField(5);
		JLabel num = new JLabel("수량: ");
		txtResult3 = new JTextField(5);
		JLabel price = new JLabel("단가: ");
		txtResult4 = new JTextField(5);
		//
		JButton btnAdd = new JButton("추가");
		txtFinal.setText(null); //밑에 자료 출력하는 쿼리문 실행 전에 textarea를 깨끗이 비움
		txtFinal.setText("코드\t상품명\t수량\t단가\t금액\n");
		try {	
			
			while(rs.next()) {
				
				
            String imsi = rs.getString("code") + "\t" + 
                    rs.getString("sang") + "\t" +  
                    rs.getString("su") + "\t" +
                    rs.getString("dan") + "\t" +
                    rs.getString("tot")  + "\n";
                  
            txtFinal.append(imsi);
        }
			
		} catch (Exception e) {
			// TODO: handle exception
		} 
	
		
		JPanel panel1 = new JPanel(); // FlowLayout
		panel1.add(code);
		panel1.add(txtResult1);
		panel1.add(sang);
		panel1.add(txtResult2);
		panel1.add(num);
		panel1.add(txtResult3);
		panel1.add(price);
		panel1.add(txtResult4);
		panel1.add(btnAdd);
		add("North", panel1);
		
		JPanel panel2 = new JPanel();
		panel2.add(txtFinal);
		add("Center", panel2);
		
		btnAdd.addActionListener(this);
		
	}
	
		
	@Override
	public void actionPerformed(ActionEvent e) {
	    try {
	    	
	        String userInput1 = this.txtResult1.getText();
	        String userInput2 = this.txtResult2.getText();
	        String userInput3 = this.txtResult3.getText();
	        String userInput4 = this.txtResult4.getText();
	        
	        
	        String imsi = (userInput1 + "\t" + userInput2 + "\t" +
	     	       userInput3 + "\t" + userInput4 +  "\n");
	        // 텍스트 영역에 사용자 입력값을 추가합니다.
	        txtFinal.append(imsi);

	        	        
	    } catch (Exception ex) {
	        // 예외 처리 및 로깅
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "데이터베이스 연결 또는 쿼리 수행 중 오류가 발생했습니다.");
	    } finally {
	        // 자원 해제
	        try {
	            if (rs != null) rs.close();
	            if (pstmt != null) pstmt.close();
	            if (conn != null) conn.close();
	        } catch (Exception ex) {
	            // 자원 해제 중 예외 발생 시 로깅
	            ex.printStackTrace();
	        }
	    }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DBTest7_1();
	}

}
