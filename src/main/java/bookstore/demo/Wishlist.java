package bookstore.demo;

import java.sql.*;
import java.util.ArrayList;

public class WishList {
    private String wl_name;
    private String wl_username;

    public WishList() {}

    public WishList(String wl_name, String wl_username) {
        this.wl_username = wl_username;
        this.wl_name = wl_name;
    }

    public String getWl_name() {
        return this.wl_name;
    }

    public void setWl_name(String wlName) {
        this.wl_name=wlName;
    }

    public String getWl_username() {return this.wl_username;}

    public void setWl_username(String user) {
        this.wl_username = user;
    }


    public static ArrayList<WishList> getAllWishLists() {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        ArrayList<WishList> wishlists = new ArrayList<WishList>();

        try {
            connection = DriverManager.getConnection(database, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT wl_name\r\n"
                            + "    , wl_username\r\n"
                            + "FROM wishlist");

            while (resultSet.next()) {
                WishList temp = new WishList(resultSet.getString("wl_name"), resultSet.getString("wl_username"));
                wishlists.add(temp);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
        return wishlists;
    }
}
