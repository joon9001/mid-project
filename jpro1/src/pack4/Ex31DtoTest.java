// https://cafe.daum.net/flowlife/HqLo/22 몸풀기 문제
package pack4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex31DtoTest {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ArrayList<Ex31StudentDTO> students = new ArrayList<Ex31StudentDTO>();
		// 입력 받기
		
			while (true) {
				try {
				System.out.print("이름을 입력하세요 ");
				String name = scanner.next();
				System.out.print("국어 점수를 입력하세요: ");
				int koreanScore = scanner.nextInt();
				System.out.print("영어 점수를 입력하세요: ");
				int englishScore = scanner.nextInt();

				// Ex31StudentDTO 객체 생성 및 컬렉션에 추가
				Ex31StudentDTO student = new Ex31StudentDTO(name, koreanScore, englishScore);
				students.add(student);

				System.out.print("계속할까요? (y/n): ");
				String continueInput = scanner.next();

				if (!continueInput.equalsIgnoreCase("y")) {
					break;

				}
			}
		 catch (Exception e) {
			System.out.println("처리 중 오류 발생: " + e);
			break;
		}
	}
		// 테이블 형식으로 출력
		System.out.println("이름\t국어\t영어\t총점");
		for (Ex31StudentDTO student : students) {
			System.out.println(student.getName() + "\t" + student.getKoreanScore() + "\t" + student.getEnglishScore()
					+ "\t" + student.getTotalScore());
		}
		System.out.println("응시 인원 : " + students.size() + "명");
	}
}
