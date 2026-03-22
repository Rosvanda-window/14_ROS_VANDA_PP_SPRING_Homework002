package com.example.Homework_myBatis.repository;

import com.example.Homework_myBatis.model.dto.request.StudentRequest;
import com.example.Homework_myBatis.model.entity.Students;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentRepository {

    @Results( id = "student" ,value = {
            @Result(property = "studentId", column = "student_id"),
            @Result(property = "studentName", column = "student_name"),
            @Result(property = "phoneNumber", column = "phone_number"),
            @Result(property = "courses", column = "student_id",
                    many = @Many(select = "com.example.Homework_myBatis.repository.StudentCourseRepository.findCoursesByStudentId"))
    })

    @Select("""
        SELECT * FROM students
        LIMIT #{size}
        OFFSET (#{page}-1) * #{size}
    """)
    List<Students> findAllStudent(Integer page, Integer size);

    @ResultMap("student")
    @Delete("""
    DELETE FROM students
    WHERE student_id = #{studentId}
   """)
    int deleteStudent(Integer studentId);

    @ResultMap("student")
    @Select("""
    INSERT INTO students(student_name, email, phone_number) 
    VALUES (#{studentName} , #{email} , #{phoneNumber})
    RETURNING *
    """)
    Students insertStudent(StudentRequest studentRequest);

    @ResultMap("student")
    @Select("""
    SELECT * FROM students
    WHERE student_id = #{studentId}
    """)
    Students findStudentById(Integer studentId);


    @ResultMap("student")
    @Select("""
    UPDATE students
    SET student_name = #{req.studentName},
        email = #{req.email},
         phone_number= #{req.phoneNumber}
    WHERE student_id = #{studentId}
    RETURNING *
""")
    Students updateStudent( Integer studentId,@Param("req")  StudentRequest studentRequest);
}
