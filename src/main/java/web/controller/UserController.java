package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;

    @Autowired
    UserController(UserService userService){
        this.userService = userService;
    };

    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAllUsers());
        return "all_users";
    }

    @GetMapping("/add")
    public String addNewUser(Model model) {
        model.addAttribute("user", new User());
        return "add_user";
    }

    @PostMapping("/saveUser")
    public String saveNewUser(@ModelAttribute("user")  @Valid User user,
                              BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/add_user";
        }
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/updateUser")
    public String getEditUserForm(Model model, @RequestParam("id") long id) {
        model.addAttribute("user", userService.getUserById(id));
        return "edit_user";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") @Valid  User user,
                           BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/edit_user";
        }
        userService.updateUser(user);
        return "redirect:/";
    }

    @RequestMapping("/deleteUser")
    public String removeUser(@RequestParam("id") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
