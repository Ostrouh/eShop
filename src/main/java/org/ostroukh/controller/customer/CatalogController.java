package org.ostroukh.controller.customer;

import org.ostroukh.model.entity.Cart;
import org.ostroukh.model.entity.Product;
import org.ostroukh.model.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping("/customer")
@SessionAttributes("cart")
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

    @ModelAttribute
    public Cart cartInit(){
        Cart cart = new Cart();

        return cart;
    }

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String getCatalog(Principal principal, HttpServletRequest request, ModelMap model){
        if (principal != null) {

            Cart cart = cartService.getCartByUser(userService.getUserByLogin(principal.getName()));
            request.getSession().setAttribute("cart", cart);
            System.out.println(cart.getId());
        }

        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", productService.getAllProducts());

        return "customer/catalog";
    }

    @RequestMapping("/addProductToCart/{id}")
    public String addProductToCart(@PathVariable("id") int id,
                                   @ModelAttribute("cart")Cart cart){



        return "redirect:/customer/catalog";
    }
}
