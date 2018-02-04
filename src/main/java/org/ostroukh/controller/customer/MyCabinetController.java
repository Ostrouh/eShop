package org.ostroukh.controller.customer;

import org.ostroukh.model.entity.Cart;
import org.ostroukh.model.entity.Credential;
import org.ostroukh.model.entity.User;
import org.ostroukh.model.service.CredentialService;
import org.ostroukh.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@SessionAttributes({"cart"})
@RequestMapping("/customer")
public class MyCabinetController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MyCabinetController.class);
    private int id = 0;
    @Autowired
    UserService userService;

    @Autowired
    CredentialService credentialService;

    @RequestMapping("/cabinet")
    public String getCabinet(@ModelAttribute("cart") Cart cart, ModelMap model){
        User user = userService.getUserById(cart.getUser().getId()).get();

        model.addAttribute("currentUser", user);


        return "customer/cabinet";
    }

    @RequestMapping("/cabinet/update")
    public String updateUserData(@Valid @ModelAttribute("currentUser") User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "customer/cabinet";
        }
        user.insertId(id);
        Credential credential = user.getCredential();
        credential.insertId(id);
        credentialService.saveCredential(credential);
        userService.saveUser(user);
        this.id = 0;


        return "redirect:/customer/cabinet";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable("id") int id, ModelMap model){
        Optional<User> userOptional = userService.getUserById(id);
        if (userOptional.isPresent()) {
            User user =  userOptional.get();
            Credential credential = user.getCredential();

            model.addAttribute("currentUser", user);
            model.addAttribute("credentials", credential);
            this.id = id;
        } else {
            return "customer/cabinet";
        }
        return "customer/cabinet";
    }
}
