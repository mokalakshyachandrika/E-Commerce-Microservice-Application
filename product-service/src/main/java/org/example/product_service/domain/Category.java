package org.example.product_service.domain;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> children;

    public Category() {}

    public Category(String name, Category parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public Category getParent() {
        return parent;
    }
}
