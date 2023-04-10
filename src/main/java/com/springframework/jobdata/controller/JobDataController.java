package com.springframework.jobdata.controller;

import com.springframework.jobdata.dto.ApiResponse;
import com.springframework.jobdata.dto.Page;
import com.springframework.jobdata.model.JobData;
import com.springframework.jobdata.service.JobDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

/**
 * Created by Nay Myo Htet on 4/8/2023.
 */
@RestController
@Slf4j
public class JobDataController extends BaseController<JobData> {

    @Autowired
    private JobDataService jobDataService;

    @GetMapping("/job-data")
    public ResponseEntity<ApiResponse<Page<JobData>>> getJobData(
            @RequestParam Map<String, String> filters,
            @RequestParam(name = "fields", required = false) Set<String> fields,
            @RequestParam(name = "sort", required = false) String[] sorts,
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        log.info("Query parameters => " + filters
                + "\nFields => " + fields
                + "\nSort => " + sorts
                + "\nPage => " + page
                + "\nSize => " + size);
        return okResponse(messages.get("job.data.retrieve.success"), jobDataService.getJobData(filters, fields, sorts, page, size));
    }
}
