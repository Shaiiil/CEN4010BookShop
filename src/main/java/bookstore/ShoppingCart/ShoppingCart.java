package bookstore.ShoppingCart;

import java.util.ArrayList;

import bookstore.BookDetails.*;
import bookstore.BookBrowsingSorting.*;
import bookstore.ShoppingCart.*;

public class ShoppingCart extends Wishlist {

    private String scName;

    public ShoppingCart() {}

    public ShoppingCart(String user, String scName) {
        this.userName = user;
        this.scName = scName;
        books = new ArrayList<Book>();
    }

    public String getScName() {
        return this.scName;
    }

    public void setScName(String scNameName) {
        this.scNameName = scName;
    }
}