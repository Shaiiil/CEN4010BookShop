package bookstore.demo;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class AuthorService {
    public void createAuthor(Author a) {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        try {
            connection = DriverManager.getConnection(database, user, password);
            String test = "INSERT INTO author(auth_fname,auth_lname,auth_bio,publisher)" +
                    "VALUES (?,?,?,?)";
            PreparedStatement prep = connection.prepareStatement(test);

            prep.setString(1,a.getAuth_fname());
            prep.setString(2, a.getAuth_lname());
            prep.setString(3,a.getAuth_bio());
            prep.setString(4,a.getPublisher());

            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
    }
}
