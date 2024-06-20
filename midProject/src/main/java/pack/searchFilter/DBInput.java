package pack.searchFilter;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DBInput {
//키보드 입력 또는 출력 등 외부 장치를 사용해야하는 객체 클래스를 쓸때는 무조건 예외처리를 해줘야 한다.
	public static void main(String[] args) throws Exception{
		// console과 file을 통한 입력
		// 1. console을 통한 입력
		/*
		InputStreamReader in = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(in);
		System.out.println("이름은");
		String ir = br.readLine();
		System.out.println("이름은 " + ir);
		br.close(); // InputStreamReader 닫기
		in.close(); // BufferedReader 닫기
		*/
		
		// 2. Scanner를 통한 입력
		/*
		Scanner scanner = new Scanner(System.in);
		System.out.println("이름은");
		String ir = scanner.nextLine();
		System.out.println("몸무게는");
		double w = scanner.nextDouble();
		System.out.println(ir + "님의 몸무게는" + w);
		scanner.close();
		*/
		// 파일 읽기
//		File f = new File("c:/work/good.txt");
//		File f = new File("c:\\work\\bookie.txt");
//		// 문자 단위
//		FileReader fr = new FileReader(f);
//		BufferedReader br = new BufferedReader(fr);
//		//System.out.println(br.readLine());
//		while(true) {
//			String ss = br.readLine();
//			if(ss == null) break;
//			System.out.println(ss);
//		}
//		fr.close(); // Garbage collector(GC)로 하여금 점유 메모리 해제 요청
//		br.close();
		
		System.out.println("전국 도서관 정보 파일 일부 읽기 ----------");
		File file = new File("c:/work/bookie.csv");

		 // UTF-8 인코딩으로 BufferedReader 생성
        	BufferedReader br2 = new BufferedReader(new InputStreamReader(
                new FileReader(file), StandardCharsets.UTF_8));
		int count = 0;
		String ss = br2.readLine();
		while(true) {
			count++;
			ss = br2.readLine();
			if(ss == null || count > 10) break;
			StringTokenizer tok = new StringTokenizer(ss, ",");
			String s1 = tok.nextToken();
			String s2 = tok.nextToken();
			String s3 = tok.nextToken();
			String s4 = tok.nextToken();
			String s5 = tok.nextToken();
		
			
			System.out.println(s1 + "\t" + s2 +  "\t" + s3 + 
					"\t" + s4 + "\t" + s5 + "\t");
		}
		System.out.println("건수 : " + count);
	}

}
