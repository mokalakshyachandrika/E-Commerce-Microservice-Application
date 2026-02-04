package org.example.product_service.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String sku;

    private String name;
    private String description;
    private BigDecimal price;
    private String brand;

    @Enumerated(EnumType.STRING)
    private ProductStatus status;

    @ManyToOne
    private Category category;

    public Product() {}

    public String getSku() {
        return sku;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
