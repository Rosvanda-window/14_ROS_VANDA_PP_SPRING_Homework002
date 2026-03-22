package com.example.Homework_myBatis.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courses {

    private Integer courseId;
    private String course_name;
    private String description;
    private Integer instructorId;
    private Instructor instructor;

}




