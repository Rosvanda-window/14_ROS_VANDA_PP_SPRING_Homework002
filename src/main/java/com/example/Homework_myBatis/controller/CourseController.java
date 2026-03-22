package com.example.Homework_myBatis.controller;

import com.example.Homework_myBatis.model.dto.request.CourseRequest;
import com.example.Homework_myBatis.model.dto.response.ApiResponse;
import com.example.Homework_myBatis.model.entity.Courses;
import com.example.Homework_myBatis.model.entity.Instructor;
import com.example.Homework_myBatis.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.ognl.IteratorEnumeration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @Operation(summary = "Get all Course")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Courses>>>  getAllCourse(@RequestParam Integer page,@RequestParam Integer size){

        if(courseService.getAllCourse(page, size) != null){
            ApiResponse response = ApiResponse.builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Get all course successfully!")
                    .payload(courseService.getAllCourse(page, size))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            ApiResponse response = ApiResponse.builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Get all course failed!")
                    .payload(courseService.getAllCourse(page, size))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @Operation(summary = "Get Course by ID")
    @GetMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Courses>> getCourseById(@PathVariable("course-id") Integer courseId){
        if(courseService.getcourseById(courseId) != null){
            ApiResponse response = ApiResponse.builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Get course id " + courseId+ " successfully!")
                    .payload(courseService.getcourseById(courseId))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            ApiResponse response = ApiResponse.builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Get course "+ courseId+" failed!")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @Operation(summary = "Create course")
    @PostMapping
    public ResponseEntity<ApiResponse<Courses>> insertCourse(@RequestBody CourseRequest courseRequest){
        if(courseService.insertCourse(courseRequest) != null){
            ApiResponse response = ApiResponse.builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Create course name " + courseRequest.getCourse_name()+ " successfully!")
                    .payload(courseService.insertCourse(courseRequest))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            ApiResponse response = ApiResponse.builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Create course name "+ courseRequest.getCourse_name()+" failed!")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @Operation(summary = "Update course by ID")
    @PutMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Courses>> updateCourse(@PathVariable("course-id") Integer courseId, @RequestBody CourseRequest courseRequest){

        if(courseService.updateCourseById(courseId , courseRequest) != null){
            ApiResponse response = ApiResponse.builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Create course name " + courseRequest.getCourse_name()+ " successfully!")
                    .payload(courseService.insertCourse(courseRequest))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            ApiResponse response = ApiResponse.builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Create course name "+ courseRequest.getCourse_name()+" failed!")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @Operation(summary = "Delete course by ID")
    @DeleteMapping("/{course-id}")
    public ResponseEntity<ApiResponse<Courses>> deleteCourseById(@PathVariable("course-id") Integer courseId){

        boolean deleteCourse = courseService.deleteCourseById(courseId);

        if (deleteCourse) {
            ApiResponse response = ApiResponse.<Instructor>builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Deleted course ID " + +courseId + " successfully!")
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.ok(response);
        } else {
            ApiResponse response = ApiResponse.<Instructor>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Instructor ID " + courseId + " not found!")
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }
}
