package com.example.Homework_myBatis.repository;

import com.example.Homework_myBatis.model.entity.Instructor;
import com.example.Homework_myBatis.model.dto.request.InstructorRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface InstructorRepository {

    @Results(id = "instructor" , value = {
            @Result(property = "instructorId" , column = "instructor_id"),
            @Result(property = "instructorName",column = "instructor_name")
    })
    @Select("""
            SELECT * FROM instructors
            LIMIT #{size}
            OFFSET (#{page} - 1 ) * #{size}
           """)
    List<Instructor> findAllInstructor(Integer page,Integer size);

    @ResultMap("instructor")
    @Select("""
            SELECT * FROM instructors
            WHERE instructor_id = #{instructorsId}
           """)
    Instructor findInstructorById(Integer instructorsId);

    @ResultMap("instructor")
    @Select("""
            INSERT INTO instructors (instructor_name, email)
            VALUES (#{instructorName} , #{email})
            RETURNING *
            """)
    Instructor insertInstructor(InstructorRequest instructorRequest);


    @ResultMap("instructor")
    @Delete("""
            DELETE FROM instructors
            WHERE instructor_id = #{instructorId}
           """)
    int deleteById(Integer instructorId);

    @ResultMap("instructor")
    @Select("""
            UPDATE instructors
            SET instructor_name = #{request.instructorName} , email = #{request.email}
            WHERE instructor_id = #{instructorId} RETURNING *
           """)
    Instructor findInstructorUpdateById(Integer instructorId, InstructorRequest request);
}
