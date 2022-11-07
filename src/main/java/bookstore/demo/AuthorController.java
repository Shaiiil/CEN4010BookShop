package bookstore.demo;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthorController {
    private AuthorService auth_serv;

    @Autowired
    public AuthorController(AuthorService auth_serv) {
        this.auth_serv=auth_serv;
    }

    @GetMapping ("/author/{author}")
    public static Author getAuthorByName(@PathVariable String author) {
        List <Author> authors = Author.getAllAuthors();
        for (Author a : authors) {
            if ((a.getAuth_fname()+a.getAuth_lname()).toLowerCase().equals(author.toLowerCase()))
                return a;
        }
        return null;
    }


    @PostMapping("/author/create")
    public void createAuthor(@RequestBody Author a) {
        auth_serv.createAuthor(a);
    }
}
