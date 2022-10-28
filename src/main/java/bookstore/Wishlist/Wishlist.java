package bookstore.Wishlist;
import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import bookstore.BookDetails.*;
import bookstore.BookBrowsingSorting.*;
import bookstore.ShoppingCart.*;

public class Wishlist {

    private String wlName;
    protected String userName;

    public ArrayList<bookstore.BookDetails.Book> books;

    public Wishlist() {}

    public Wishlist(String user, String wlName) {
        this.userName = user;
        this.wlName = wlName;
        books = new ArrayList<bookstore.BookDetails.Book>();
    }

    public String getWlName() {
        return this.wlName;
    }

    public void setWlName(String wlName) {
        this.wlName = wlName;
    }

    public String getUser() {
        return this.userName;
    }

    public void setUser(String user) {
        this.userName = user;
    }




}
