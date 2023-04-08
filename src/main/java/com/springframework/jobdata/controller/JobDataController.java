package com.springframework.jobdata.controller;

import com.springframework.jobdata.dto.ApiResponse;
import com.springframework.jobdata.model.JobData;
import com.springframework.jobdata.service.JobDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Nay Myo Htet on 4/8/2023.
 */
@RestController
public class JobDataController extends BaseController<JobData> {

    @Autowired
    private JobDataService jobDataService;

    @GetMapping("/job-data")
    public ResponseEntity<ApiResponse<List<JobData>>> getJobData() {
        return okResponse(messages.get("job.data.retrieve.success"), jobDataService.getJobData());
    }
}
