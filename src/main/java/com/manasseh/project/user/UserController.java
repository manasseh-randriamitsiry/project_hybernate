package com.manasseh.project.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
public class UserController {
    @Autowired UserService userService;

    @GetMapping("/user")
    private String getAllUsers(Model model){
        List<User> allUser = userService.listAllUsers();
        model.addAttribute("listUsers",allUser);
        return "users";
    }

    @GetMapping("/user/new")
    private String showNewForm(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("pageTitle","add new user");
        return "user_form";
    }

    @PostMapping("/user/save")
    private String saveUser(User user, RedirectAttributes returnMessage){
        userService.save(user);
        returnMessage.addFlashAttribute("message","insertion successfully");
        return "redirect:/user";
    }

    @GetMapping("/user/edit/{id}")
    private String showEditForm(@PathVariable("id") Integer id, Model model) throws UserNotFoundException {
        User foundUser = userService.getOneUserById(id);
        model.addAttribute("user", foundUser);
        model.addAttribute("pageTitle","Edit user(ID:"+id+")");
        return "user_form";
    }

    @GetMapping("/user/delete/{id}")
    private String deleteUser(@PathVariable("id") Integer id,  RedirectAttributes returnMessage){
        userService.deleteUserById(id);
        returnMessage.addFlashAttribute("message","deleted successfully");
        return "redirect:/user";
    }
}
