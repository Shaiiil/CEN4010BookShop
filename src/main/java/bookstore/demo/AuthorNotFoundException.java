package bookstore.demo;

public class AuthorNotFoundException extends RuntimeException {
    AuthorNotFoundException(String author) {
        super("Could not find any author with name " + author);
    }
}
