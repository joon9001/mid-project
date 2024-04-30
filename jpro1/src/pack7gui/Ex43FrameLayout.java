/*
1. AWT(Abstract Window Toolkit)

1) AWT란?
- GUI프로그래밍(윈도우 프로그래밍)을 위한 도구
- Java로 구현하지 않고 OS의 컴포넌트를 그대로 사용(OS 종속적)

2) Swing
- AWT를 확장한 GUI프로그래밍 도구
- AWT보다 더 많은 종류의 컴포넌트 제공
- OS의 컴포넌트를 사용하지 않고 Java로 구현

3) AWT의 구성
- AWT관련 패키지는 모두 java.awt로 시작
- AWT컴포넌트의 최상위 조상은 java.awt.Component 클래스(메뉴 관련 컴포넌트 제외)

4) Container
- 다른 컴포넌트를 포함할 수 있는 컴포넌트
- 독립적인 컨테이너: 독립 사용 가능, 다른 컴포넌트나 종속적 컨테이너를 포함 가능
- 종속적인 컨테이너: 독립 사용 불가(다른 컨테이너에 포함)
- add()를 사용해서 추가
- 컨테이너에 담기는 컴포넌트는 컨테이너의 설정을 따름(변경 가능)

2. AWT의 주요 컴포넌트

1) Frame
- titlebar와 최소화, 최대화, 닫기 버튼을 가진 윈도우(컨테이너)
- 생성자: Frame(String title)
ex) Frame f = new Frame("Hi") // Hi 프레임 생성
- setSize(int, int): 사이즈 설정
- setLayout(new 레이아웃명()): 레이아웃 설정
- setVisible(true): 프레임 시각화
- 프레임참조변수.add(컴포넌트 참조변수): 컨테이너에 컴포넌트 추가

2) Button
- 사용자가 클릭했을 때 작업이 수행되도록 하는 컴포넌트
- 생성자: Button(String label)
- setLocation(int, int): 위치 설정 

3) Choice(Combo Box)
- 여러 아이템 중 하나를 선택할 수 있게 만드는 콤보박스 컴퍼넌트
- 생성자: Choice()
- 초이스참조변수.add("속성"): 목록에 값 추가

4) List
- 리스트 컴포넌트
- 생성자: List(int rows, boolean multipleMode) // 나타낼 줄의 수, 다중선택 가능 여부 
* List(int row)로 생성시 단일선택
- 리스트참조변수.add("속성"): 목록에 값 추가

5) Label
- 텍스트를 표시하는 컴포넌트
- 생성자: Label(String text, int alignment) // 텍스트, 정렬방식(정렬방식 미선택 가능)
- 라벨참조변수.setBounds(int, int, int, int) // 가로위치, 세로위치, 가로크기, 세로크기

6) Checkbox
- 선택여부를 표현하는 컴포넌트
- 생성자: Checkbox(String text, boolean state) // 텍스트, 생성시 체크 여부(미선택 가능)
- Checkboxgroup으로 생성시 그룹 내 체크박스 중 하나만 선택 가능
- 생성자: Checkboxgroup(String text, CheckboxGroup group, boolean state) // Checkbox 생성자에서 그룹명 추가됨

7) TextField
- 사용자로부터 데이터를 입력받을 수 있는 컴포넌트
- 한 줄만 입력 가능
- 생성자: TextField(String text, int col) // 보여질 텍스트, 입력받을 글자 수(크기)

8) TextArea
- 여러 줄의 텍스트를 입력하거나 보여줄 수 있는 입력가능한 컴포넌트
- 생성자: TextArea(String text, int row, int col, int scrollbar) // 보여질 텍스트, 행, 열, 스크롤바 사용 여부(행렬만 선택 가능)
- TextArea참조변수.selectAll(): 텍스트 전체 선택

9) Scrollbar
- 정해진 범위 내에서 값 조절이 가능한 컴포넌트
- 생성자: Scrollbar(int orientation, int value, int visible, int min, int max) // 스크롤바 종류, 초기값, 스크롤버튼 크기, 최소값, 최대값

10) Canvas
- 그림을 그리거나 이미지를 위한 공간으로 사용되는 컴포넌트
- 생성자: Canvas(GraphicsConfiguration config) // 대상 객체 지정(미선택 가능)
- 캔버스참조변수.setBackground(Color.색) // 캔버스 배경색 변경
- 캔버스참조변수.setBounds(int, int, int, int) // 가로위치, 세로위치, 가로크기, 세로크기

11) Panel
- 빈 평면 공간만 가진 종속적 컨테이너
- Panel 안에 Panel을 삽입 가능(컴포넌트의 다양한 배치에 유용)
- 생성자: Panel(LayoutManager layout) // 레이아웃(미선택 가능)
- setSize, setLocation, setBackground 사용

12) ScrollPane
- 화면이 작아지면 나타나는 스크롤 바(제한된 공간에서 큰 컴포넌트를 보여줄 때 사용)
- 단 하나의 컴포넌트만 포함 가능한 종속적 컨테이너
- 생성자: ScrollPane(int scrollbarDisplayPolicy) // 스크롤바 표시 여부(미선택 가능)

13) Dialog
- Frame과 같은 독립적 컨테이너, 닫기버튼을 가지고 있음(알림창, 입력 받을 때 사용)
- 생성자: Dialog(Frame parent, String title, Boolean modal) // 부모 프레임 지정, 타이틀 명, 필수 응답 여부 지정
- setSize, setLocation, setBackground, setLayout 사용

14) FileDialog
- 파일을 열거나 저장할때 사용하는 Dialog
- 생성자: FileDialog(Frame parent, String title, int mode) // 부모 프레임 지정, 타이틀명, Save or Load 지정
- setFile, setDirectory, getFile, getDirectory 사용

15) Font
- Component 클래스의 setFont(Font f)를 사용해서 폰트 변경
- 생성자: Font(String name, int style, int size) // 폰트명, 폰트 스타일(볼드 이탤릭 등), 크기
ex) Font f = new Font("Serif", Font.BOLD, 20)
컴포넌트참조변수명.setFont(f) <- f에 저장된 폰트 적용 가능

16) Color
- 색 표현에 사용되는 클래스(미리 정의된 색 혹은 RGB값 사용 가능)
- 생성자: Color(int r, int r, int g, int b) // 불투명도, 0~255 사이의 rgb값, float으로도 가능
*기본적인 색은 Color.컬러명으로 사용

3. 메뉴 만들기

1) 메뉴
- MenuBar에는 Menu만 포함 가능
- Menu에는 Menu와 MenuItem 포함 가능(Menu 포함시 계층형 Menu 생성)
- 생성자: Menubar(), Menu("메뉴명"), MenuItem("메뉴아이템명")
- 참조변수.add(하위참조변수)로 추가

2) PopupMenu
- 윈도우(Frame)내에서 오른쪽 마우스를 클릭하면 나타나는 메뉴
- 부모프레임에 추가시켜서 사용
- 생성자: PopupMenu(String label) // 라벨(나타나지 않음)
- 팝업메뉴참조변수.add(메뉴아이템참조변수)로 추가 (속성은 MenuItem으로 생성)

4. 레이아웃 매니저
1) 레이아웃 매니저를 이용해서 컴포넌트 배치
- 컨테이너에 포함된 컴포넌트의 배치를 자동관리
- 종류: BorderLayout, FlowLayout, GridLayout, CardLayout, GridbagLayout
- 기본형: FlowLayout(Panel, Applet), BorderLayout(Window, Dialog, Frame)

2) BorderLayout
- 5개의 영역으로 분리(각 영역당 컴포넌트 1개 삽입 가능, Panel 사용하면 여러개 가능)
- 생성자: BorderLayout(int hgap, int vgap) // 좌우 간격, 상하 간격(미선택 가능)

3) FlowLayout
- 워드프로세서와 같이 맞춤 정렬 가능(좌, 중간, 우)
- 생성자: FlowLayout(int align, int hgap, int vgap) // 정렬방법, 좌우 간격, 상하 간격
*기본생성자 선택시 가운데 정렬, 상하좌우 5픽셀

4) GridLayout
- 컴포넌트를 임의의 행렬로 배치
- 생성자: GridLayout(int row, int col, int hgap, int vgap) // 행, 열, 좌우 간격, 상하 간격

5) CardLayout
- 여러 컨테이너를 슬라이드처럼 표시(앨범 혹은 퀴즈 프로그램에 사용)
- 생성자: CardLayout(int hgap, int vgap) 좌우 간격, 상하 간격

5. 이벤트 처리(Event Handling)
1) 이벤트
- 사용자 혹은 프로그램에 의해 발생할 수 있는 하나의 사건
- 이벤트소스(Event Source, 이벤트 발생지): 이벤트가 발생한 컴포넌트
- 이벤트핸들러(Event Handler, 이벤트 처리기): 이벤트 발생시 실행될 코드를 구현
- 이벤트리스너(Event Listener, 이벤트 감지기): 이벤트를 감지하고 처리

2) 이벤트 처리(Event Handling)
- 이벤트 발생시 어떠한 작업이 수행되도록 코드를 작성
- 클래스 작성 예시

class EventHandler implements 해당인터페이스 {

	public void 해당메소드(해당이벤트명 매개변수) { /* 코드작성 */ 


