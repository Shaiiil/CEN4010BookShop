package bookstore.demo;

import java.sql.*;
import java.util.ArrayList;

public class Author {
        private String auth_fname;

        private String auth_lname;

        private String auth_bio;

        private String publisher;

        //base constructor
        public Author() {}

        public Author(String auth_fname, String auth_lname, String auth_bio, String publisher) {
            this.auth_fname = auth_fname;
            this.auth_lname = auth_lname;
            this.auth_bio = auth_bio;
            this.publisher = publisher;
        }

    public String getAuth_fname() {
        return auth_fname;
    }

    public void setAuth_fname(String auth_fname) {
        this.auth_fname = auth_fname;
    }

    public String getAuth_lname() {
        return auth_lname;
    }

    public void setAuth_lname(String auth_lname) {
        this.auth_lname = auth_lname;
    }

    public String getAuth_bio() {return auth_bio;}

    public void setAuth_bio(String auth_bio) {
        this.auth_bio = auth_bio;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public static ArrayList<Author> getAllAuthors() {
        Connection connection;
        String user = "root";
        String password = "JumpM@n!";
        String database = "jdbc:mysql://localhost:3306/bookstore";

        ArrayList<Author> authors = new ArrayList<Author>();

        try {
            connection = DriverManager.getConnection(database, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(
                    "SELECT auth_fname\r\n"
                            + "    , auth_lname\r\n"
                            + "    , auth_bio\r\n"
                            + "    , publisher\r\n"
                            + "FROM author");

            while (resultSet.next()) {
                Author temp = new Author(resultSet.getString("auth_fname"), resultSet.getString("auth_lname"),
                        resultSet.getString("auth_bio"), resultSet.getString("publisher"));
                authors.add(temp);
            }

        }
        catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Could not open database.");
            System.exit(1);
        }
        return authors;
    }
}
