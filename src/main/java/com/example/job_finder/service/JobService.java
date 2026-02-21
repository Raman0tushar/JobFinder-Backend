package com.example.job_finder.service;




import com.example.job_finder.dto.JobCreateDto;
import com.example.job_finder.dto.JobResponseDto;
import com.example.job_finder.entity.Job;
import com.example.job_finder.repository.JobRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;

    public JobResponseDto createJob(JobCreateDto dto) {
        Job job = Job.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .location(dto.getLocation())
                .jobType(dto.getJobType())
                .salaryMin(dto.getSalaryMin())
                .salaryMax(dto.getSalaryMax())
                .companyName(dto.getCompanyName())
                .build();

        Job saved = jobRepository.save(job);
        return mapToResponse(saved);
    }

    public List<JobResponseDto> getAllJobs() {
        return jobRepository.findAll().stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    public JobResponseDto getJobById(Long id) {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
        return mapToResponse(job);
    }

    public List<JobResponseDto> searchJobs(String title, String location, String jobType) {
        return jobRepository.searchJobs(title, location, jobType).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    private JobResponseDto mapToResponse(Job job) {
        JobResponseDto dto = new JobResponseDto();
        dto.setId(job.getId());
        dto.setTitle(job.getTitle());
        dto.setDescription(job.getDescription());
        dto.setLocation(job.getLocation());
        dto.setJobType(job.getJobType());
        dto.setSalaryMin(job.getSalaryMin());
        dto.setSalaryMax(job.getSalaryMax());
        dto.setCompanyName(job.getCompanyName());
        dto.setPostedAt(job.getPostedAt());
        dto.setExpiresAt(job.getExpiresAt());
        return dto;
    }


    public JobResponseDto postJob(JobCreateDto dto) {

        Job job = new Job();
        job.setTitle(dto.getTitle());
        job.setCompanyName(dto.getCompanyName());
        job.setLocation(dto.getLocation());
        job.setJobType(dto.getJobType());
        job.setDescription(dto.getDescription());
        job.setSalaryMin(dto.getSalaryMin());
        job.setSalaryMax(dto.getSalaryMax());
        job.setExpiresAt(dto.getExpiresAt());

        // system-controlled field
        job.setPostedAt(LocalDate.now().atStartOfDay());

        Job savedJob = jobRepository.save(job);

        return mapToResponse(savedJob);
    }

}