package com.springframework.jobdata.service;

import com.springframework.jobdata.dto.Page;
import com.springframework.jobdata.model.JobData;

import java.util.Map;
import java.util.Set;

/**
 * Created by Nay Myo Htet on 4/8/2023.
 */
public interface JobDataService {

    Page<JobData> getJobData(Map<String, String> filters, Set<String> fields, String[] sorts, int page, int size);

}
