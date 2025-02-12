package com.dani.mockito_advanced_concepts.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mockStatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class GreetingTest {

    @DisplayName("Should mock static with params")
    @Test
    void shouldMockStaticWithParams() {
        try (MockedStatic<Greeting> mockedStatic = mockStatic(Greeting.class)) {
            // Given | Arrange
            mockedStatic.when(
                    () -> Greeting.getGreeting(
                            eq("Dani"),
                            anyBoolean()))
                    .thenReturn("Howdy Dani");
            String result = Greeting.getGreeting("Dani", false);

        // When | Act
        // Then | Assert
        assertEquals("Howdy Dani", result);
        
        }

    }
}
