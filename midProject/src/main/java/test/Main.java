package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final KakaoAPI kakaoAPI = new KakaoAPI();

    public static void Main(String[] args) throws Exception {
        ArrayList<Book> booklist = searchBookList();
        saveBooksList(booklist);
        scanner.close();
    }
    private static ArrayList<Book> searchBookList() throws IOException {
        System.out.print("키워드를 입력하세요: ");
        String keyword = scanner.nextLine();
        ArrayList<Book> booklist = null;

        if (!keyword.isEmpty()) {
            System.out.println("도서 제목 " + " | " + "가격 " + " | " + "출판사 " + " | " + "작가 " + " | " + "할인 가격 " + " | " + "ISBN");
            booklist = kakaoAPI.findBookListByKeyword(keyword);
        } else {
            System.out.println("키워드가 빈 값 입니다.");
        }
        return booklist;
    }

    private static void saveBooksList(ArrayList<Book> booklist) throws Exception {
        if (booklist.size() != 0) {
            System.out.println("데이터베이스에 저장하시겠습니까? Y/N");
            String answerSaveDB = scanner.next();
            if (answerSaveDB.equals("Y")) {
                System.out.println("저장 시작");
                BookDAO dao = new BookDAO();
                for (int i = 0; i < booklist.size(); i++) {
                    int cnt = dao.insertData(booklist.get(i));
                    if (cnt > 0) {
                        System.out.println("저장성공 " + (i + 1));
                    } else {
                        System.out.println("저장실패");
                    }
                }
                System.out.println("[TABLE LIST]");
                System.out.println("도서 제목 " + " | " + "가격 " + " | " + "출판사 " + " | " + "작가 " + " | " + "할인 가격 " + " | " + "ISBN");
                dao.findAllBookList();
            } else {
                System.out.println("저장하지 않고 종료");
            }
        } else {
            System.out.println("조회 서비스를 종료합니다.");
        }
    }


}
