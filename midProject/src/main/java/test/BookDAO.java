package test;

import java.awt.print.Book;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookDAO {

    private Connection connection;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;

    public void getConnection() {
        String url = "jdbc:mariadb://localhost:3306/test";
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root", "123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insertData(Book book) {
        String SQL = "insert into task2(title,price,publisher,authors,discountPrice,ISBN) values(?,?,?,?,?,?)";
        getConnection();
        int cnt = 1;
        try {
            preparedStatement=connection.prepareStatement(SQL);
            preparedStatement.setString(1,book.getTitle());
            preparedStatement.setInt(2,book.getPrice());
            preparedStatement.setString(3,book.getPublisher());
            preparedStatement.setObject(4,book.getAuthors().get(0));
            preparedStatement.setInt(5,book.getDiscountPrice());
            preparedStatement.setString(6,book.getISBN());
            cnt = preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbclose();
        }
        return cnt;
    }

    public void findAllBookList() throws Exception {
        String SQL = "select * from task2 order by title";
        getConnection();
        int cnt = 1;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                String title = resultSet.getString("title");
                int price = resultSet.getInt("price");
                String publisher = resultSet.getString("publisher");
                int discountPrice = resultSet.getInt("discountPrice");
                String authors = resultSet.getString("authors");
                String ISBN = resultSet.getString("ISBN");
                System.out.println(title + " | " + price + " | " + discountPrice + " | " + authors + " | " + ISBN);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbclose();
        }
    }
    public void dbclose() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

