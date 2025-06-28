package com.hk.onlineLibraryManagement.DTOs;

import com.hk.onlineLibraryManagement.models.Student;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UpdateStudentRequest {

    private String studentName;

    private String email;

    private String mobileNumber;

    public Student toStudent(){
        return Student.builder()
                .studentName(studentName)
                .email(email)
                .mobileNumber(mobileNumber)
                .build();
    }
}
