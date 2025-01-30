package com.dani.JUnit_advanced_concepts;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import com.dani.JUnit_first_steps.Calculator;

public class SquareRootTest {

    private static Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @DisplayName("Test square root of firstNumber")  
    @ParameterizedTest
    // parametrizando o teste com @ValueSource
    // o metodo só aceita um paramentro por vez usando o value Source
    @ValueSource(doubles = { 4.0, 9.0, 16.0, 25.0, 36.0 }) 
    void testSquareRoot(double firstNumber) {

        // When || Act
        Double actual = calculator.squareRoot(firstNumber);
        System.out.println(actual);

        // Then || Assert
        assertNotNull(actual);
    }
}
