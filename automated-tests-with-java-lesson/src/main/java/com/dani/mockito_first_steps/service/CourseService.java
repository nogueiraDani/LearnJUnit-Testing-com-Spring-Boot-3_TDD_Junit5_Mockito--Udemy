package com.dani.mockito_first_steps.service;

import java.util.List;

public interface CourseService {

    public List<String> retrieveCourses(String user);

    public void deleteCourse(String course);

}
