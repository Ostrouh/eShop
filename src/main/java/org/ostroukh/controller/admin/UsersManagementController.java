package org.ostroukh.controller.admin;

import org.ostroukh.model.entity.Credential;
import org.ostroukh.model.entity.User;
import org.ostroukh.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class UsersManagementController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UsersManagementController.class);

    @Autowired
    UserService userService;

    @RequestMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.getAllUsers());

        return "admin/users_mng";
    }

    @RequestMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        Optional<User> userOptional = userService.getUserById(id);
        if (userOptional.isPresent()) {
            User user =  userOptional.get();
            Credential credential = user.getCredential();

            model.addAttribute("user", user);
            model.addAttribute("credentials", credential);
        } else {
            return "admin/users_mng";
        }
        model.addAttribute("listUsers", userService.getAllUsers());

        return "admin/users_mng";
    }

    @RequestMapping("/users/update")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "admin/users_mng";
        }
        userService.saveUser(user);

        return "redirect:/admin/users";
    }
}
