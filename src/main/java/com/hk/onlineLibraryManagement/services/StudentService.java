package com.hk.onlineLibraryManagement.services;

import com.hk.onlineLibraryManagement.DTOs.GetStudentDetails;
import com.hk.onlineLibraryManagement.models.Student;
import com.hk.onlineLibraryManagement.models.StudentStatus;
import com.hk.onlineLibraryManagement.repositiries.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

//    ObjectMapper objectMapper = new ObjectMapper();

    public Integer createStudent(Student student) {
        student = studentRepository.save(student);
        return student.getStudentID();
    }

    public GetStudentDetails getStudentDetails(Integer studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        return GetStudentDetails.builder()
                .student(student)
                .build();
    }

//    public GetStudentDetails updateStudent(Student updatedStudent, Integer studentId) {
//        Student existingStudent = studentRepository.findById(studentId).orElse(null);
//
//        Student target = this.merge(student, existingStudent);
//       target = studentRepository.save(target);
//        return GetStudentDetails.builder()
//                .student(target)
//                .build();


    public GetStudentDetails updateStudent(Student updatedStudent, Integer studentId) {
        Student existingStudent = studentRepository.findById(studentId).orElse(null);

        if (updatedStudent.getStudentName() != null) {
            existingStudent.setStudentName(updatedStudent.getStudentName());
        }
        if (updatedStudent.getEmail() != null) {
            existingStudent.setEmail(updatedStudent.getEmail());
        }
        if (updatedStudent.getMobileNumber() != null) {
            existingStudent.setMobileNumber(updatedStudent.getMobileNumber());
        }
        existingStudent = studentRepository.save(existingStudent);
        return GetStudentDetails.builder()
                .student(existingStudent)
                .build();
    }

    public GetStudentDetails deactivateStudent(Integer studentId) {
        Student student = studentRepository.findById(studentId).get();
        if (student != null) {
            studentRepository.deactivate(studentId, StudentStatus.INACTIVE);
        }
        student = this.studentRepository.findById(studentId).orElse(null);
        return GetStudentDetails.builder()
                .student(student)
                .build();

    }


}
