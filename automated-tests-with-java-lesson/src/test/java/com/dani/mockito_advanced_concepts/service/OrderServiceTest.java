package com.dani.mockito_advanced_concepts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import com.dani.mockito_advanced_concepts.model.Order;

public class OrderServiceTest {

    private final OrderService orderService = new OrderService();

    private final UUID defaultUuid = UUID.fromString("f3c56d2b-1a5f-4c3e-80f3-1e0b9a7d2d6c");

    private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(
            2025,
            11,
            2,
            8,
            57);
            
    // ----------------------------------------------------------------
    // mockando metodos estaticos sem parametros
    // ----------------------------------------------------------------

    @DisplayName("Should include random OrderId when no OrderId exists")
    @Test
    void testShouldIncludeRandomOrderId_When_NoOrderExistis() {

        // Given | Arrange
        try (MockedStatic<UUID> mockedUuid = mockStatic(UUID.class)) {

            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);

            // When | Act

            Order result = orderService.createOrder(null, 2L, "celular");

            // Then | Assert
            assertEquals(defaultUuid.toString(), result.getId());

        }
    }

    @DisplayName("Should include current time when create a new order")
    @Test
    void testShouldIncludeCurrentTime_When_CreateANewOrder() {

        // Given | Arrange
        try (MockedStatic<LocalDateTime> mockedLocalDateTime = mockStatic(LocalDateTime.class)) {

            mockedLocalDateTime.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);

            // When | Act
            Order result = orderService.createOrder(null, 2L, "celular");

            // Then | Assert
            assertEquals(defaultLocalDateTime, result.getCreationDate());
        }

    }
}
