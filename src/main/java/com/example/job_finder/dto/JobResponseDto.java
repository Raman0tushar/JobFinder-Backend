package com.example.job_finder.dto;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor

public class JobResponseDto {
    private Long id;
    private String title;
    private String description;
    private String location;
    private String jobType;
    private Double salaryMin;
    private Double salaryMax;
    private String companyName;

    private LocalDateTime postedAt;

    private LocalDateTime expiresAt;




}
