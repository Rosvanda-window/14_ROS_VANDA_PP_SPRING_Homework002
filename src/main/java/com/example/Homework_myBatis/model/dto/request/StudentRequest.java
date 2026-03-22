package com.example.Homework_myBatis.model.dto.request;

import com.example.Homework_myBatis.model.entity.Courses;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {
    private String studentName;
    private String email;
    private Integer phoneNumber;
    private List<Integer> coursesId;
}
