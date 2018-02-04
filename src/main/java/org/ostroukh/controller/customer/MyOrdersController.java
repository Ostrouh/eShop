package org.ostroukh.controller.customer;

import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.OrderedProduct;
import org.ostroukh.model.entity.User;
import org.ostroukh.model.service.OrderService;
import org.ostroukh.model.service.OrderedProductService;
import org.ostroukh.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class MyOrdersController {

    @Autowired
    UserService userService;

    @Autowired
    OrderedProductService orderedProductService;

    @Autowired
    OrderService orderService;

    @RequestMapping("/orders")
    public String getOrderList(ModelMap model){
        UserDetails principal = getPrincipal();
        User user = userService.getUserByLogin(principal.getUsername());

        model.addAttribute("order", new Order());
        model.addAttribute("ordersList", orderService.getOrdersByUser(user));

        return "customer/my_orders";
    }

    @RequestMapping("orders/details/{id}")
    public String removeFromCart(@PathVariable("id") int id, ModelMap model) {
        Order order = orderService.getOrderById(id).get();
        model.addAttribute("orderedProduct", new OrderedProduct());
        model.addAttribute("productsList", order.getProducts());

        return "customer/order_details";
    }

    private UserDetails getPrincipal(){
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (userDetails instanceof UserDetails){
            return (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } else return null;
    }
}

