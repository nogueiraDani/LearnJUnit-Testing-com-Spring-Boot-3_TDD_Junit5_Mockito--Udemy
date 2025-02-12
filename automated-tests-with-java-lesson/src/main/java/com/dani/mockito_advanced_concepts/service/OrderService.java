package com.dani.mockito_advanced_concepts.service;

import java.time.LocalDateTime;
import java.util.UUID;

import com.dani.mockito_advanced_concepts.model.Order;

public class OrderService {

    // simulando um sistema legado
    public Order createOrder(String id, Long amount, String productName) {

        Order order = new Order();

        order.setId(id == null ? UUID.randomUUID().toString() : id);
        order.setCreationDate(LocalDateTime.now());
        order.setAmount(amount);
        order.setProductName(productName);

        return order;

    }

}
