package db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CSVToDatabase {

    public static void main(String[] args) {
        String csvFilePath = "C:/work/jsou/test/src/main/webapp/book.csv";  // CSV 파일 경로
        String jdbcUrl = "jdbc:mariadb://localhost:3306/bookie?useUnicode=true&characterEncoding=UTF-8"; // JDBC URL
        String jdbcUser = "root"; // 데이터베이스 사용자명
        String jdbcPassword = "123"; // 데이터베이스 비밀번호

        try {
            // MariaDB JDBC 드라이버 등록
            Class.forName("org.mariadb.jdbc.Driver");

            // 데이터베이스 연결
            Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);

            // CSV 파일 읽기 및 데이터베이스 삽입
            insertCSVToDatabase(csvFilePath, connection);

            // 데이터베이스 연결 종료
            connection.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertCSVToDatabase(String csvFilePath, Connection connection) {
        String insertSQL = "INSERT INTO book (bnum, title, author, publisher, pyear, thumb_nail) VALUES (?, ?, ?, ?, ?, ?)";
        int bnum = 1; // bnum 시작 값

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath, StandardCharsets.UTF_8))) {
            String line;
            int lineNumber = 0;

            while ((line = br.readLine()) != null) {
                lineNumber++;

                // 첫 번째 줄은 헤더이므로 건너뜁니다.
                if (lineNumber == 1) continue;

                String[] values = parseCSVLine(line);

                if (values.length >= 5) {
                    try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
                        // 데이터 길이 확인 및 잘라내기
                        String title = new String(values[1].trim().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
                        if (title.length() > 40) title = title.substring(0, 40);
                        String author = new String(values[2].trim().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
                        if (author.length() > 40) author = author.substring(0, 40);
                        String publisher = new String(values[3].trim().getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
                        if (publisher.length() > 10) publisher = publisher.substring(0, 10);
                        String pyearStr = values[4].trim().replaceAll("[^0-9]", ""); // 연도 필드에서 숫자 이외의 문자 제거
                        String thumb_nail = "";  // 임시 값으로 빈 문자열 사용

                        if (isValidInteger(pyearStr)) {
                            int pyear = Integer.parseInt(pyearStr);

                            preparedStatement.setInt(1, bnum);
                            preparedStatement.setString(2, title);
                            preparedStatement.setString(3, author);
                            preparedStatement.setString(4, publisher);
                            preparedStatement.setInt(5, pyear);
                            preparedStatement.setString(6, thumb_nail);
                            preparedStatement.executeUpdate();
                            bnum++; // bnum 값 증가
                        } else {
                            System.err.println("Invalid year at line " + lineNumber + ": " + line);
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("Invalid line format at line " + lineNumber + ": " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isValidInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // CSV 줄을 적절하게 파싱하기 위한 메서드
    public static String[] parseCSVLine(String line) {
        String[] result = new String[6];
        StringBuilder currentValue = new StringBuilder();
        boolean inQuotes = false;
        int fieldIndex = 0;

        for (char c : line.toCharArray()) {
            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                result[fieldIndex++] = currentValue.toString().trim();
                currentValue.setLength(0);
            } else {
                currentValue.append(c);
            }
        }
        result[fieldIndex] = currentValue.toString().trim();

        return result;
    }
}
