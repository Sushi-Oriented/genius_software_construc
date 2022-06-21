package com.fourtitude.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fourtitude.product.exception.RecordNotFoundException;
import com.fourtitude.product.model.ProductEntity;
import com.fourtitude.product.service.ProductService;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductService service;

    // Get all products
    @GetMapping("/products")
    public ResponseEntity<List<ProductEntity>> getAllProduct() {
        return ResponseEntity.ok().body(service.getAllProducts());
    }

    // Get single Product
    @RequestMapping(value="/product", method = RequestMethod.GET)
    public ProductEntity getProduct(@RequestParam("id") Long id) throws RecordNotFoundException {
        return service.getProductById(id);
    }

    // Add new product
    @PostMapping("/product")
    public String createOrUpdateProduct(ProductEntity product) {
        System.out.println("createOrUpdateProduct ");
        service.createOrUpdateProduct(product);
        return "add-edit-product";
    }

    // Update existing product
//    @PutMapping("/product/{id}")
    @RequestMapping(value="/product", method = RequestMethod.PUT)
    public String editProductById(Model model, @RequestParam("id") Optional<Long> id)
            throws RecordNotFoundException {

        System.out.println("editProductById " + id);
        if (id.isPresent()) {
            ProductEntity entity = service.getProductById(id.get());
            service.createOrUpdateProduct(entity);
            model.addAttribute("product", entity);
			service.createOrUpdateProduct(entity);
        } else {
			ProductEntity entity = new ProductEntity();
            model.addAttribute("product", new ProductEntity());
			service.createOrUpdateProduct(entity);
        }

        return "ResponseEntity.ok().body(this.service.updateProduct(service))";
    }

    // Delete product
    @DeleteMapping("/product/{id}")
    public String deleteProductById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException {

        System.out.println("deleteProductById" + id);

        service.deleteProductById(id);
        return "Deleted";
    }
}
