package pack;

import java.util.Scanner;

public class Test8for {

	public static void main(String[] args) {
		 // 반복문 : continue, break
		System.out.println("뭔가를 하다가...");
		
		for(int i=1; i<=10; i++) {
			System.out.println(i);
			if(i == 3) continue; //반복문 for문에만 있는 continue는 아래로 내려가서 System.out.println("금요일")을 출력하지 않고 바로 위로 올라간다해독하지 않고 바로 for문으로 올
			if(i == 5) break; // for문을 바로 빠져나온다.
			if(i == 5) System.exit(0);// break는 for문을 빠져나온 후 아래 문장들이 계속 실행되지만 system.exit은 바로 프로그램이 종료된다.
			System.out.println("금요일");
			}
	    	
		System.out.println();
		int kk = 0;
		for(;;) {
			kk++;
			System.out.println("무한 반복 출력"); //조건문에 break가 없기 때문에 무한 반복에 빠진다.
			if(kk == 10) break; // break 조건문을 추가하였으므로 무한 반복 루프에서 빠져나올 수 있게 된다.
		}
		
		System.out.println();
		kbs: for(int i=1; i<=3; i++) {
			mbc: for(int j=1; j<=5; j++) {
				System.out.println(i + " " + j + " ");
				if(j == 3) continue kbs; // 해당 label로 분
				if(j == 5) break kbs;
			}
		}
		System.out.println("~~~~~~~");
		
	    }
	}



