package com.hk.onlineLibraryManagement.controllers;

import com.hk.onlineLibraryManagement.DTOs.GetStudentDetails;
import com.hk.onlineLibraryManagement.DTOs.GetStudentDetails;
import com.hk.onlineLibraryManagement.DTOs.CreateStudentRequest;
import com.hk.onlineLibraryManagement.DTOs.UpdateStudentRequest;
import com.hk.onlineLibraryManagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/addStudent")
    public Long createStudent(@RequestBody CreateStudentRequest createStudentRequest){
        return studentService.createStudent(createStudentRequest.toStudent());
    }

    @GetMapping("/getStudent")
    public GetStudentDetails getStudentDetails(@RequestParam("id") Long studentId){
        return studentService.getStudentDetails(studentId);
    }

//    @GetMapping("/getStudent")
//    public StudentDetailsGet getStudentDetails(@RequestParam Long studentId){
//
//    }

    @PatchMapping("/updateStudent/{studentId}")
    public GetStudentDetails updateStudent(@RequestBody UpdateStudentRequest updateStudentRequest,
                                           @PathVariable("studentId") Long studentId){
        return studentService.updateStudent(updateStudentRequest.toStudent(), studentId);
    }

    @DeleteMapping("/deleteStudent")
    public GetStudentDetails deleteStudent(@RequestParam("studentId") Long studentId){
        return this.studentService.deactivateStudent(studentId);
    }

}
