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
    public Integer createStudent(@RequestBody CreateStudentRequest createStudentRequest){
        return studentService.createStudent(createStudentRequest.toStudent());
    }

    @GetMapping("/getStudent")
    public GetStudentDetails getStudentDetails(@RequestParam("id") Integer studentId){
        return studentService.getStudentDetails(studentId);
    }

//    @GetMapping("/getStudent")
//    public StudentDetailsGet getStudentDetails(@RequestParam String studentId){
//
//    }

    @PatchMapping("/updateStudent/{studentId}")
    public GetStudentDetails updateStudent(@RequestBody UpdateStudentRequest updateStudentRequest,
                                           @PathVariable("studentId") Integer studentId){
        return studentService.updateStudent(updateStudentRequest.toStudent(), studentId);
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public GetStudentDetails deleteStudent(@PathVariable("studentId") Integer studentId){
        studentService.deactivateStudent(studentId);
    }

}
