package org.ostroukh.controller.customer;

import org.ostroukh.model.entity.*;
import org.ostroukh.model.entity.enums.OrderStatus;
import org.ostroukh.model.service.CartItemService;
import org.ostroukh.model.service.CartService;
import org.ostroukh.model.service.OrderService;
import org.ostroukh.model.service.OrderedProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/customer")
@SessionAttributes({"cart"})
public class CartController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @Autowired
    CartItemService cartItemService;

    @Autowired
    CartService cartService;

    @Autowired
    OrderService orderService;

    @Autowired
    OrderedProductService orderedProductService;

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
        cartService.clearCart(cart);
        cartService.saveCart(cart);
        orderService.saveOrder(order);
        status.setComplete();

        return "customer/order_is_processed";
    }

    @RequestMapping("cart/removeFromCart/{id}")
    public String removeFromCart(@PathVariable("id") int id,
                                   @ModelAttribute("cart") Cart cart, ModelMap model) {

        CartItem removingItem = cartItemService.getCartItemById(id).get();
        model.addAttribute("cartItem", removingItem);

        List<CartItem> cartItems = cart.getCartItems();

        cartItems.remove(removingItem);
        cartItemService.deleteCartItem(removingItem);

        cart.setCartItems(cartItems);
        cart.setTotalCost(cartService.getTotalCost(cart));
        cart.setItemsAmount(cartService.getItemsInCart(cart));
        model.addAttribute("listItems", cartItemService.getCartItemsByCart(cart));

        return "redirect:/customer/cart";
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
            orderedProductService.saveOrderedProduct(orderedProduct);
            cartItemService.deleteCartItem(item);
        }
    }
}
