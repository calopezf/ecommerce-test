package com.tul.ecommerce.repository;

import com.tul.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Repository for the Product entity.
 */
public interface ProductRepository extends JpaRepository<Product, UUID> {
}