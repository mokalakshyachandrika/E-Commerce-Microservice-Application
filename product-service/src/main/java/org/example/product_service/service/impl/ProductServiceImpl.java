package org.example.product_service.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.example.product_service.domain.Product;
import org.example.product_service.domain.ProductStatus;
import org.example.product_service.repository.ProductRepository;
import org.example.product_service.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public Product createProduct(Product product) {
        product.setStatus(ProductStatus.ACTIVE);
        return repository.save(product);
    }

    @Override
    @Transactional
    public Product updateProduct(UUID id, Product product) {
        Product existing = getProduct(id);
        existing.setName(product.getName());
        existing.setDescription(product.getDescription());
        existing.setPrice(product.getPrice());
        existing.setBrand(product.getBrand());
        existing.setCategory(product.getCategory());
        return repository.save(existing);
    }

    @Override
    public Product getProduct(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Product not found"));
    }

    @Override
    public Page<Product> listProducts(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    @Transactional
    public void deactivateProduct(UUID id) {
        Product p = getProduct(id);
        p.setStatus(ProductStatus.INACTIVE);
        repository.save(p);
    }
}
