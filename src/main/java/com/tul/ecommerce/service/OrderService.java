package com.tul.ecommerce.service;

import com.tul.ecommerce.model.Order;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;
import java.util.UUID;

/**
 * Service Interface for managing {@link Order}.
 */
@Validated
public interface OrderService {

    @NotNull Iterable<Order> getAllOrders();

    Optional<Order> findOne(UUID id);

    Order create(@NotNull(message = "The order cannot be null.") @Valid Order order);

    void update(@NotNull(message = "The order cannot be null.") @Valid Order order);
}