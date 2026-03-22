package com.example.Homework_myBatis.service;

import com.example.Homework_myBatis.model.entity.Instructor;
import com.example.Homework_myBatis.model.dto.request.InstructorRequest;

import java.util.List;

public interface InstructorService {



    List<Instructor> getAllInstructorWithPagination(Integer page, Integer size);

    Instructor getInstructorById(Integer instructorsId);

    Instructor createInstructor(InstructorRequest instructorRequest);

    boolean deleteInstructorById(Integer instructorId);

    Instructor updateInstructorById(Integer instructorId, InstructorRequest request);
}
