package com.fourtitude.product.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ViewController {
    @RequestMapping("/")
    public String viewProducts() {
       return "list-products";
    }

    @RequestMapping("/add")
    public String addProducts() {
       return "add-edit-product";
    }
}
