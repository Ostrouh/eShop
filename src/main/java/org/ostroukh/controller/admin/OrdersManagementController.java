package org.ostroukh.controller.admin;

import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.User;
import org.ostroukh.model.service.OrderService;
import org.ostroukh.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class OrdersManagementController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersManagementController.class);
    private int id = 0;
    private int userId = 0;
    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String listProducts(ModelMap model){
        model.addAttribute("order", new Order());
        model.addAttribute("orderList", orderService.getAllOrders());

        return "admin/orders_mng";
    }

    @RequestMapping(value = "editOrder/{id}")
    public String editOrder(@PathVariable("id") int id, ModelMap model){
        Optional<Order> optional = orderService.getOrderById(id);
        if (optional.isPresent()) {
            Order order = optional.get();
            model.addAttribute("order", order);
            this.id = id;
            this.userId = order.getUser().getId();

        } else {
            return "admin/orders_mng";
        }
        model.addAttribute("orderList", orderService.getAllOrders());

        return "admin/orders_mng";
    }

    @RequestMapping(value = "/orders/update", method = RequestMethod.POST)
    public String addProduct(@ModelAttribute("order") Order order){
        order.insertId(id);
        User user = userService.getUserById(userId).get();
        order.setUser(user);
        orderService.saveOrder(order);
        this.id = 0;
        this.userId = 0;

        return "redirect:/admin/orders";
    }

}
