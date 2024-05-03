package pack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DbTest7_2 extends JFrame implements ActionListener{

	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	
	JLabel gogek_name, gogek_jumin;
	JTextField name, jumin1, jumin2;
	JTextArea jikwon;
	JButton btnOk;
	
	
	
	public DbTest7_2() {
		
		 
		setBounds(200, 200, 500 ,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		layInit();
		setVisible(true);
	}
	
	private void layInit() {
		
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		gogek_name = new JLabel("고객명: "); // 클래스 변수로 변경
		name = new JTextField(5); // 클래스 변수로 변경
		
		panel1.add(gogek_name);
		panel1.add(name);
		add("North", panel1);
		
		gogek_jumin = new JLabel("주민 번호: ");
		jumin1 = new JTextField(5);
		jumin2 = new JTextField(5);
		btnOk = new JButton("확인");
		
		panel2.add(gogek_jumin);
		panel2.add(jumin1);
		panel2.add(jumin2);
		panel2.add(btnOk);
		
		add("Center", panel2);
		
		jikwon = new JTextArea("담당직원 정보 \n", 10, 20);
		
		panel3.add(jikwon);
		add(BorderLayout.SOUTH, panel3);
		
		btnOk.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			String getName = name.getText();
			String getJumin = jumin1.getText()+ jumin2.getText();
			
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				String url ="jdbc:mariadb://localhost:3306/mydb";
				conn = DriverManager.getConnection(url, "root", "123");
				String sql = "SELECT jikwon_no, jikwon_name, buser_name, gogek_tel, jikwon_jik "
						+ "FROM jikwon INNER join buser on jikwon.buser_num=buser.buser_no \r\n"
						+ "INNER JOIN gogek ON jikwon.jikwon_no=gogek.gogek_damsano "
						+ "WHERE gogek_name = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, getName);
				 // 매개변수 설정
				
				rs = pstmt.executeQuery();
				//
				while (rs.next()) {
					String imsi = rs.getString(1) + "\t" + 
							rs.getString(2) + "\t" +  
							rs.getString(3) + "\t" +
							rs.getString(4) + "\t" +
							rs.getString(5)  + "\n";
					
				
					jikwon.append(imsi);
					System.out.println(jikwon);
				}
			} catch (Exception ex) {
				ex.printStackTrace();
				System.out.println("고객명: " + getName);
			}
			
		
		}
	}	
	public static void main(String[] args) {
		new DbTest7_2();
	}
}
