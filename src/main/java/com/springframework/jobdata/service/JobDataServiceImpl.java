package com.springframework.jobdata.service;

import com.springframework.jobdata.dao.JobDataDao;
import com.springframework.jobdata.model.JobData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Nay Myo Htet on 4/8/2023.
 */
@Service
public class JobDataServiceImpl implements JobDataService {

    @Autowired
    JobDataDao jobDataDao;

    @Override
    public List<JobData> getJobData() {
        return jobDataDao.getAll();
    }
}
