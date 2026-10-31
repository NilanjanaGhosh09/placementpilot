package com.placementpilot.controller;

import com.placementpilot.model.Interview;
import com.placementpilot.repository.InterviewRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/interviews")
public class InterviewController {

    private final InterviewRepository interviewRepository;

    public InterviewController(InterviewRepository interviewRepository) {
        this.interviewRepository = interviewRepository;
    }

    @GetMapping
    public List<Interview> getAllInterviews() {
        return interviewRepository.findAll();
    }

    @GetMapping("/application/{applicationId}")
    public List<Interview> getByApplication(@PathVariable Long applicationId) {
        return interviewRepository.findByApplicationId(applicationId);
    }

    @PostMapping
    public Interview scheduleInterview(@RequestBody Interview interview) {
        return interviewRepository.save(interview);
    }
}
