package com.fourtitude.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fourtitude.product.exception.RecordNotFoundException;
import com.fourtitude.product.model.ProductEntity;
import com.fourtitude.product.service.ProductService;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/")
public class ProductController {
    @Autowired
    ProductService service;

    // Return HTML View
    @GetMapping("/test")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("list-products");
        return modelAndView;
    }



	


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

    /* Get Single Products */
    @GetMapping("/product/{id}")
    public ProductEntity getProduct(@PathVariable("id") Long id) throws RecordNotFoundException {
        return service.getProductById(id);
    }

    // @RequestMapping(path = "/createProduct", method = RequestMethod.POST)
    @PostMapping("/products")
    public String createOrUpdateProduct(ProductEntity product) {
        System.out.println("createOrUpdateProduct ");
        service.createOrUpdateProduct(product);
        return "Inserted";
    }

    // @RequestMapping(path = { "/edit", "/edit/{id}" })
    // @PutMapping("/product/{id}")
    // public String editProductById(Model model, @PathVariable("id") Optional<Long> id)
    //         throws RecordNotFoundException {

    //     System.out.println("editProductById" + id);
    //     if (id.isPresent()) {
    //         ProductEntity entity = service.getProductById(id.get());
    //         model.addAttribute("product", entity);
    //     } else {
    //         model.addAttribute("product", new ProductEntity());
    //     }

    //     return ResponseEntity.ok().body(this.service.updateProduct(service));
    // }

	@PutMapping("/products/{id}")
	public ResponseEntity<ProductEntity> updateProduct(@PathVariable long id, @RequestBody ProductEntity product){
		product.setId(id);
		System.out.println(product);
		return ResponseEntity.ok().body(this.service.createOrUpdateProduct(product));
	}

    // @RequestMapping(path = "/delete/{id}")
    @DeleteMapping("/delete/{id}")
    public String deleteProductById(Model model, @PathVariable("id") Long id)
            throws RecordNotFoundException {

        System.out.println("deleteProductById" + id);

        service.deleteProductById(id);
        return "Deleted";
    }
}
