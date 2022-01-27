package com.tul.ecommerce.repository;

import com.tul.ecommerce.model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Repository for the Order entity.
 */
public interface OrderRepository extends CrudRepository<Order, UUID> {
}