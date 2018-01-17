//package org.ostroukh.controller;
//
//import org.ostroukh.model.entity.Credential;
//import org.ostroukh.model.entity.User;
//import org.ostroukh.model.service.CredentialService;
//import org.ostroukh.model.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import javax.validation.Valid;
//import java.util.Optional;
//
//@Controller
//public class UserController {
//
//    @Autowired
//    UserService userService;
//
//    @Autowired
//    CredentialService credentialService;
//
//    @RequestMapping("/users")
//    public String getUsers(Model model){
//        model.addAttribute("user", new User());
//        model.addAttribute("listUsers", userService.getAllUsers());
//
//        return "admin/users_management";
//    }
//
//    @RequestMapping("/sign-up")
//    public String registration(Model model){
//        model.addAttribute("userForm", new User());
//
//        return "registration";
//    }
//
//    @RequestMapping(value = "/sign-up", method = RequestMethod.POST)
//    public String registration(@Valid @ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            return "registration";
//        }
//
//        userService.saveUser(userForm);
//        return "redirect:/catalog_management";
//    }
//
//    @RequestMapping("editUser/{id}")
//    public String editUser(@PathVariable("id") int id, Model model){
//        Optional<User> userOptional = userService.getUserById(id);
//        if (userOptional.isPresent()) {
//            User user =  userOptional.get();
//            Credential credential = user.getCredential();
//
//            model.addAttribute("user", user);
//            model.addAttribute("credentials", credential);
//        } else {
//            return "admin/users_management";
//        }
//        model.addAttribute("listUsers", userService.getAllUsers());
//
//        return "admin/users_management";
//    }
//
//    @RequestMapping("/users/update")
//    public String updateUser(@ModelAttribute("user") User user, BindingResult bindingResult){
//        if (bindingResult.hasErrors()){
//            return "admin/users_management";
//        }
//        System.out.println(user.getCredential().getEmail());
//        System.out.println(user.getCredential().getCreatedAt());
//        System.out.println(user.getCredential().getId());
//        userService.saveUser(user);
//
//        return "redirect:/users";
//    }
//
//
//}
