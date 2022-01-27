package com.tul.ecommerce.service;

import com.tul.ecommerce.model.Product;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * Service Interface for managing {@link Product}.
 */
@Validated
public interface ProductService {

    /**
     * Save a product.
     *
     * @param product the entity to save.
     * @return the persisted entity.
     */
    Product save(Product product);

    /**
     * Get all the products.
     *
     * @return the list of entities.
     */
    List<Product> findAll();


    /**
     * Get the "id" product.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<Product> findOne(UUID id);

    /**
     * Delete the "id" product.
     *
     * @param id the id of the entity.
     */
    void delete(UUID id);
}