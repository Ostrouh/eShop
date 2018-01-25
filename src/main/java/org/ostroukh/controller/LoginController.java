package org.ostroukh.controller;

import org.ostroukh.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
    @Autowired
    UserService userService;

    @Autowired
    UserDetailsService userDetailsService;

    @RequestMapping("/login")
    public String getLogin(){
        return "login";
    }

    @RequestMapping("/welcome")
    public String welcomePage(ModelMap model) {
        UserDetails user = getPrincipal();

        String page = "access_denied";

        if (user != null) {
            model.addAttribute("user", user.getUsername());

            switch (user.getAuthorities().toArray()[0].toString()) {
                case "ROLE_ADMIN":
                    page = "admin/admin";
                    break;
                case "ROLE_CUSTOMER":
                    page = "customer/customer";
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
        return "access_denied";
    }
}
