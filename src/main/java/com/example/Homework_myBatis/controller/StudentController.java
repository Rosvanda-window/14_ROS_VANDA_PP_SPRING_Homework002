package com.example.Homework_myBatis.controller;

import com.example.Homework_myBatis.model.dto.request.StudentRequest;
import com.example.Homework_myBatis.model.dto.response.ApiResponse;
import com.example.Homework_myBatis.model.entity.Instructor;
import com.example.Homework_myBatis.model.entity.Students;
import com.example.Homework_myBatis.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @Operation(summary = "Get all student")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Students>>> getAllStudent(@RequestParam Integer page, @RequestParam Integer size){
        if(studentService.getAllStudent(page, size) != null){
            ApiResponse response = ApiResponse.builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Get all Student successfully!")
                    .payload(studentService.getAllStudent(page,size))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            ApiResponse response = ApiResponse.builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Get all student failed!")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @Operation(summary = "Delete student by ID")
    @DeleteMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Students>> deleteStudentById(@PathVariable("student-id") Integer studentId){

        boolean deleteStudent = studentService.deleteStudentById(studentId);

        if (deleteStudent) {
            ApiResponse response = ApiResponse.<Instructor>builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Deleted student ID " + studentId + " successfully!")
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.ok(response);
        } else {
            ApiResponse response = ApiResponse.<Instructor>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Student ID " + studentId + " not found!")
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @Operation(summary = "Create student")
    @PostMapping
    public ResponseEntity<ApiResponse<Students>> createStudent(@RequestBody StudentRequest studentRequest){
        if(studentService.createStudent(studentRequest) != null){
            ApiResponse response = ApiResponse.builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Create student successfully!")
                    .payload(studentService.createStudent(studentRequest))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            ApiResponse response = ApiResponse.builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Create student failed!")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @Operation(summary = "Get student by ID")
    @GetMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Students>> getStudentById(@PathVariable("student-id") Integer studentId){

        if(studentService.getStudentById(studentId) != null){
            ApiResponse response = ApiResponse.builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Get student " + studentId + " successfully!")
                    .payload(studentService.getStudentById(studentId))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            ApiResponse response = ApiResponse.builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Get student "+studentId+" failed!")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


    @Operation(summary = "Update student")
    @PutMapping("/{student-id}")
    public ResponseEntity<ApiResponse<Students>> updateStudent(@PathVariable("student-id") Integer id , @RequestBody StudentRequest studentRequest){
        if(studentService.getStudentById(id) != null){
            ApiResponse response = ApiResponse.builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Update student successfully!")
                    .payload(studentService.getStudentById(id))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            ApiResponse response = ApiResponse.builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Update student failed failed!")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
