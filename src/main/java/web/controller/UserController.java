package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImp;
import web.model.User;

@Controller
public class UserController {

    private final UserDaoImp userDaoImp;
    @Autowired
    public UserController(UserDaoImp userDaoImp) {
        this.userDaoImp = userDaoImp;
    }


    @GetMapping(value = "/users")
    public String user(Model model) {
        model.addAttribute("users", userDaoImp.getUsers());
        return "users";
    }
    @GetMapping("user/editView/")
    public String showEditPage(@RequestParam("id") int id, Model model) {
        System.out.println(id);
        model.addAttribute("user", userDaoImp.getUser(id));
        return "update";
    }
    @PostMapping("/users/editDone")
    public String updateUserData(@RequestParam int id, @ModelAttribute User user) {
        User tempUser = userDaoImp.getUser(id);
        if (tempUser != null) {
            userDaoImp.update(id, user);
        }
        else {
            System.out.println("Айди нет((( " + id);
            return "redirect:/users";
        }
        return "redirect:/users";

    }
    @PostMapping(value = "/users/add")
    public String addUser(@ModelAttribute User user) {
        userDaoImp.create(user);
        return "redirect:/users";
    }

    @PostMapping(value = "/users/delete/")
    public String deleteUser(@RequestParam("id") int id) {
        userDaoImp.delete(id);
        return "redirect:/users";
    }

//    @PostMapping(value = "/update")
//    public String updateUser(@RequestParam User user, @ModelAttribute User user1) {
//        userDaoImp.update(user.getId(), user1);
//        return "redirect:/users";
//    }
}
