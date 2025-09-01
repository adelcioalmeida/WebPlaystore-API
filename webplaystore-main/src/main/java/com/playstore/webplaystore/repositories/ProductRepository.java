package com.playstore.webplaystore.repositories;

import com.playstore.webplaystore.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
