package web.bootstrap.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.bootstrap.demo.models.User;
import web.bootstrap.demo.services.UserService;

import java.security.Principal;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showAllUsers(Model model, Principal principal) {
        User user = userService.findUserByEmail(principal.getName());
//        model.addAttribute("logout", userService.findUserByEmail(principal.getName()));
        model.addAttribute("user", user);
        model.addAttribute("roles", user.getRoles());
        return "user/index";
    }
}
