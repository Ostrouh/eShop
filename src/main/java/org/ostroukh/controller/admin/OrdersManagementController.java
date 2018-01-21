package org.ostroukh.controller.admin;

import org.ostroukh.model.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class OrdersManagementController {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrdersManagementController.class);

    @Autowired
    OrderService orderService;

    @RequestMapping("/orders")
    public String getOrders(Model model){

        return "admin/orders_mng";
    }

}
