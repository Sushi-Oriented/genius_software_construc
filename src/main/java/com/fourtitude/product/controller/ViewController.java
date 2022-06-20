package com.fourtitude.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewController {
    @RequestMapping("/")
    public String viewProducts() {
       return "list-products";
    }

    @RequestMapping("/add-product")
    public String addProduct() {
        return "add-edit-product";
    }

    @RequestMapping(value = "/edit-product", params = "id")
    public String editProduct() {
        return "add-edit-product";
    }
}
