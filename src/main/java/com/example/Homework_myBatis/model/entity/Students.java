package com.example.Homework_myBatis.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {
    private Integer studentId;
    private String studentName;
    private String email;
    private Integer phoneNumber;
    private List<Courses> courses;
}
