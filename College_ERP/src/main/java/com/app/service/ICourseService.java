package com.app.service;

import com.app.pojos.Course;

public interface ICourseService {
Course addCourse(Course course);
String deleteCourse(String id);
}
