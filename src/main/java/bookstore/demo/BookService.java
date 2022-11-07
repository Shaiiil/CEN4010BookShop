package bookstore.demo;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class BookService {
    public void createBook(Book b) {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        try {
            String author = b.getA_fname()+b.getA_lname();
            if (AuthorController.getAuthorByName(author)==null) {
                throw new AuthorNotFoundException(author);
            }
            else {
                connection = DriverManager.getConnection(database, user, password);

                String test = "INSERT INTO book(isbn,bname,bdesc,price,genre,pub_name,yr_pub,copies_sold,rating,a_fname,a_lname)" +
                        "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement prep = connection.prepareStatement(test);

                prep.setString(1, b.getIsbn());
                prep.setString(2, b.getBname());
                prep.setString(3, b.getBdesc());
                prep.setString(4, b.getPrice());
                prep.setString(5, b.getGenre());
                prep.setString(6, b.getPub_name());
                prep.setString(7, b.getYr_pub());
                prep.setString(8, b.getCopies_sold());
                prep.setString(9, b.getRating());
                prep.setString(10, b.getA_fname());
                prep.setString(11, b.getA_lname());

                prep.executeUpdate();
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
    }
}
