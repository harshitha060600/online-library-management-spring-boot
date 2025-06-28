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
public class GetStudentDetails {

    private Student student;
}
