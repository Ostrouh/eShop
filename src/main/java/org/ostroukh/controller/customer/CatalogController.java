package org.ostroukh.controller.customer;

import org.ostroukh.model.entity.Cart;
import org.ostroukh.model.entity.CartItem;
import org.ostroukh.model.entity.Product;
import org.ostroukh.model.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/customer")
@SessionAttributes({"cart"})
public class CatalogController {

    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private CartService cartService;

    @Autowired
    private CartItemService cartItemService;

    @Autowired
    private UserService userService;

    @Autowired
    CredentialService credentialService;

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String getCatalog(@ModelAttribute("cart") Cart cart, ModelMap model) {
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", productService.getAllProducts());

        return "customer/catalog";
    }

    @RequestMapping("/addProductToCart/{id}")
    public String addProductToCart(@PathVariable("id") int id,
                                   @ModelAttribute("cart") Cart cart) {


        Product product = productService.getProductById(id).get();

        CartItem cartItem = new CartItem(product, cart, 1);

        List<CartItem> cartItems = cart.getCartItems();

        if (cartItems.contains(cartItem)) {
            int i = cartItems.indexOf(cartItem);
            cartItem.setQuantity(cartItem.getQuantity() + 1);
            cartItems.set(i, cartItem);
        }
        cartItems.add(cartItem);

        cartItemService.saveCartItem(cartItem);


        cart.setCartItems(cartItems);

        return "redirect:/customer/catalog";
    }
}
