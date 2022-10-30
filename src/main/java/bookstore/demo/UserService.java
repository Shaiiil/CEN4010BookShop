package bookstore.demo;

import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class UserService {
    public void createUser(User u) {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        try {
            connection = DriverManager.getConnection(database, user, password);
            String test = "INSERT INTO user(ufname,umname,ulname,u_email,u_pw,u_extra_email,u_street,u_city,u_zip,u_state)" +
                    "VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement prep = connection.prepareStatement(test);

            prep.setString(1,u.getFirstName());
            prep.setString(2,u.getMiddleName());
            prep.setString(3,u.getLastName());
            prep.setString(4,u.getUserEmail());
            prep.setString(5,u.getUserPw());
            prep.setString(6,u.getUserExtraEmail());
            prep.setString(7,u.getUserStreet());
            prep.setString(8,u.getUserCity());
            prep.setString(9,u.getUserZip());
            prep.setString(10,u.getUserState());

            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
    }

    public void updateUserExtraEmail(String userEmail, String extraEmail) {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        try {
            connection = DriverManager.getConnection(database, user, password);
            String test = "update user set u_extra_email = (?) where u_email = (?);";
            PreparedStatement prep = connection.prepareStatement(test);

            prep.setString(1,extraEmail);
            prep.setString(2,userEmail);
            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
    }

    public void updateUserFirstName(String userEmail, String firstName) {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        try {
            connection = DriverManager.getConnection(database, user, password);
            String test = "update user set ufname = (?) where u_email = (?);";
            PreparedStatement prep = connection.prepareStatement(test);

            prep.setString(1,firstName);
            prep.setString(2,userEmail);
            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
    }

    public void updateUserMiddleName(String userEmail, String midName) {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        try {
            connection = DriverManager.getConnection(database, user, password);
            String test = "update user set umname = (?) where u_email = (?);";
            PreparedStatement prep = connection.prepareStatement(test);

            prep.setString(1,midName);
            prep.setString(2,userEmail);
            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
    }

    public void updateUserLastName(String userEmail, String lastName) {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        try {
            connection = DriverManager.getConnection(database, user, password);
            String test = "update user set ulname = (?) where u_email = (?);";
            PreparedStatement prep = connection.prepareStatement(test);

            prep.setString(1,lastName);
            prep.setString(2,userEmail);
            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
    }

    public void updateUserPassword(String userEmail, String PW) {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        try {
            connection = DriverManager.getConnection(database, user, password);
            String test = "update user set u_pw = (?) where u_email = (?);";
            PreparedStatement prep = connection.prepareStatement(test);

            prep.setString(1,PW);
            prep.setString(2,userEmail);
            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
    }

    public void updateUserStreet(String userEmail, String street) {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        try {
            connection = DriverManager.getConnection(database, user, password);
            String test = "update user set u_street = (?) where u_email = (?);";
            PreparedStatement prep = connection.prepareStatement(test);

            prep.setString(1,street);
            prep.setString(2,userEmail);
            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
    }

    public void updateUserCity(String userEmail, String city) {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        try {
            connection = DriverManager.getConnection(database, user, password);
            String test = "update user set u_city = (?) where u_email = (?);";
            PreparedStatement prep = connection.prepareStatement(test);

            prep.setString(1,city);
            prep.setString(2,userEmail);
            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
    }

    public void updateUserZip(String userEmail, String zip) {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        try {
            connection = DriverManager.getConnection(database, user, password);
            String test = "update user set u_zip = (?) where u_email = (?);";
            PreparedStatement prep = connection.prepareStatement(test);

            prep.setString(1,zip);
            prep.setString(2,userEmail);
            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
    }

    public void updateUserState(String userEmail, String state) {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        try {
            connection = DriverManager.getConnection(database, user, password);
            String test = "update user set u_state = (?) where u_email = (?);";
            PreparedStatement prep = connection.prepareStatement(test);

            prep.setString(1,state);
            prep.setString(2,userEmail);
            prep.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
    }
}