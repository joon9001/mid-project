//https://cafe.daum.net/flowlife/HqLo/72

package lambda;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyLambda4Event {

	public static void main(String[] args) {
		JFrame frame = new JFrame("람다 연습");
		JButton button1 = new JButton("click1"); // 이벤트 처리
		JButton button2 = new JButton("click2"); // 이벤트 처리
		JButton button3 = new JButton("click3"); // collection 처리
		// 프레임 창에 버튼 3개 생성

		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 전통적 방법, click1 버튼을 누르면 아래 문구가 console 창에 출력
				System.out.println("전통적 방법으로 이벤트 처리");

			}
		});

		button2.addActionListener(e -> System.out.println("전통적 방법으로 이벤트 처리"));
		// 여기서 쓰인 람다식은 windowlistener, mouselistener와 같이 메소드가 2개 이상인 인터페이스에는 사용 불가
		button3.addActionListener(e -> callMethod());
		
		frame.add("North", button1);
		frame.add("Center", button2);
		frame.add("South", button3);

		frame.setBounds(200, 200, 300, 300);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	static void callMethod() {
		//System.out.println("a");
		ArrayList<Jikwon> jikwons = new ArrayList<MyLambda4Event.Jikwon>();
		jikwons.add(new Jikwon(3, "홍길동"));
		jikwons.add(new Jikwon(1, "홍길동"));
		jikwons.add(new Jikwon(2, "홍길동"));
		
		System.out.println("정렬 전 : ");
//		for(jikwon j:jikwons) { //전통적 방법으로 출력
//			System.out.println(j.bunho + " " + j.irum);
//		}
		
//		accept(jikwon j) { // 위와 아래는 consumer 인터페이스의 accept 함수를 오버라이딩한 것과 같다.
//			System.out.println(j.bunho + " " + j.irum);
//		}
			
		jikwons.forEach(j -> System.out.println(j.bunho + " " + j.irum)); // 람다식을 이용하여 출력
	
		System.out.println("Collections.sort 사용");
		// 특정 메소드의 매개변수로 람다식을 사용
		Collections.sort(jikwons, new Comparator<Jikwon>() {
			public int compare(Jikwon o1, Jikwon o2) {
				return o1.bunho - o2.bunho;  // 람다 없이 오름차순 정렬
			};
		});
		System.out.println("정렬 후 1 : ");
		jikwons.forEach(jik -> System.out.println(jik.bunho + " " + jik.irum));
		
		System.out.println("정렬 후 2(람다 사용) : ");
		Collections.sort(jikwons, (o1, o2) -> o1.bunho - o2.bunho);
		jikwons.forEach(jik -> System.out.println(jik.bunho + ", " + jik.irum));
	} 

	static class Jikwon {  //Dto or VO
		int bunho;
		String irum;
		String junhwa;

		public Jikwon(int bunho, String irum) {
			this.bunho = bunho;
			this.irum = irum;

		}
	}
}
