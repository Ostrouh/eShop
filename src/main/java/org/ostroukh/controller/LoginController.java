package org.ostroukh.controller;

import org.ostroukh.model.entity.Cart;
import org.ostroukh.model.service.CartService;
import org.ostroukh.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@SessionAttributes({"cart"})
@Controller
public class LoginController {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);


    @Autowired
    UserService userService;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    CartService cartService;

    @ModelAttribute("cart")
    public Cart cartInit(){
        return new Cart();
    }

    @RequestMapping("/login")
    public String getLogin(){
        return "login";
    }

    @RequestMapping("/welcome")
    public String welcomePage(ModelMap model) {
        UserDetails user = getPrincipal();

        String page = "access_denied";

        if (user != null) {
            String username = user.getUsername();
            model.addAttribute("user", username);
            model.addAttribute("cart", userService.getUserByLogin(user.getUsername()).getCart());

            switch (user.getAuthorities().toArray()[0].toString()) {
                case "ROLE_ADMIN":
                    page = "admin/admin";
                    LOGGER.info(username + "Successfully logged in as ADMIN");
                    break;
                case "ROLE_CUSTOMER":
                    page = "customer/customer";
                    LOGGER.info(username + "Successfully logged in as CUSTOMER");

                    break;
                default:
                    break;
            }

        }

        return page;
    }

    private UserDetails getPrincipal(){
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (userDetails instanceof UserDetails){
            return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } else return null;
    }

    @RequestMapping(value = "/access_denied")
    public String accessDeniedPage() {
        LOGGER.info("Authorization failure");
        return "access_denied";
    }
}
