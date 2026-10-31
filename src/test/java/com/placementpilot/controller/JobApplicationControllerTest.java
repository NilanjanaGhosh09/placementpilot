package com.placementpilot.controller;

import com.placementpilot.model.JobApplication;
import com.placementpilot.repository.JobApplicationRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JobApplicationControllerTest {

    private final JobApplicationRepository repository = Mockito.mock(JobApplicationRepository.class);
    private final JobApplicationController controller = new JobApplicationController(repository);

    @Test
    void updateStatusChangesTheStatus() {
        JobApplication application = new JobApplication();
        application.setId(1L);
        application.setStatus("APPLIED");
        Mockito.when(repository.findById(1L)).thenReturn(Optional.of(application));
        Mockito.when(repository.save(application)).thenReturn(application);

        JobApplication result = controller.updateStatus(1L, Map.of("status", "SHORTLISTED"));

        assertEquals("SHORTLISTED", result.getStatus());
        Mockito.verify(repository).save(application);
    }
}
