package com.dani.mockito_first_steps.business;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import com.dani.mockito_first_steps.service.CourseService;

public class CourseBusinessMockWithBDDTest {

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
                //"Spring MVC",
                //"Spring Security",
                //"Spring Data JPA",
                //"Spring Cloud",
                "Rest APIs",
                //"Spring,
                "Microservices",
                //"Java",
                "Java 8");
    }

    @Test
    void testCoursesRelatedToSpring_When_UsingAMock() {

        // Given | Arrange
        given(mockService.retrieveCourses("Dani"))
                .willReturn(courses); // mockando o método retrieveCourses da interface CourseService

        // When | Act
        var filteredCourses = business
                .retrieveCoursesRelatedToSpring("Dani");

        // Then | Assert
        assertThat(filteredCourses.size(), is(6));
    }

    @DisplayName("Test Delete Courses Not Related To Spring")
    @Test
    void testDeleteCoursesNotReletedSpring_UsingMockitoVerify_ShouldCall_deleteCourse() {
        // Given | Arrange
        given(mockService.retrieveCourses("Dani"))
                .willReturn(courses);

        ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);

        // When | Act
        business.deleteCoursesNotRelatedToSpring("Dani");

        // Then | Assert
        
        // com verify
        /*
        verify(mockService, times(1)) // verifica se passa 1 vez
         .deleteCourse("Rest APIs");
        verify(mockService, atLeast(1)) // verifica se passa pelo menos 1 vez
         .deleteCourse("Microservices");
        verify(mockService, atLeastOnce())
         .deleteCourse("Spring MVC"); // verifica se pass
        verify(mockService, never()) // verifica se nunca passa
         .deleteCourse("Spring Boot");
         */

        // pode-se fazer com o then tbm
        then(mockService).should(times(1))
                .deleteCourse("Rest APIs");
        then(mockService).should(atLeast(1))
                .deleteCourse("Microservices");
        then(mockService).should(never())
                .deleteCourse("Spring Boot");
        
        // CAPTURANDO O ARGUMENTO
        then(mockService).should(times(3)).deleteCourse(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(), is("Java 8"));
        assertThat(argumentCaptor.getAllValues().size(), is(3));
    }
}
