package org.ostroukh.controller;

import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.Product;
import org.ostroukh.model.entity.User;
import org.ostroukh.model.service.CredentialService;
import org.ostroukh.model.service.OrderService;
import org.ostroukh.model.service.ProductService;
import org.ostroukh.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    CredentialService credentialService;

    @Autowired
    OrderService orderService;

    @RequestMapping("/catalog")
    public String getCatalog(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", productService.getAllProducts());

        return "customer/catalog";
    }

    @RequestMapping("/orders")
    public String listProducts(Model model){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUserByLogin(login);
        System.out.println(user.getName());

        model.addAttribute("order", new Order());
        model.addAttribute("listOrders", orderService.getOrdersByUser(user));

        return "customer/my_orders";
    }

    @RequestMapping("/cabinet")
    public String getCabinet(){

        return "customer/my_cabinet";
    }
}
