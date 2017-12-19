package org.ostroukh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String getIndex(){
        return "/index";
    }

    @RequestMapping("/login")
    public String getLogin(){
        return "login";
    }

}
