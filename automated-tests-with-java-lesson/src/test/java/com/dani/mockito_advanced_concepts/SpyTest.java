package com.dani.mockito_advanced_concepts;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class SpyTest {

    @Spy
    List<String> mockitoArrayList;

    @DisplayName("Test Spy Concepts")
    @Test
    void testSpyConcepts1() {
        // Given | Arrange

        // When | Act & Then | Assert

        assertEquals(0, mockitoArrayList.size());

        when(mockitoArrayList.size()).thenReturn(5);
        mockitoArrayList.add("Dani");

        assertEquals(5, mockitoArrayList.size());
    }

    @DisplayName("Test Spy Concepts")
    @Test
    void testSpyConcepts2() {
        // Given | Arrange

        List<String> spyArrayList = spy(ArrayList.class);

        // When | Act & Then | Assert

        assertEquals(0, spyArrayList.size());

        spyArrayList.add("Dani");
        assertEquals(1, spyArrayList.size());

        spyArrayList.remove("Dani");
        assertEquals(0, spyArrayList.size());
    }

    @DisplayName("Test Spy Concepts")
    @Test
    void testSpyConcepts3() {
        // Given | Arrange

        List<String> spyArrayList = spy(ArrayList.class);

        // When | Act & Then | Assert

        assertEquals(0, spyArrayList.size());

        when(spyArrayList.size()).thenReturn(5);

        assertEquals(5, spyArrayList.size());

    }

    @DisplayName("Test Spy Concepts")
    @Test
    void testSpyConcepts4() {
        // Given | Arrange

        List<String> spyArrayList = spy(ArrayList.class);

        // When | Act & Then | Assert
        spyArrayList.add("Dani");

        verify(spyArrayList).add("Dani");
        // verify(spyArrayList, never()).remove("Dani");
        verify(spyArrayList, never()).remove(anyString());

        verify(spyArrayList, never()).clear();

    }

}
