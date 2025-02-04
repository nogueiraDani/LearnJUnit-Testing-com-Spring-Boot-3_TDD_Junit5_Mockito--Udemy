package com.dani.mockito_first_steps.business;

import java.util.ArrayList;
import java.util.List;

import com.dani.mockito_first_steps.service.CourseService;

// CourseBusiness -> é a classe que será testada ou SUT (System Under Test) ou  MethodUnderTest
public class CourseBusiness {

    // CourseService -> é a dependência da classe CourseBusiness
    private CourseService courseService;

    public CourseBusiness(CourseService courseService) {
        this.courseService = courseService;
    }

    public List<String> retrieveCoursesRelatedToWinter(String user) {
        List<String> filteredCourses = new ArrayList<String>();

        // simulando a regra de negocio do José
        if (user.equals("José")) {
            return filteredCourses;
        }
        
        List<String> allCourses = courseService.retrieveCourses(user);
        for (String course : allCourses) {
            if (course.contains("Spring")) {
                filteredCourses.add(course);
            }
        }
        return filteredCourses;
    }

}
