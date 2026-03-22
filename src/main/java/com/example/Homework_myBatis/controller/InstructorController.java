package com.example.Homework_myBatis.controller;


import com.example.Homework_myBatis.model.entity.Instructor;
import com.example.Homework_myBatis.model.dto.request.InstructorRequest;
import com.example.Homework_myBatis.model.dto.response.ApiResponse;
import com.example.Homework_myBatis.service.InstructorService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1/instructors")
@RequiredArgsConstructor
public class InstructorController {

    private final InstructorService instructorService;

    @Operation(summary = "Get all instructor")
    @GetMapping
    public ResponseEntity<ApiResponse<List<Instructor>>>  getAllInstructorWithPagination(@RequestParam Integer page, @RequestParam Integer size){
        if(instructorService.getAllInstructorWithPagination(page, size) != null){
            ApiResponse response = ApiResponse.builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Get all instructor successfully!")
                    .payload(instructorService.getAllInstructorWithPagination(page, size))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            ApiResponse response = ApiResponse.builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Get all instructor failed!")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @Operation(summary = "Get instructor by ID")
    @GetMapping("/{instructors-id}")
    public ResponseEntity<ApiResponse<Instructor>>  getInstructorByID(@PathVariable("instructors-id") Integer instructorsId){
        if(instructorService.getInstructorById(instructorsId) != null){
            ApiResponse response = ApiResponse.builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Get instructor id" + instructorsId + "successfully!")
                    .payload(instructorService.getInstructorById(instructorsId))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            ApiResponse response = ApiResponse.builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Get instructor id " + instructorsId + " failed!")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @Operation(summary = "Create new Instructor")
    @PostMapping
    public ResponseEntity<ApiResponse<Instructor>> createInstructor(@RequestBody InstructorRequest instructorRequest) {

        if(instructorService.createInstructor(instructorRequest) != null){
            ApiResponse response = ApiResponse.builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Create instructor name " + instructorRequest.getInstructorName() + " successfully!")
                    .payload(instructorService.createInstructor(instructorRequest))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            ApiResponse response = ApiResponse.builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Create instructor name " + instructorRequest.getInstructorName() + " failed!")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    //delete not complete
    @Operation(summary = "Delete instructor by ID")
    @DeleteMapping("/{instructors-id}")
    public ResponseEntity<ApiResponse<Instructor>> deleteInstructorById(
            @PathVariable("instructors-id") Integer instructorId) {

        boolean deletedInstructor = instructorService.deleteInstructorById(instructorId);

        if (deletedInstructor) {
            ApiResponse response = ApiResponse.<Instructor>builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Deleted instructor ID " + instructorId + " successfully!")
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.ok(response);
        } else {
            ApiResponse response = ApiResponse.<Instructor>builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Instructor ID " + instructorId + " not found!")
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }


    @Operation(summary = "Update Instructor by ID")
    @PutMapping("/{instructor-id}")
    public ResponseEntity<ApiResponse<Instructor>> updateInstructorById(@PathVariable("instructor-id") Integer instructorId, @RequestBody InstructorRequest request){
        if(instructorService.updateInstructorById(instructorId, request) != null){
            ApiResponse response = ApiResponse.builder()
                    .success(true)
                    .status(HttpStatus.OK)
                    .message("Update instructor ID " + instructorId + " successfully!")
                    .payload(instructorService.updateInstructorById(instructorId, request))
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.OK).body(response);
        }else{
            ApiResponse response = ApiResponse.builder()
                    .success(false)
                    .status(HttpStatus.NOT_FOUND)
                    .message("Update instructor ID " + instructorId + " failed!")
                    .payload(null)
                    .timestamp(Instant.now())
                    .build();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }



}
