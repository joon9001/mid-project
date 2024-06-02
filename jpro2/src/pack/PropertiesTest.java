package pack;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) {
		// properties 파일 읽기
		/*
Properties 란?
Properties는 HashMap의 구버전인 Hashtable을 상속받아 구현한 것으로, 
Hashtable은 키와 값을 (Object, Object)의 형태로 저장하는데 비해 
Properties는 (String, String)형태로 저장하는 보다 단순화된 컬렉션 클래스이다.
주로 애플리케이션의 환경설정과 관련된 속성을 저장하는데 사용되며 데이터를 파일로부터 
읽고 쓰는 편리한 기능을 제공한다.

1. 데이터를 저장하는데 사용되는 setProperty()는 단순히 Hashtable의 put메서드를 호출함.
2. setProperty()는 기존에 같은 키로 저장된 값이 있는 경우 그 값을 Object타입으로 반환하며, 그렇지 않을 경우 null을 반환함.
3. getProperty()는 properties에 저장된 값을 읽어오는 일을 하는데 만일 읽어오려는 키가 존재하지 않으면 지정된 기본값을 반환함.
4. Properties는 컬렉션프레임워크 이전의 구버전이기 때문에 Iterator가 아닌 Enumeration을 사용함.
5. list()를 이용하면 Properties에 저장된 모든 데이터를 화면 또는 파일에 편리하게 출력할 수 있음.
		 */
		
		Properties prop = new Properties();
				try {
					prop.load(new FileInputStream("C:\\work\\jsou\\jpro2\\src\\pack\\ex.properties"));
					System.out.println(prop.getProperty("mes1"));
					System.out.println(prop.getProperty("mes2"));
				} catch (Exception e) {
					System.out.println("err : " + e);
					
				}
	}
}
