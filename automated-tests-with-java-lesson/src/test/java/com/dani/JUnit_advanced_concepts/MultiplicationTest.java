package com.dani.JUnit_advanced_concepts;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import com.dani.JUnit_first_steps.Calculator;

public class MultiplicationTest {

    Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // não precisa do @Test e nem pode passar paramentros pelo @CsvSource no
    // @RepeatedTest. Por isso informei os valores dentro do metodo.
    // O RepetitionInfo é um objeto que contém informações sobre a repetição atual
    // e o total de repetições.
    // O TestInfo é um objeto que contém informações sobre o teste atual.

    // assim só informa a quantidade de repetiçoes
    //@RepeatedTest(5) 

    // assim informa a quantidade de repetiçoes e o nome do teste com as variaveis
    @RepeatedTest(value = 5, name = "Multiplication repetition {currentRepetition} of {totalRepetitions}")
    void testMultiplication(
            RepetitionInfo repetitionInfo,
            TestInfo testInfo) {

        double actual = calculator.multiplication(2.0, 5.0);

        System.out.println(
                "Repetition: " + repetitionInfo.getCurrentRepetition() + " of " + repetitionInfo.getTotalRepetitions());

        System.out.println("Test: " + testInfo.getTestMethod().get().getName());

        assertEquals(10.0, actual);

    }
}
