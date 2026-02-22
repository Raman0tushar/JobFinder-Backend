package com.example.job_finder.controller;



import com.example.job_finder.dto.JobCreateDto;
import com.example.job_finder.dto.JobResponseDto;
import com.example.job_finder.entity.Job;
import com.example.job_finder.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
@CrossOrigin(origins = "https://raman0tushar.github.io/JobFinder-Frontend/")   // change in production!
public class JobController {

    private final JobService jobService;

    @PostMapping
    public ResponseEntity<JobResponseDto> createJob(@RequestBody JobCreateDto dto) {
        return new ResponseEntity<>(jobService.createJob(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JobResponseDto>> getAllJobs() {
        return ResponseEntity.ok(jobService.getAllJobs());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobResponseDto> getJobById(@PathVariable Long id) {
        return ResponseEntity.ok(jobService.getJobById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<JobResponseDto>> searchJobs(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String location,
            @RequestParam(required = false) String jobType) {
        return ResponseEntity.ok(jobService.searchJobs(title, location, jobType));
    }

    @PostMapping("/post")
    public ResponseEntity<JobResponseDto> postJob(@RequestBody JobCreateDto dto) {
        System.out.println("DTO = " + dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(jobService.postJob(dto));
    }


}
