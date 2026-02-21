package com.example.job_finder.repository;




import com.example.job_finder.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  JobRepository extends JpaRepository<Job, Long> {

    List<Job> findByTitleContainingIgnoreCase(String title);

    List<Job> findByLocationContainingIgnoreCase(String location);

    List<Job> findByJobType(String jobType);

    @Query("SELECT j FROM Job j WHERE " +
            "(:title IS NULL OR LOWER(j.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:location IS NULL OR LOWER(j.location) LIKE LOWER(CONCAT('%', :location, '%'))) AND " +
            "(:jobType IS NULL OR j.jobType = :jobType)")
    List<Job> searchJobs(
            @Param("title") String title,
            @Param("location") String location,
            @Param("jobType") String jobType
    );
}
