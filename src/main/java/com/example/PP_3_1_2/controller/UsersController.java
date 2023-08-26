package com.example.PP_3_1_2.controller;

import com.example.PP_3_1_2.model.User;
import com.example.PP_3_1_2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    @GetMapping("/create")
    public String newUser(Model model) {
        model.addAttribute("user", new User());

        return "create-user";
    }

    @PostMapping(value = "/save")
    public String createUser(@ModelAttribute("user") User user) {
        userService.add(user);

        return "redirect:/users";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "update-user";
    }

    @PostMapping(value = "/updateUser/{id}")
    public String updateUser(@PathVariable("id") long id, @ModelAttribute("user") User user) {
        userService.updateUser(id, user);

        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);

        return "redirect:/users";
    }
}
