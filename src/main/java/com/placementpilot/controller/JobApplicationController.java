package com.placementpilot.controller;

import com.placementpilot.model.JobApplication;
import com.placementpilot.repository.JobApplicationRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/applications")
public class JobApplicationController {

    private final JobApplicationRepository applicationRepository;

    public JobApplicationController(JobApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @GetMapping
    public List<JobApplication> getAllApplications() {
        return applicationRepository.findAll();
    }

    @PostMapping
    public JobApplication addApplication(@RequestBody JobApplication application) {
        return applicationRepository.save(application);
    }

    @PutMapping("/{id}/status")
    public JobApplication updateStatus(@PathVariable Long id, @RequestBody Map<String, String> body) {
        JobApplication application = applicationRepository.findById(id).orElseThrow();
        application.setStatus(body.get("status"));
        return applicationRepository.save(application);
    }
}
