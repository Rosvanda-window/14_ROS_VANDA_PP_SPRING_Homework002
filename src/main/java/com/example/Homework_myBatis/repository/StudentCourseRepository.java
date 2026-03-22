package com.example.Homework_myBatis.repository;

import com.example.Homework_myBatis.model.entity.Courses;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentCourseRepository {

    @Results(id = "courseResult", value = {
            @Result(property = "courseId", column = "course_id"),
            @Result(property = "instructorId", column = "instructor_id"),
            @Result(property = "instructor", column = "instructor_id",
                    one = @One(select = "com.example.Homework_myBatis.repository.InstructorRepository.findInstructorById")
            )
    })
    @Select("""
        SELECT c.*
        FROM courses c
        JOIN student_course sc ON c.course_id = sc.course_id
        WHERE sc.student_id = #{studentId}
   """)
    List<Courses> findCoursesByStudentId(Integer studentId);


    @ResultMap("courseResult")
    @Select("""
    INSERT INTO student_course(student_id, course_id) VALUES (#{studentId} , #{courseId})
    """)
    void insertStudentCourse( Integer studentId, Integer courseId );



    @ResultMap("courseResult")
    @Select("""
    update student_course set student_id = #{studentId} , course_id =  #{courseId}
    """)
    void updateStudentCourse( Integer studentId, Integer courseId );


    @ResultMap("courseResult")
    @Select("""
    delete from student_course where student_id = #{studentId}
    """)
    void deleteStudentCourse( Integer studentId);

}