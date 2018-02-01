package org.ostroukh.controller.customer;

import org.ostroukh.model.entity.Cart;
import org.ostroukh.model.entity.CartItem;
import org.ostroukh.model.entity.Product;
import org.ostroukh.model.service.CartItemService;
import org.ostroukh.model.service.CartService;
import org.ostroukh.model.service.CredentialService;
import org.ostroukh.model.service.ProductService;
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
    private CartItemService cartItemService;

    @Autowired
    CredentialService credentialService;

    @Autowired
    CartService cartService;

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
            int i = cartItems.indexOf(cartItem); 					//индекс в списке из корзины
            cartItem = cartItems.get(i);							//теперь cartItem из корзины, у него есть ID

            cartItem.setQuantity(cartItem.getQuantity() + 1);		//обновляем количество товаров
            cartItems.set(i, cartItem);								//сетаем в список новое значение

            cartItemService.saveCartItem(cartItem);					//обновляем в базе

        } else {
            cartItems.add(cartItem);								//иначе добавляем в список
            cartItemService.saveCartItem(cartItem);					//сохраняем в базу
        }


        cart.setCartItems(cartItems);								//сетаем список в корзину
        cart.setTotalCost(cartService.getTotalCost(cart));
        cart.setItemsAmount(cartService.getItemsInCart(cart));

        return "redirect:/customer/catalog";
    }
}
