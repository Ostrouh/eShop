package org.ostroukh.controller;

import org.ostroukh.model.entity.Credential;
import org.ostroukh.model.entity.Product;
import org.ostroukh.model.entity.User;
import org.ostroukh.model.service.CredentialService;
import org.ostroukh.model.service.OrderService;
import org.ostroukh.model.service.ProductService;
import org.ostroukh.model.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    UserService userService;

    @Autowired
    CredentialService credentialService;

    @Autowired
    OrderService orderService;

    @RequestMapping("/catalog")
    public String listProducts(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", productService.getAllProducts());

        return "admin/catalog_mng";
    }

    @RequestMapping("/catalog/add")
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "admin/catalog_mng";
        }

        productService.saveProduct(product);

        return "redirect:/admin/catalog";
    }

    @RequestMapping("/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        Optional<Product> optional = productService.getProductById(id);
        if (optional.isPresent()) {
            model.addAttribute("product", optional.get());
        } else {
            return "admin/catalog_mng";
        }
        model.addAttribute("listProducts", productService.getAllProducts());

        return "admin/catalog_mng";
    }

    @RequestMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id, Model model){
        Optional<Product> optional = productService.getProductById(id);
        if (optional.isPresent()) {
            Product product = optional.get();
            model.addAttribute("product", product);
            productService.deleteProduct(product);
        } else {
            return "admin/catalog_mng";
        }
        model.addAttribute("listProducts", productService.getAllProducts());

        return "redirect:/admin/catalog";
    }

    @RequestMapping("/users")
    public String getUsers(Model model){
        model.addAttribute("user", new User());
        model.addAttribute("listUsers", userService.getAllUsers());

        return "admin/users_mng";
    }

    @RequestMapping("/editUser/{id}")
    public String editUser(@PathVariable("id") int id, Model model){
        Optional<User> userOptional = userService.getUserById(id);
        if (userOptional.isPresent()) {
            User user =  userOptional.get();
            Credential credential = user.getCredential();

            model.addAttribute("user", user);
            model.addAttribute("credentials", credential);
        } else {
            return "admin/users_mng";
        }
        model.addAttribute("listUsers", userService.getAllUsers());

        return "admin/users_mng";
    }

    @RequestMapping("/users/update")
    public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "admin/users_mng";
        }
        userService.saveUser(user);

        return "redirect:/admin/users";
    }

    @RequestMapping("/orders")
    public String getOrders(Model model){

        return "admin/orders_mng";
    }
}
