package com.example.Homework_myBatis.service.impl;

import com.example.Homework_myBatis.model.entity.Instructor;
import com.example.Homework_myBatis.model.dto.request.InstructorRequest;
import com.example.Homework_myBatis.repository.InstructorRepository;
import com.example.Homework_myBatis.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class InstructorServiceImpl implements InstructorService {

    private final InstructorRepository instructorRepository;


    @Override
    public List<Instructor> getAllInstructorWithPagination( Integer page, Integer size ) {
        return instructorRepository.findAllInstructor(page, size);
    }

    @Override
    public Instructor getInstructorById(Integer instructorsId) {
        return instructorRepository.findInstructorById(instructorsId);
    }

    @Override
    public Instructor createInstructor(InstructorRequest instructorRequest) {
        return instructorRepository.insertInstructor(instructorRequest);
    }

    @Override
    public boolean deleteInstructorById(Integer instructorId) {
        int rowAffected = instructorRepository.deleteById(instructorId);
        return rowAffected > 0;
    }

    @Override
    public Instructor updateInstructorById(Integer instructorId, InstructorRequest request) {
        return instructorRepository.findInstructorUpdateById(instructorId, request);
    }

}
