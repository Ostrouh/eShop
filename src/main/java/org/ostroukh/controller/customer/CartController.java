package org.ostroukh.controller.customer;

import org.ostroukh.model.entity.Cart;
import org.ostroukh.model.entity.CartItem;
import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.OrderedProduct;
import org.ostroukh.model.entity.enums.OrderStatus;
import org.ostroukh.model.service.CartItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/customer")
@SessionAttributes({"cart"})
public class CartController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @Autowired
    CartItemService cartItemService;

    @RequestMapping("/cart")
    public String getCart(@ModelAttribute("cart") Cart cart, ModelMap model){
        model.addAttribute("cartItem", new CartItem());
        model.addAttribute("listItems", cartItemService.getCartItemsByCart(cart));

        return "customer/cart";
    }

    @RequestMapping("/checkout")
    public String checkout(@ModelAttribute("cart") Cart cart, SessionStatus status, ModelMap model){
        Order order = new Order();
        order.setStatus(OrderStatus.NEW);

        copyCartToOrder(cart, order);

        status.setComplete();

        return "redirect:/cograts";
    }

    private void copyCartToOrder(Cart cart, Order order){
        order.setUser(cart.getUser());
        order.setTotalCost(cart.getTotalCost());
        Set<OrderedProduct> orderedProductSet = new HashSet<>();
        OrderedProduct orderedProduct = new OrderedProduct();

        for (CartItem item: cart.getCartItems()){
            orderedProduct.setOrder(order);
            orderedProduct.setProduct(item.getProduct());
            orderedProduct.setQuantity(item.getQuantity());

            orderedProductSet.add(orderedProduct);
        }
    }
}
