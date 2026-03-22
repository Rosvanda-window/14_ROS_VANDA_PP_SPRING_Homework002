package com.example.Homework_myBatis.service;

import com.example.Homework_myBatis.model.dto.request.StudentRequest;
import com.example.Homework_myBatis.model.entity.Courses;
import com.example.Homework_myBatis.model.entity.Students;

import java.util.List;

public interface StudentService {


    List<Students> getAllStudent(Integer page, Integer size);

    boolean deleteStudentById(Integer studentId);

    Students createStudent(StudentRequest studentRequest);

    Students getStudentById(Integer studentId);

    Students updateStudent(Integer id, StudentRequest studentRequest) ;
}
