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

public class PaymentProcessorTest {

    @DisplayName("Test mock construction empty")
    @Test
    void testMockConstructionEmpty() {

        try (MockedConstruction<PaymentProcessor> mocked = mockConstruction(PaymentProcessor.class)) {

            // When | Act

            PaymentProcessor paymentProcessor = new PaymentProcessor();
            when(paymentProcessor.chargeCustomer(
                    anyString(),
                    any(BigDecimal.class)))
                    .thenReturn(BigDecimal.TEN);
            

            // Then | Assert
            assertEquals(BigDecimal.TEN, paymentProcessor.chargeCustomer(
                    "42",
                    BigDecimal.valueOf(42)));
        }
    }
}
