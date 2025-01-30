package com.dani.JUnit_first_steps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.dani.JUnit_first_steps.Calculator;

@DisplayName("Tests for Calculator class")
public class CalculatorTest {

        private static Calculator calculator;

        @BeforeEach
        void setup() {
                calculator = new Calculator();
        }

        // teste[System Under Test Name_Condition or Stage Change_Expected Result]
        @Test
        @DisplayName("Test 1.5 + 1.2 = 2.7")
        public void testSum_When_OneDotFiveAddedByOneDotTwo_ShouldReturnTwoDotSeven() {

                // Given || Arrange
                double firstNumber = 1.5D;
                double secondNumber = 1.2D;
                double expected = 2.7D;
                double unexpected = 3.0;

                // When || Act
                Double actual = calculator.sum(firstNumber, secondNumber);

                // Then || Assert
                assertEquals(expected, actual,
                                () -> "The sum of " + firstNumber + " and " + secondNumber + " should be " + expected);
                // colocando o () -> a message só será executada se o teste falhar

                assertNotEquals(unexpected, actual,
                                () -> "The sum of " + firstNumber + " and " + secondNumber + " should not be "
                                                + unexpected);

                assertNotNull(actual,
                                () -> "The sum should not be null");

        }

        @Test
        @DisplayName("Test 5.7 - 3.2 = 2.5")
        void testSubtraction_When_ThreeDotTwoSubtratedFromFiveDotSeven_ShouldReturnTwoDotFive() {

                // Given || Arrange
                double firstNumber = 5.7D;
                double secondNumber = 3.2D;
                double expected = 2.5D;
                double unexpected = 2.0D;

                // When || Act
                Double actual = calculator.subtraction(firstNumber, secondNumber);

                // Then || Assert
                assertEquals(expected, actual,
                                () -> "The subtraction of " + firstNumber + " and " + secondNumber + " should be "
                                                + expected);

                assertNotEquals(unexpected, actual,
                                () -> "The subtraction of " + firstNumber + " and " + secondNumber
                                                + " should not be " + unexpected);

                assertNotNull(actual,
                                () -> "The subtraction should not be null");

        }

        @Test
        @DisplayName("Test 2.0 * 12.2 = 24.4")
        void testMultiplication_When_TwoDotZeroMultiplicatedByTwelveDotTwo_ShouldReturnTwentyFour() {

                // Given || Arrange
                double firstNumber = 2.0D;
                double secondNumber = 12.2D;
                double expected = 24.4D;
                double unexpected = 24.0D;

                // When || Act
                Double actual = calculator.multiplication(firstNumber, secondNumber);

                // Then || Assert
                assertEquals(expected, actual,
                                () -> "The multiplication of " + firstNumber + " and " + secondNumber + " should be "
                                                + expected);
                assertNotEquals(unexpected, actual,
                                () -> "The multiplication of " + firstNumber + " and " + secondNumber
                                                + " should not be " + unexpected);

                assertNotNull(actual,
                                () -> "The multiplication should not be null");

        }

        @Test
        @DisplayName("Test 20.0 / 2.5 = 8.0")
        void testDivision_When_TwentyDotZeroDividedByTwoDotFive_ShouldReturnEightDotZero() {

                // Given || Arrange
                double firstNumber = 20.0D;
                double secondNumber = 2.5D;
                double expected = 8.0D;
                double unexpected = 7.5D;

                // When || Act
                Double actual = calculator.division(firstNumber, secondNumber);

                // Then || Assert
                assertEquals(expected, actual,
                                () -> "The division of " + firstNumber + " and " + secondNumber + " should be "
                                                + expected);

                assertNotEquals(unexpected, actual,
                                () -> "The division of " + firstNumber + " and " + secondNumber
                                                + " should not be " + unexpected);

                assertNotNull(actual,
                                () -> "The division should not be null");

        }

        @Test
        @DisplayName("Test 20.0 / 0 = Throw ArithmeticException")
        void testDivision_When_TwentyDotZeroDividedByZero_ShouldThrowArithmeticException() {

                // Given || Arrange
                double firstNumber = 20.0D;
                double secondNumber2 = 0.0D;
                String expectedMesage = "Impossible to divide by zero!";

                // When || Act && Then || Assert
                ArithmeticException actual = assertThrows(ArithmeticException.class,
                                () -> {
                                        calculator.division(firstNumber, secondNumber2);
                                },
                                () -> "The division by zero should throw an exception");

                assertEquals(expectedMesage, actual.getMessage(),
                                () -> "The exception message should be " + expectedMesage);
        }

        @Test
        @DisplayName("Test (20.0 + 10.0) / 2 = 15.0")
        void testMean_TwentyDotZeroAddedTenDotZeroDividedByTwoDotZero_ShouldReturnFifteenDotZero() {

                // Given || Arrange
                double firstNumber = 20.0D;
                double secondNumber = 10.0D;
                double expected = 15.0D;
                double unexpected = 10.0D;

                // When || Act
                Double actual = calculator.mean(firstNumber, secondNumber);

                // Then || Assert
                assertEquals(expected, actual,
                                () -> "The mean of " + firstNumber + " and " + secondNumber + " should be "
                                                + expected);

                assertNotEquals(unexpected, actual,
                                () -> "The mean of " + firstNumber + " and " + secondNumber
                                                + " should not be " + unexpected);

                assertNotNull(actual,
                                () -> "The mean should not be null");

        }

        @Test
        @DisplayName("Test square root of 25.0 = 5.0")
        void testSquareRoot_When_SquareRootOfTwentyFive_ShouldReturnFiveDotZero() {

                // Given || Arrange
                double number = 25.0D;
                double expected = 5.0D;
                double unexpected = 3.0D;

                // When || Act
                Double actual = calculator.squareRoot(number);

                // Then || Assert
                assertEquals(expected, actual,
                                () -> "The square root of " + number + " should be "
                                                + expected);

                assertNotEquals(unexpected, actual,
                                () -> "The square root of " + number + " should not be " + unexpected);

                assertNotNull(actual,
                                () -> "The square root should not be null");

        }

        // como desabilitiar um teste
        @Disabled("TODO: Implement this test")
        @Test
        @DisplayName("Fail Test")
        void failTest() {
                fail("This test should fail");
        }

}
