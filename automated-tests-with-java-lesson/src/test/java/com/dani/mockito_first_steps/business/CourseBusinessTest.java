package com.dani.mockito_first_steps.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.dani.mockito_first_steps.service.CourseService;
import com.dani.mockito_first_steps.service.stubs.CourseServiceStub;

public class CourseBusinessTest {

    @Test
    void testCoursesRelatedToSpring_When_UsingAStub() {
        // Given | Arrange
        CourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        // When | Act
        List<String> filteredCourses = business.retrieveCoursesRelatedToWinter("Dani");

        // Then | Assert
        assertEquals(6, filteredCourses.size(), 
                () -> "Expected 6 courses related to Spring");

        // simulando uma regra de negócio que diz q o user José retorno 0 cursos
        filteredCourses = business.retrieveCoursesRelatedToWinter("José");
        assertEquals(0, filteredCourses.size(),
                () -> "Expected 0 courses related to Spring for user José");
    }
}
