package bookstore.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {
    private UserService user_serv;

    @Autowired
    public UserController(UserService user_serv) {
        this.user_serv=user_serv;
    }
    @GetMapping ("/users/{u_email}")
    public static User getUserByUserEmail(@PathVariable String u_email) {
        List <User> users = User.getAllUsers();
        for (User u : users) {
            if (u.getUserEmail().toLowerCase().equals(u_email.toLowerCase()))
                return u;
        }
        throw new UserNotFoundException(u_email);
    }

    @PostMapping ("/users/create")
    public void createUser(@RequestBody User u) {
        user_serv.createUser(u);
    }

    @PatchMapping("users/update/extra/{u_email}")
    public void updateUserExtraEmail(@RequestBody UserTempData temp, @PathVariable String u_email) {
        user_serv.updateUserExtraEmail(u_email,temp.getData());
    }

    @PatchMapping("users/update/first/{u_email}")
    public void updateUserFirstName(@RequestBody UserTempData temp, @PathVariable String u_email) {
        user_serv.updateUserFirstName(u_email,temp.getData());
    }

    @PatchMapping("users/update/middle/{u_email}")
    public void updateUserMiddleName(@RequestBody UserTempData temp, @PathVariable String u_email) {
        user_serv.updateUserMiddleName(u_email,temp.getData());
    }

    @PatchMapping("users/update/last/{u_email}")
    public void updateUserLastName(@RequestBody UserTempData temp, @PathVariable String u_email) {
        user_serv.updateUserLastName(u_email,temp.getData());
    }

    @PatchMapping("users/update/password/{u_email}")
    public void updateUserPassword(@RequestBody UserTempData temp, @PathVariable String u_email) {
        user_serv.updateUserPassword(u_email,temp.getData());
    }

    @PatchMapping("users/update/street/{u_email}")
    public void updateUserStreet(@RequestBody UserTempData temp, @PathVariable String u_email) {
        user_serv.updateUserStreet(u_email,temp.getData());
    }

    @PatchMapping("users/update/city/{u_email}")
    public void updateUserCity(@RequestBody UserTempData temp, @PathVariable String u_email) {
        user_serv.updateUserCity(u_email,temp.getData());
    }

    @PatchMapping("users/update/zip/{u_email}")
    public void updateUserZip(@RequestBody UserTempData temp, @PathVariable String u_email) {
        user_serv.updateUserZip(u_email,temp.getData());
    }

    @PatchMapping("users/update/state/{u_email}")
    public void updateUserState(@RequestBody UserTempData temp, @PathVariable String u_email) {
        user_serv.updateUserState(u_email,temp.getData());
    }
}