/*
class Main {

	public static void main(String args[]) {
	Frame f = new Frame("프레임명") // 기본 프레임 선언
	f.add해당이벤트 (new EventHandler()); // EventHandler클래스를 프레임의 이벤트로 등록
}

}
*/
// LayoutManager 참조 : https://m.blog.naver.com/so_yuns/222172786073
// Frame : BorderLayout이 기본 
// Panel : FlowLayout이 기본


package pack7gui;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex43FrameLayout extends Frame implements ActionListener{ // 컨테이너
	Panel pn1 = new Panel(); // 컨테이너(visual Object을 담는 그릇)의 일종
	Panel pn2 = new Panel();
	Panel pn3 = new Panel();
	Panel pn4 = new Panel();
	Panel pn5 = new Panel();
	Panel pn6 = new Panel();
	
	TextField txtBun, txtIrum;
	Button btnGo; 
	CardLayout card = new CardLayout();
	
	public Ex43FrameLayout() {
		// 배치 관리자로 화면 디자인 연습
		setLayout(new GridLayout(2, 1)); // Frame의 Layout을 변경, BorderyLayout을 2행 1열로 변경
	
		// 첫번째 행 디자인 
		Label lbl1 = new Label("bunho: "); // 메세지 컴포넌트 
		txtBun = new TextField("10", 20); // 키보드로 자료 입력 가능한 컴포넌트
		pn1.add(lbl1); // Panel1에 Label1 객체 담기
		pn1.add(txtBun); // Panel1에 TextField 객체 담기
		pn1.setBackground(Color.yellow); // Panel1 배경색 변경
		//super.add(pn1); // Frame에 Panel1을 담기 
		
		Label lbl2 = new Label("irum: "); // 메세지 컴포넌트 
		txtIrum = new TextField("이기자", 30); // 키보드로 자료 입력 가능한 컴포넌트
		pn2.add(lbl2); // Panel2에 Label2 객체 담기
		pn2.add(txtIrum); // Panel2에 TextField 객체 담기
		pn2.setBackground(Color.CYAN); // Panel1 배경색 변경
		
		pn3.setLayout(card); // pn3: FlowLayout을 CardLayout으로 변경
		// 두번째 행 디자인
		pn3.add("first", pn1); // pn3에 "first"라는 이름으로 pn1 담기
		pn3.add("second", pn2); // 카드 형태처럼 pn3에 pn1,pn2를 뒤에 겹친것임
		btnGo = new Button("ok");
		btnGo.addActionListener(this); // 버튼 이벤트 감지
		pn4.add(pn3); // pn4: flowlayout
		pn4.add(btnGo);
		
		super.add(pn4); // Frame에 panel4를 담기
		
		
		// 두번째 행 디자인
		pn5.setLayout(new BorderLayout()); // pn5: FlowLayout => BorderLayout
		pn5.setBackground(new Color(123, 123, 123));
		pn5.add("East", new Label("kbs"));
		pn5.add("West", new Label("mbc"));
		pn5.add("South", new Label("sbs"));
		pn5.add("North", new Label("ytn"));
		pn5.add("Center", new Label("tvn"));
		
		
		super.add(pn5);
		
		super.setTitle("레이아웃 연습");
		super.setBounds(200, 200, 400, 300);
		super.setVisible(true);
		
		super.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				
			}
		});
	}
	
	@Override
		public void actionPerformed(ActionEvent e) {
			// 버튼 이벤트 처리 메소드
			// 버튼을 클릭하면 pn1과 pn2를 교체
			//System.out.println("good");
		//	System.out.println(e.getActionCommand()); // 버튼의 라벨인 ok가 출력결과로 찍힘
		if(e.getActionCommand().equalsIgnoreCase("ok")) {
			btnGo.setLabel("go");
			card.show(pn3, "second"); // pn3에 담긴 pn2를 보여줘
		}else {
			btnGo.setLabel("ok");
			card.show(pn3, "first"); //pn3에 담긴 pn1 보여줘
		}
	// 버튼을 클릭할때마다 버튼의 라벨이 ok였다가 go였다가 계속 반복적으로 바뀜
	}
	
	public static void main(String[] args) {
		new Ex43FrameLayout();

	}
	}