package pack5io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

//이 코드는 이진 데이터를 처리하는 Java 프로그램이다.
//주어진 기능을 통해 객체를 직렬화하여 파일에 저장하고, 
//다시 파일에서 역직렬화하여 객체로 읽어오는 과정을 수행한다

public class Ex36DataProcess {

	public static void main(String[] args) throws Exception{
		// 이진 데이터 처리
	
		Ex36BinaryData binaryData = new Ex36BinaryData();
		
		// 저장
		//File f = new File("c:/work/iotest3.dat"); 아래 2줄과 동일하다
		File dir = new File("c:/work/");
		File file = new File(dir, "iotest3.dat");
		
		FileOutputStream fo = new FileOutputStream(file);
		BufferedOutputStream bo = new BufferedOutputStream(fo, 1024);
		ObjectOutputStream oo = new ObjectOutputStream(bo); //ObjectOutputStream = 직렬화
		oo.writeObject(binaryData);
		oo.close(); bo.close(); fo.close();
		System.out.println("저장 성공");  // File(dir, "iotest3.dat")이 직렬화되어 저장됨
		//읽기
		File file2 = new File("c:/work/iotest3.dat"); 
		// 직렬화되어 저장된 File("iotest3.dat")불러와 객체로 만들기
		FileInputStream fis = new FileInputStream(file2);
		BufferedInputStream bi = new BufferedInputStream(fis, 1024);
		ObjectInputStream oi = new ObjectInputStream(bi); 
		//직렬화된 객체를 역직렬화 // ObjectInputStream = 역직렬화
		Object obj = oi.readObject(); 
		//바이트에서 객체로 역직렬화된 oi의 객체 내용을 읽어 obj에 저장
		Ex36BinaryData data = (Ex36BinaryData)obj;
		//object 타입의 객체를 Ex36BinaryData 객체 타입으로 강제형변환
		System.out.println(data.a);
		System.out.println(data.b);
		System.out.println(data.ss1);
		System.out.println(data.ss2);
		oi.close(); bi.close(); fis.close();
		}
		
	}


