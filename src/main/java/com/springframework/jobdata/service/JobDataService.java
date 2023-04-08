package com.springframework.jobdata.service;

import com.springframework.jobdata.model.JobData;

import java.util.List;

/**
 * Created by Nay Myo Htet on 4/8/2023.
 */
public interface JobDataService {

    List<JobData> getJobData();
}
