package com.example.Homework_myBatis.service.impl;

import com.example.Homework_myBatis.model.dto.request.StudentRequest;
import com.example.Homework_myBatis.model.entity.Students;
import com.example.Homework_myBatis.repository.StudentCourseRepository;
import com.example.Homework_myBatis.repository.StudentRepository;
import com.example.Homework_myBatis.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.io.Console;
import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentCourseRepository studentCourseRepository ;




    @Override
    public List<Students> getAllStudent(Integer page, Integer size) {
        return studentRepository.findAllStudent(page , size);
    }

    @Override
    public boolean deleteStudentById(Integer studentId) {

        studentCourseRepository.deleteStudentCourse(studentId);
        int rowEffect = studentRepository.deleteStudent(studentId);
        return rowEffect > 0;
    }

    @Override
    public Students createStudent(StudentRequest studentRequest) {
        Students  students=  studentRepository.insertStudent(studentRequest);
        for(Integer courseId: studentRequest.getCoursesId()) {
            studentCourseRepository.insertStudentCourse( students.getStudentId(),courseId );
        }
        return studentRepository.insertStudent(studentRequest);
    }

    @Override
    public Students getStudentById(Integer studentId) {
        return studentRepository.findStudentById(studentId);
    }

    @Override
    public Students updateStudent(Integer id, StudentRequest studentRequest) {


        studentRepository.updateStudent(id, studentRequest);

        studentCourseRepository.deleteStudentCourse(id);


        for (Integer courseId : studentRequest.getCoursesId()) {
            studentCourseRepository.insertStudentCourse(id, courseId);
        }


        return studentRepository.findStudentById(id);
    }



}
