package org.ostroukh.controller;

import org.ostroukh.model.entity.User;
import org.ostroukh.model.service.CredentialService;
import org.ostroukh.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CredentialService credentialService;

    @RequestMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.getAllUsers());

        return "users";
    }

    @RequestMapping("editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        Optional<User> optional = userService.getUserById(id);
        if (optional.isPresent()) {
            model.addAttribute("user", optional.get());
        } else {
            return "users";
        }
        model.addAttribute("ListUsers", userService.getAllUsers());

        return "users";
    }
}
