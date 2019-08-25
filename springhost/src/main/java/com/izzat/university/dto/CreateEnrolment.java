package com.izzat.university.dto;

import lombok.Data;
import org.springframework.lang.NonNull;

@Data
public class CreateEnrolment {
    @NonNull
    String studentId;
    @NonNull
    String moduleId;
}
