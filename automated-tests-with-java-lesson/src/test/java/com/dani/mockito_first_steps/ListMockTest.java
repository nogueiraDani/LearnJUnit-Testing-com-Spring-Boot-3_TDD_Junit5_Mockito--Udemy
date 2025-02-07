package com.dani.mockito_first_steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ListMockTest {

    List<?> list;

    @BeforeEach
    void setUp() {

        list = mock(List.class);
    }

    @DisplayName("Test List using Mockito, testing size 10")
    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturn10() {

        // Given | Arrange

        // when(list.size()).thenReturn(10);
        given(list.size()).willReturn(10);

        // When | Act && Then | Assert
        //assertEquals(10, list.size());
        assertThat(list.size(), is(10));

    }

    @DisplayName("Test List using Mockito, testing size variable")
    @Test
    void testMockingList_When_SizeIsCalled_ShouldReturnMultipleValues() {

        // Given | Arrange

        //when(list.size()).thenReturn(10).thenReturn(15).thenReturn(20);
        given(list.size()).willReturn(10, 15, 20);

        // When | Act && Then | Assert

        //assertEquals(10, list.size());
        //assertEquals(15, list.size());
        //assertEquals(20, list.size());
        assertThat(list.size(), in(Arrays.asList(10, 15, 20)));

    }

    @DisplayName("Test List using Mockito, testing size variable")
    @Test
    void testMockingList_When_GetIsCalled_ShouldReturnDani() {

        // Given | Arrange

        var list = mock(List.class);
        //when(list.get(0)).thenReturn("Dani");
        given(list.get(0)).willReturn("Dani");

        // When | Act && Then | Assert

        //assertEquals("Dani", list.get(0));
        assertThat(list.get(0), is("Dani"));
        //assertNull(list.get(1));
        assertThat(list.get(1), is(nullValue()));

    }

    @DisplayName("Test List using Mockito, testing size variable")
    @Test
    void testMockingList_When_GetIsCalled_With_ArgumentMatcher_ShouldReturnDani() {

        // Given | Arrange

        var list = mock(List.class);
        //when(list.get(anyInt())).thenReturn("Dani");
        given(list.get(anyInt())).willReturn("Dani");

        // When | Act && Then | Assert

        //assertEquals("Dani", list.get(0));
        assertThat(list.get(0), is("Dani"));
        //assertNotNull(list.get(1));
        assertThat(list.get(1), is("Dani"));

    }

}
