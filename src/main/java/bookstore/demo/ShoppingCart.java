package bookstore.demo;

public class ShoppingCart {

    private String cart_name;
    private String cart_username;

    public ShoppingCart() {
    }

    public ShoppingCart(String cart_name, String cart_username) {
        this.cart_name = cart_name;
        this.cart_username = cart_username;
    }

    public String getCart_name() {return this.cart_name;}
    public void setCart_name(String cart_name) {this.cart_name = cart_name;}
    public String getCart_username() {return this.cart_username;}
    public void setCart_username(String cart_username) {this.cart_username = cart_username;}

}