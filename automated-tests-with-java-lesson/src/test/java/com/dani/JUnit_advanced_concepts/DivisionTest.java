package com.dani.JUnit_advanced_concepts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.dani.JUnit_first_steps.Calculator;

public class DivisionTest {

    private static Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    //@MethodSource("testDivisionInputParameters") // informa o metodo para realizar o input de parametros
    @DisplayName("Test 20.0 / 2.5 = 8.0")
    @ParameterizedTest // diz q o teste é parametrizado
    @MethodSource // sem parametro, o metodo deve ter o mesmo nome do teste, no caso testDivision
    void testDivision(double firstNumber, double secondNumber, double expected) {

        // When || Act
        Double actual = calculator.division(firstNumber, secondNumber);

        // Then || Assert
        assertEquals(expected, actual, 2D, // 2D é a precisão do double
                () -> "The division of " + firstNumber + " and " + secondNumber + " should be "
                        + expected);

    }

    // metodo para fornecer os parametros para o teste quando ele é informado no @MethodSource
    // public static Stream<Arguments> testDivisionInputParameters() {
    
    public static Stream<Arguments> testDivision() {
        return Stream.of(
                Arguments.of(20.0, 2.5, 8.0),
                Arguments.of(10.0, 2.0, 5.0),
                Arguments.of(71.0, 14.0, 5.07),
                Arguments.of(18.3, 3.1, 5.90)
                );
    }

}
