package com.springframework.jobdata.dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springframework.jobdata.model.JobData;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Nay Myo Htet on 4/8/2023.
 */
@Component
public class JobDataDao implements Dao<JobData> {

    @Autowired
    private ObjectMapper objectMapper;

    private List<JobData> jobDataList;

    @PostConstruct
    public void loadJobData() throws IOException {
        InputStream inputStream = getClass().getResourceAsStream("/salary_survey-3.json");
        jobDataList = objectMapper.readValue(inputStream, new TypeReference<List<JobData>>() {
        });
    }

    @Override
    public List<JobData> getAll() {
        return jobDataList;
    }
}
