package org.ostroukh.controller.admin;

import org.ostroukh.model.entity.Product;
import org.ostroukh.model.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class CatalogManagementController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CatalogManagementController.class);

    //костыль для метода editProduct()
    //т.к. не передает id в model
    private int id = 0;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/catalog", method = RequestMethod.GET)
    public String listProducts(ModelMap model){
        model.addAttribute("product", new Product());
        model.addAttribute("listProducts", productService.getAllProducts());

        return "admin/catalog_mng";
    }

    @RequestMapping(value = "/catalog/add", method = RequestMethod.POST)
    public String addProduct(@Valid @ModelAttribute("product") Product product, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "admin/catalog_mng";
        }
        product.insertId(id);
        productService.saveProduct(product);
        this.id = 0;

        return "redirect:/admin/catalog";
    }

    @RequestMapping("/editProduct/{id}")
    public String editProduct(@PathVariable("id") int id, ModelMap model){
        Optional<Product> optional = productService.getProductById(id);
        if (optional.isPresent()) {
            Product product = optional.get();
            model.addAttribute("product", product);
            this.id = id;
        } else {
            return "admin/catalog_mng";
        }
        model.addAttribute("listProducts", productService.getAllProducts());

        return "admin/catalog_mng";
    }

    @RequestMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") int id, ModelMap model){
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
}
