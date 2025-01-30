package com.dani.JUnit_advanced_concepts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import com.dani.JUnit_first_steps.Calculator;

public class SubtractionTest {

    public static Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @DisplayName("Test subtraction method with: [firstNumber] - [secondNumber] = [expected]")
    @ParameterizedTest
    // parametrizando valores pelo @CsvFileSource, um
    // arquivo externo tipo .csv (Excel)
    @CsvFileSource(resources = "../resources/subtractionTest.csv")
    void testSubtraction(double firstNumber, double secondNumber, double expected) {

        // Act
        Double actual = calculator.subtraction(firstNumber, secondNumber);

        // Assert
        assertEquals(expected, actual);

    }
}
