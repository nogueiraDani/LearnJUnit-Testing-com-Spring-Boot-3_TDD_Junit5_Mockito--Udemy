package com.dani.JUnit_first_steps;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

public class PerformaceTest {

    @Test
    @Timeout(2) // testanto em 2 * segundos *
    //@Timeout(value = 20, unit = java.util.concurrent.TimeUnit.MILLISECONDS) // testando em 20 * milisegundos *
    void testPerformance() {

        int[] array = { 10, 12, 1, 5, 7 };

        // for criado só para simular um teste de performance
        for (int i = 0; i < 100000000; i++) {
            array[0] = i;
            Arrays.sort(array);
        }
    }

}
