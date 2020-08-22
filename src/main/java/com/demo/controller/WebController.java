package com.demo.controller;

import com.demo.entity.ProductEntity;
import com.demo.repository.ProductRepo;
import com.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class WebController {
    private static ArrayList<ProductEntity> list = new ArrayList<ProductEntity>();
    @Autowired
    private ProductRepo productRepository;
    @Autowired
    ProductService productService;

    @GetMapping({"/home"})
    public String home(Model model) {
        model.addAttribute("name", "T1808A");
        return "home";
    }

    @GetMapping("/addproduct")
    public String openAddProduct(Model model) {
        ProductEntity product = new ProductEntity();
        model.addAttribute("product", product);
        return "product/addproduct";
    }

    @PostMapping("/addproduct")
    public String addProduct(@ModelAttribute ProductEntity product) {
        productService.saveProduct(product);
        return "redirect:/listproduct";
    }

    @GetMapping({"/listproduct", "/"})
    public String getAllProduct(Model model) {
        List<ProductEntity> list = productService.getAll();
        model.addAttribute("products", list);
        return "product/listproduct";
    }

    @GetMapping(value = {"/update/{id}"})
    public String update(Model model, @PathVariable int id) {
        ProductEntity productEntity = productService.findById(id);
        model.addAttribute("product", productEntity);
        return "/product/updateproduct";
    }

    @PostMapping("/update/{id}")
    public String updateContact(Model model,
                                @PathVariable int id,
                                @ModelAttribute("product") ProductEntity productEntity) {
        productEntity.setId(id);
        productService.updateProduct(productEntity);
        return "redirect:/listproduct";
    }
    @GetMapping(value = {"/delete/{id}"})
    public String delete(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/listproduct";
    }

}
