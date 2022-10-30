package bookstore.demo;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class CreditService {

    public void createCard(CreditCard card) {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        try {
            connection = DriverManager.getConnection(database, user, password);
            String test = "INSERT INTO card(card_num,CVV2,c_fname,c_minit,c_lname,c_street,c_city,c_zip,c_state)" +
                    "VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement prep = connection.prepareStatement(test);

            prep.setString(1,card.getCardNum());
            prep.setString(2,card.getCVV2());
            prep.setString(3,card.getFirstName());
            prep.setString(4,card.getMiddleInitial());
            prep.setString(5,card.getLastName());
            prep.setString(6,card.getCardStreet());
            prep.setString(7,card.getCardCity());
            prep.setString(8,card.getCardZip());
            prep.setString(9,card.getCardState());

            prep.executeUpdate();


            String test1 = "INSERT INTO registers(c_user,c_num) VALUES (?,?)";
            PreparedStatement prep1 = connection.prepareStatement(test1);

            prep1.setString(1,card.getCardUser());
            prep1.setString(2,card.getCardNum());

            prep1.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
    }
}
