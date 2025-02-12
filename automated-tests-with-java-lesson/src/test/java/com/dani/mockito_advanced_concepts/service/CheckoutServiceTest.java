package com.dani.mockito_advanced_concepts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

public class CheckoutServiceTest {

    // simulando codigo legado, com mock de construtor
    @DisplayName("Test mock object construction")
    @Test
    void testMockObjectConstruction() {
        // Given | Arrange
        try (MockedConstruction<PaymentProcessor> mocked = mockConstruction(PaymentProcessor.class,
                (mock, context) -> {
                    when(mock.chargeCustomer(
                            anyString(),
                            any(BigDecimal.class)))
                            .thenReturn(BigDecimal.TEN);
                })) {

            // When | Act
            CheckoutService service = new CheckoutService();
            BigDecimal result = service.purchaseProduct("celular", "15");

            // Then | Assert
            assertEquals(BigDecimal.TEN, result);
            assertEquals(1, mocked.constructed().size());
        }

    }
}
