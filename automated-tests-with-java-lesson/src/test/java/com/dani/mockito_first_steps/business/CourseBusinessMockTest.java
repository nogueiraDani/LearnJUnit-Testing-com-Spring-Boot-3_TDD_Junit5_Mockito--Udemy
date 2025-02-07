package com.dani.mockito_first_steps.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dani.mockito_first_steps.service.CourseService;

public class CourseBusinessMockTest {

    CourseService mockService;
    CourseBusiness business;
    List<String> courses;

    @BeforeEach
    void setUp() {
        // Given | Arrange
        mockService = mock(CourseService.class); // mockando a interface CourseService
        business = new CourseBusiness(mockService);
        courses = Arrays.asList( // passando uma lista de cursos
                "Spring",
                "Spring Boot",
                "Spring MVC",
                "Spring Security",
                "Spring Data JPA",
                "Spring Cloud",
                "Rest APIs",
                "Microservices",
                "Java",
                "Java 8");
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAMock() {

        // Given | Arrange
        when(mockService.retrieveCourses("Dani"))
                .thenReturn(courses); // mockando o método retrieveCourses da interface CourseService

        // When | Act
        List<String> filteredCourses = business
                .retrieveCoursesRelatedToSpring("Dani");

        // Then | Assert
        assertEquals(6, filteredCourses.size(),
                () -> "Expected 6 courses related to Spring");

        // simulando uma regra de negócio que diz q o user José retorno 0 cursos
        filteredCourses = business.retrieveCoursesRelatedToSpring("José");
        assertEquals(0, filteredCourses.size(),
                () -> "Expected 0 courses related to Spring for user José");
    }
}
