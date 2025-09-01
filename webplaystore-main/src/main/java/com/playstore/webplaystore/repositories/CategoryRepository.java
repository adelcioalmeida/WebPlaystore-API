package com.playstore.webplaystore.repositories;

import com.playstore.webplaystore.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
