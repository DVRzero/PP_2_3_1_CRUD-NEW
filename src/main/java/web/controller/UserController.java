package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;
    private String Model;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    };

    @GetMapping(value = "/")
    public String showUser(Model model) {
        model.addAttribute("user", userService.showUserName());;
        return "index";
    }
}
