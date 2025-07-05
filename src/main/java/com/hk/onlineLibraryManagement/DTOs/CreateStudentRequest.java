package com.hk.onlineLibraryManagement.DTOs;

import com.hk.onlineLibraryManagement.models.Student;
import com.hk.onlineLibraryManagement.models.StudentStatus;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateStudentRequest {

    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String mobile;

    public Student toStudent(){
        return Student.builder()
                .studentName(name)
                .email(email)
                .mobileNumber(mobile)
                .status(StudentStatus.ACTIVE)
                .build();
    }

}
