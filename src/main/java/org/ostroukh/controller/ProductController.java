package org.ostroukh.controller;

import org.ostroukh.model.entity.Product;
import org.ostroukh.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping("/catalog")
    public String listProducts(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", productService.getAllProducts());

        return "catalog_management";
    }

    @RequestMapping("catalog/add")
    public String addProduct(@ModelAttribute("product") Product product){
        productService.saveProduct(product);

        return "redirect:/catalog";
    }

    @RequestMapping("editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, Model model){
        Optional<Product> optional = productService.getProductById(id);
        if (optional.isPresent()) {
            model.addAttribute("product", optional.get());
        } else {
            return "catalog_management";
        }
        model.addAttribute("listProducts", productService.getAllProducts());

        return "catalog_management";
    }
}
