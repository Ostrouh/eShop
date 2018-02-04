package org.ostroukh.controller.customer;

import org.ostroukh.model.entity.Cart;
import org.ostroukh.model.entity.CartItem;
import org.ostroukh.model.entity.Order;
import org.ostroukh.model.entity.OrderedProduct;
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

import java.util.ArrayList;
import java.util.List;

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
    public String checkout(@ModelAttribute("cart") Cart cart){
        Order order = new Order();
        order.setStatus(OrderStatus.NEW);
        orderService.saveOrder(order);

        copyCartToOrder(cart, order);

        cartService.clearCart(cart);
        cartService.saveCart(cart);
        orderService.saveOrder(order);

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
        List<OrderedProduct> orderedProducts = new ArrayList<>();
        OrderedProduct orderedProduct;

        List<CartItem> items = cart.getCartItems();

        for (CartItem item: items){
            orderedProduct = new OrderedProduct();
            orderedProduct.setOrder(order);
            orderedProduct.setProduct(item.getProduct());
            orderedProduct.setQuantity(item.getQuantity());

            orderedProducts.add(orderedProduct);

            orderedProductService.saveOrderedProduct(orderedProduct);
            cartItemService.deleteCartItem(item);
        }
        order.setProducts(orderedProducts);
    }
}
