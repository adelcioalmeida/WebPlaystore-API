package com.playstore.webplaystore.resources;

import com.playstore.webplaystore.entities.Category;
import com.playstore.webplaystore.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryResources {

    private final CategoryRepository repo;

    public CategoryResources(CategoryRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Category> findAll() { return repo.findAll(); }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Category create(@RequestBody Category c) { return repo.save(c); }
}
