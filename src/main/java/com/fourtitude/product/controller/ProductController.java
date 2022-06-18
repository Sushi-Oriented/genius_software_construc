package com.fourtitude.product.controller;

import java.util.List;
import java.util.Optional;

import com.fourtitude.product.exception.RecordNotFoundException;
import com.fourtitude.product.model.ProductEntity;
import com.fourtitude.product.service.ProductService;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ProductController {
    @Autowired
    ProductService service;

    // @RequestMapping
    @GetMapping("/products")
    // public String getAllProducts(Model model) {
    public ResponseEntity<List<ProductEntity>> getAllProduct() {
        // System.out.println("getAllProducts");
        // List<ProductEntity> list = service.getAllProducts();
        // model.addAttribute("products", list);
        // return "list-products";
        return ResponseEntity.ok().body(service.getAllProducts());
    }

    // @RequestMapping(path = "/createProduct", method = RequestMethod.POST)
    @PostMapping("/products")
	public String createOrUpdateProduct(ProductEntity product) {
		System.out.println("createOrUpdateProduct ");
		service.createOrUpdateProduct(product);
		return "redirect:/";
	}

    // @RequestMapping(path = { "/edit", "/edit/{id}" })
    @PutMapping("/edit/{id}")
    public String editProductById(Model model, @PathVariable("id") Optional<Long> id)
            throws RecordNotFoundException {

        System.out.println("editProductById" + id);
        if (id.isPresent()) {
            ProductEntity entity = service.getProductById(id.get());
            model.addAttribute("product", entity);
        } else {
            model.addAttribute("product", new ProductEntity());
        }

        return "add-edit-product";
    }

    // @RequestMapping(path = "/delete/{id}")
    @DeleteMapping("/delete/{id}")
	public String deleteProductById(Model model, @PathVariable("id") Long id)
			throws RecordNotFoundException {

		System.out.println("deleteProductById" + id);

		service.deleteProductById(id);
		return "redirect:/";
	}
}
