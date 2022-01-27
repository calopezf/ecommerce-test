package com.tul.ecommerce.repository;


import com.tul.ecommerce.model.OrderProduct;
import com.tul.ecommerce.model.OrderProductPK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repository for the OrderProduct entity.
 */
public interface OrderProductRepository extends JpaRepository<OrderProduct, OrderProductPK> {
}