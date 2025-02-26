package com.dani.mockito_first_steps.service.stubs;

import java.util.Arrays;
import java.util.List;

import com.dani.mockito_first_steps.service.CourseService;

public class CourseServiceStub implements CourseService {

    @Override
    public List<String> retrieveCourses(String user) {

        return Arrays.asList(
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

    @Override
    public void deleteCourse(String course) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteCourse'");
    }

}
