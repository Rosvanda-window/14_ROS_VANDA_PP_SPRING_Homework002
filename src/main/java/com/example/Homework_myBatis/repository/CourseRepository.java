package com.example.Homework_myBatis.repository;

import com.example.Homework_myBatis.model.dto.request.CourseRequest;
import com.example.Homework_myBatis.model.entity.Courses;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CourseRepository {

    @Results(id = "course",value = {
            @Result(property = "courseId" , column = "course_id"),
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(select = "com.example.Homework_myBatis.repository.InstructorRepository.findInstructorById")
            )

    })
    @Select("""
    SELECT * FROM courses
    LIMIT #{size}
    OFFSET (#{page} - 1) * #{size}
    """)
    List<Courses> findAllCourse(Integer page, Integer size);

    @ResultMap("course")
    @Select("""
    SELECT * FROM courses
    WHERE course_id = #{courseId}
    """)
    Courses findCourseById(Integer courseId);

    @ResultMap("course")
    @Select("""
    INSERT INTO courses (course_name, description, instructor_id)
                VALUES (#{course_name}, #{description}, #{instructorId} ) RETURNING *
   """)
    Courses createCourse(CourseRequest courseRequest);

    @ResultMap("course")
    @Select("""
    UPDATE courses
    SET course_name = #{courseRequest.course_name} , description = #{courseRequest.description} , instructor_id = #{courseRequest.instructorId}
    WHERE course_id = #{courseId} RETURNING *
    """)
    Courses updateCourseById(Integer courseId, CourseRequest courseRequest);


    @ResultMap("course")
    @Delete("""
    DELETE FROM courses
    WHERE course_id = #{courseId}
    """)
    int deleteCourseById(Integer courseId);

}
