package com.dani.JUnit_first_steps;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class ArraysCompareTest {

    @Test
    void testArrayEquals() {

        int[] numbers = {12, 3, 4, 1};
        int[] expected = { 1, 3, 4, 12 };

        Arrays.sort(numbers);
        
        // compara las referencias dos objetos e nao o conteudo
        //assertEquals(expected, numbers); 

        // compara o conteudo dos arrays
        assertArrayEquals(expected, numbers);
    }

}
