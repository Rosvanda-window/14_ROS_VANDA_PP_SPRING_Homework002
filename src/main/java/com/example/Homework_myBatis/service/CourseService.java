package com.example.Homework_myBatis.service;


import com.example.Homework_myBatis.model.dto.request.CourseRequest;
import com.example.Homework_myBatis.model.entity.Courses;

import java.util.List;

public interface CourseService {

    Courses getcourseById(Integer courseId);

    Courses insertCourse(CourseRequest courseRequest);

    Courses updateCourseById(Integer courseId, CourseRequest courseRequest);

    boolean deleteCourseById(Integer courseId);

    List<Courses> getAllCourse(Integer page, Integer size);
}
