package com.dani.mockito_first_steps;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ExceptionsMockTest {

    @DisplayName("Test Excepetions using Mockito")
    @Test
    void testMockingList_When_ThrownsAnException() {
        // Given | Arrange
        var list = mock(List.class);

        // When | Act
        //when(list.get(anyInt())).thenThrow(new RuntimeException("Something went wrong"));
        given(list.get(anyInt())).willThrow(new RuntimeException("Something went wrong"));

        // Then | Assert
        assertThrows(RuntimeException.class,
                () -> list.get(anyInt()),
                () -> "Should throw an exception with the message 'Something went wrong'");
    }

}
