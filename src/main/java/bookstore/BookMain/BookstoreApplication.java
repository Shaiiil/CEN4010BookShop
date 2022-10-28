package bookstore.BookMain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import bookstore.BookDetails.*;
import bookstore.BookBrowsingSorting.*;
import bookstore.ShoppingCart.*;


@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(bookstore.BookMain.BookstoreApplication.class, args);

    }

}