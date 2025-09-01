package com.playstore.webplaystore.resources;

import com.playstore.webplaystore.entities.Product;
import com.playstore.webplaystore.repositories.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResources {

    private final ProductRepository repo;

    public ProductResources(ProductRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Product> findAll() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Product create(@RequestBody Product p) { return repo.save(p); }
}
