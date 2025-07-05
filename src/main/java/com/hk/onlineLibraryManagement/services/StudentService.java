package com.hk.onlineLibraryManagement.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hk.onlineLibraryManagement.DTOs.GetStudentDetails;
import com.hk.onlineLibraryManagement.models.Student;
import com.hk.onlineLibraryManagement.models.StudentStatus;
import com.hk.onlineLibraryManagement.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    public Long createStudent(Student student) {
        student = this.studentRepository.save(student);
        return student.getStudentID();
    }

    public GetStudentDetails getStudentDetails(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        return GetStudentDetails.builder()
                .student(student)
                .build();
    }


//    public GetStudentDetails updateStudent(Student student, Long studentId) {
//
//        Student existingStudent = this.studentRepository.findById(studentId).orElse(null);
//        Student target = this.merge(student, existingStudent);
//
//        target=this.studentRepository.save(target);
//        return GetStudentDetails.builder()
//                .student(target)
//                .build();
//    }
//
//    private Student merge(Student incoming, Student existing) {
//        JSONObject incomingStudent = objectMapper.convertValue(incoming, JSONObject.class);
//        JSONObject savedStudent = objectMapper.convertValue(existing, JSONObject.class);
//
//        Iterator it = incomingStudent.keySet().iterator();  // id, name, email, mobile .....
//        while (it.hasNext()) {
//            String key = (String)it.next();
//            if(incomingStudent.get(key) != null) {
//                savedStudent.put(key, incomingStudent.get(key));
//            }
//        }
//        return objectMapper.convertValue(savedStudent, Student.class);
//    }

    public GetStudentDetails updateStudent(Student updatedStudent, Long studentId) {
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

    public GetStudentDetails deactivateStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student != null) {
            this.studentRepository.deactivate(studentId, StudentStatus.INACTIVE);
        }
        student = this.studentRepository.findById(studentId).orElse(null);
        return GetStudentDetails.builder()
                .student(student)
                .build();

    }


}
