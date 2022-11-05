package bookstore.demo;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class WishListController {
    private WishListService wlserv;

    @Autowired
    public WishListController(WishListService wlserv) {
        this.wlserv=wlserv;
    }

    @GetMapping ("/wishlists/{u_email}")
    public static List<WishList> getWishListByUser(@PathVariable String u_email) {
        List <WishList> wishlists = WishList.getAllWishLists();
        List <WishList> selection = new ArrayList<>();
        for (WishList w: wishlists) {
            if (w.getWl_username().toLowerCase().equals(u_email.toLowerCase()))
                selection.add(w);
        }
        return selection;
    }

    @PostMapping ("/wishlists/create")
    public void createWishList(@RequestBody WishList w) {
        wlserv.createWishList(w);
    }

    @PatchMapping("wishlists/add/{wl_name}")
    public void addBook(@RequestBody BookTemp temp, @PathVariable String wl_name) {
        wlserv.addBook(wl_name,temp.getData());
    }
}
