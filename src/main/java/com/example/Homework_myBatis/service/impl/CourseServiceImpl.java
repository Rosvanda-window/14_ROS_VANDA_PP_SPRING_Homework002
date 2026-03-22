package com.example.Homework_myBatis.service.impl;

import com.example.Homework_myBatis.model.dto.request.CourseRequest;
import com.example.Homework_myBatis.model.entity.Courses;
import com.example.Homework_myBatis.repository.CourseRepository;
import com.example.Homework_myBatis.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;


    @Override
    public Courses getcourseById(Integer courseId) {
        return courseRepository.findCourseById(courseId);
    }

    @Override
    public Courses insertCourse(CourseRequest courseRequest) {
        return courseRepository.createCourse(courseRequest);
    }

    @Override
    public Courses updateCourseById(Integer courseId, CourseRequest courseRequest) {
        return courseRepository.updateCourseById(courseId,courseRequest);
    }

    @Override
    public boolean deleteCourseById(Integer courseId) {
        int rowAffected = courseRepository.deleteCourseById(courseId);
        return rowAffected > 0;
    }

    @Override
    public List<Courses> getAllCourse(Integer page, Integer size) {
        return courseRepository.findAllCourse(page, size);
    }
}
