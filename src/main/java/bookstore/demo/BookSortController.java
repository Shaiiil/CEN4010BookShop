package bookstore.demo;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class BookSortController {
    private BookService book_serv;

    @Autowired
    public BookSortController(BookService book_serv) {
        this.book_serv=book_serv;
    }

    @GetMapping ("/books/{genre}")
    List <Book> getBookByGenre(@PathVariable String genre) {
        List <Book> books = Book.getAllBooks();
        List <Book> genreFound = new ArrayList <Book> ();
        for (Book b : books) {
            if (b.getGenre().toLowerCase().equals(genre.toLowerCase())) {
                genreFound.add(b);//Will add book with x genre to array named book genre
            }
        }
        return genreFound;
    }

    @GetMapping("/books/wishlist/{wl_name}")
    public static List<Book> getWishListByWishName(@PathVariable String wl_name) {
        List <Book> books = Book.getWishListByWishName(wl_name);
        return books;
    }


    @GetMapping ("/books/ISBN/{isbn}")
    static List <Book> getBookByISBN(@PathVariable String isbn) {
        List <Book> books = Book.getAllBooks();
        List <Book> isbnFound = new ArrayList <Book> ();
        for (Book b : books) {
            if (b.getIsbn().equals(isbn)) {
                isbnFound.add(b);//Will add book with x genre to array named book isbn
            }
        }
        return isbnFound;
    }

    @GetMapping("/books/shopcart/{user}")
    public static List<Book> getCartByUser(@PathVariable String user) {
        List <Book> books = Book.getShopCartByUser(user);
        return books;
    }

    @GetMapping("/books/rating/{rating}")
    public static List<Book> getBooksByRating(@PathVariable String rating) {
        List <Book> books = Book.getBooksByRating(rating);
        return books;
    }

    @GetMapping("/books/toptenbooks")
    public static List<Book> getTopTenBooks() {
        List <Book> books = Book.getTopTenBooks();
        return books;
    }

    @GetMapping("/books/amount/{amount}")
    public static List<Book> getXBooks(@PathVariable int amount) {
        List <Book> allBooks = Book.getAllBooks();
        List <Book> amountBooks = new ArrayList<>();
        //int temp = Integer.parseInt(amount);
        for (Book b: allBooks) {
            amountBooks.add(b);
            if (amountBooks.size()==amount) break;
        }
        return amountBooks;
    }

    @GetMapping ("/books/author/{author}")
    List <Book> getBooksByAuthor(@PathVariable String author) {
        List <Book> books = Book.getAllBooks();
        List <Book> authorBooks = new ArrayList<Book>();
        for (Book b : books) {
            if ((b.getA_fname()+b.getA_lname()).toLowerCase().equals(author.toLowerCase())) {
                authorBooks.add(b);//Will add book with x genre to array named book genre
            }
        }
        return authorBooks;
    }

    @PostMapping("/books/create")
    public void createBook(@RequestBody Book b) {book_serv.createBook(b);}
}