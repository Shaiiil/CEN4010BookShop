package bookstore.demo;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class WishListService {
    public void createWishList(WishList w) {
            if (UserController.getUserByUserEmail(w.getWl_username())!=null) {
                Connection connection;
                String user = "root";
                String password = "JumpM@n!";
                String database = "jdbc:mysql://localhost:3306/bookstore";

                try {
                    connection = DriverManager.getConnection(database, user, password);
                    String test = "INSERT INTO wishlist(wl_name,wl_username) VALUES (?,?)";
                    PreparedStatement prep = connection.prepareStatement(test);

                    prep.setString(1, w.getWl_name());
                    prep.setString(2, w.getWl_username());

                    prep.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                    System.out.println("Could not open database.");
                    System.exit(1);
                }
            }
    }

    public void addBook(String wish_name, String ISBN) {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        try {
            connection = DriverManager.getConnection(database, user, password);
            String test = "INSERT into contains_wish(b_isbn,wish_name) VALUES (?,?)";
            PreparedStatement prep = connection.prepareStatement(test);

            prep.setString(1,ISBN);
            prep.setString(2,wish_name);
            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
    }
}