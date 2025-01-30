package com.dani.JUnit_advanced_concepts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.dani.JUnit_first_steps.Calculator;

public class SumTest {

    public static Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("Test sum method with: [firstNumber] + [secondNumber] = [expected]")
    @ParameterizedTest
    @CsvSource({ // parametrizando valores pelo @CsvSource, pode ser colocado tbm String se for o
                 // caso do teste
            "1, 2, 3",
            "2, 3, 5",
            "3, 4, 7"
    })
    void testSum(double firstNumber, double secondNumber, double expected) {

        // Act
        Double actual = calculator.sum(firstNumber, secondNumber);

        // Assert
        assertEquals(expected, actual);
    }
}
