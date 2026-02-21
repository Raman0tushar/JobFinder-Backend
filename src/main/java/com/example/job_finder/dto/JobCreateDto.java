package com.example.job_finder.dto;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class JobCreateDto {
    private String title;
    private String description;
    private String location;
    private String jobType;
    private Double salaryMin;
    private Double salaryMax;
    private String companyName;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime expiresAt;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime postedAt;


}