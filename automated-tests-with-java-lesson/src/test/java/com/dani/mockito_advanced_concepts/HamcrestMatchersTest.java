package com.dani.mockito_advanced_concepts;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HamcrestMatchersTest {

    @DisplayName("Test for descovery hamcrest matchers")
    @Test
    void testDescoveryHamcrestMatchers() {
        // Given | Arrange
        List<Integer> list = Arrays.asList(10, 11, 12, 13, 14, 15);

        // When | Act & Then | Assert
        assertThat(list, hasSize(6));
        assertThat(list, hasItems(11, 12));
        assertThat(list, everyItem(greaterThan(9)));
        assertThat(list, everyItem(lessThan(16)));

        // Check Strings
        assertThat("", is(emptyString()));
        assertThat(null, is(emptyOrNullString()));

        // Arrays
        Integer[] array = { 1, 2, 3 };
        assertThat(array, arrayWithSize(3));
        assertThat(array, arrayContaining(1, 2, 3));
        
    }

}
