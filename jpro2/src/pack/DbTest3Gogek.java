package pack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DbTest3Gogek extends JFrame implements ActionListener{
	JButton btnA = new JButton("전체");
	JButton btnM = new JButton("남자");
	JButton btnF = new JButton("여자");
	JTextArea txtResult = new JTextArea();
	
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	//
	public DbTest3Gogek() {
		setTitle("고객 자료");
		
		layinit();
		accDb();
		
		setBounds(200, 200, 300 ,250);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	private void layinit() {
		JPanel jpanel = new JPanel();
		jpanel.add(btnA);
		jpanel.add(btnM);
		jpanel.add(btnF);
		
		txtResult.setEditable(false); // read only가 됨, 커서가 못 들어감
		JScrollPane pane = new JScrollPane(txtResult);
		
		add("Center", pane);
		add("North", jpanel);
		
		btnA.addActionListener(this);
		btnM.addActionListener(this);
		btnF.addActionListener(this);
	}
	private void accDb() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("accDb err : " + e);
		}

	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//DB 연결은 필요시 접속하고 작업이 끝나면 반드시 연결을 해제한다.
		try {
			String Url ="jdbc:mariadb://localhost:3306/test";
			conn = DriverManager.getConnection(Url, "root", "123");

			stmt = conn.createStatement();
			
			String sql = "select gogek_no, gogek_name, gogek_jumin from gogek";
			
			if(e.getSource() == btnA){
				
			}else if(e.getSource() == btnM) {
				//sql += " where gogek_jumin like '%-1'"; //주민번호가 XXXXX-1인 번호를 찾으므로 남자
				sql += " where substr(gogek_jumin,8,1)=1";
				// 위의 sql 문장과 연결하기 위해 앞에 한칸 띄우고 작성한다.
			}else if(e.getSource() == btnF) {
				sql += " where substr(gogek_jumin,8,1)=2";
			}
			txtResult.setText(null); //밑에 자료 출력하는 쿼리문 실행 전에 textarea를 깨끗이 비움
			rs = stmt.executeQuery(sql);
			int count = 0;
			txtResult.setText("고객번호\t고객명\t주민번호\n");
			
			while(rs.next()) {
				String imsi = rs.getString("gogek_no") + "\t" + //\t를 써서 위의 칼럼명과 줄을 맞춘다.
						rs.getString("gogek_name") + "\t" +  // gogek_name 대신 칼럼명 순서인 2를 넣어줘도 된다.
						rs.getString("gogek_jumin") + "\n";
				txtResult.append(imsi);
				count++;
			
			}
			txtResult.append("인원수 : " + count);
		} catch (Exception e2) {
			System.out.println("actionPerformed err : " + e);
		}
		
		finally { // rs.close()를 
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			// 객체 사용 후 close()를 안했을 경우를 위해 finally 구문에서 
			// 모든 인터페이스 객체의 close()를 해준다.
				
				
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
	
	
	public static void main(String[] args) {
		new DbTest3Gogek();

	}

}
