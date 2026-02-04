package org.example.product_service.controller;

import org.example.product_service.domain.Product;
import org.example.product_service.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable UUID id) {
        return service.getProduct(id);
    }

    @GetMapping("/health")
    public String health() {
        return "Product service is running";
    }
}
