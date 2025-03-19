package jdbc;

import java.sql.*;
import java.util.ArrayList;

public class MySQLDemo {
    Statement stmt;

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        System.out.println("MySQL Demo");
        MySQLDemo demo = new MySQLDemo();
        demo.openDB();

        ArrayList<Book> books=demo.getBooks();
        System.out.println(books);

        System.out.println();
        demo.addBook("Junglebogen", 1948);
        books=demo.getBooks();
        for (Book book : books) { System.out.println(book); }

        System.out.println();
        demo.deleteBook("Junglebogen");
        books=demo.getBooks();
        for (Book book : books) { System.out.println(book); }

    }

    void openDB() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver OK");
        Connection connection= DriverManager.getConnection(
                "jdbc:mysql://localhost/books_db",
                "bjorn",
                "bjch"
        );
        System.out.println("Connection OK");
        stmt = connection.createStatement();
        System.out.println("Statement OK");
    }

    ArrayList<Book> getBooks() throws SQLException {
        ArrayList<Book> books=new ArrayList<>();
        ResultSet res=stmt.executeQuery("SELECT * FROM books");
        while(res.next()) {
            Book book=new Book(
                    res.getInt("ID"),
                    res.getString("TITLE"),
                    res.getInt("YEAR"));
            books.add(book);
        }
        return books;
    }

    void addBook(String title, int year) throws SQLException {
        String sql = "INSERT INTO books (title, year) VALUES "+
                "('"+title+"','"+year+"')";
        System.out.println(sql);
        stmt.executeUpdate(sql);
    }

    void deleteBook(String title) throws SQLException {
        String sql = "DELETE FROM books WHERE title = '"+title+"'";
        System.out.println(sql);
        stmt.executeUpdate(sql);
    }
}
