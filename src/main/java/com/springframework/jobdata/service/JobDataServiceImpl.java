package com.springframework.jobdata.service;

import com.springframework.jobdata.dao.JobDataDao;
import com.springframework.jobdata.dto.Page;
import com.springframework.jobdata.filter.Filter;
import com.springframework.jobdata.filter.JobDataFilter;
import com.springframework.jobdata.model.JobData;
import com.springframework.jobdata.util.JobDataField;
import com.springframework.jobdata.util.ReflectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Nay Myo Htet on 4/8/2023.
 */
@Service
public class JobDataServiceImpl implements JobDataService {

    @Autowired
    JobDataDao jobDataDao;

    List<String> filterableFields = Arrays.asList("jobTitle", "salary", "gender");

    @Override
    public Page<JobData> getJobData(Map<String, String> filters, Set<String> fields, String[] sorts, int page, int size) {
        Stream<JobData> jobDataStream = jobDataDao.getAll().stream();

        // filter using predicate for allowed fields
        jobDataStream = jobDataStream.filter(getPredicate(filters));

        // project the fields using map
        if (fields != null && fields.size() > 0) {
            jobDataStream = jobDataStream.map(job -> job.projectFields(fields));
        }

        // sort the data with comparator
        if (sorts != null && sorts.length > 0) {
            jobDataStream = jobDataStream.sorted(getComparator(sorts));
        }

        // apply pagination
        List<JobData> content = jobDataStream.collect(Collectors.toList());
        long totalElements = content.size();
        content = content.stream().skip((page - 1) * size).limit(size).collect(Collectors.toList());

        // create a Page object
        return new Page<>(content, page, size, totalElements);
    }

    public Predicate<JobData> getPredicate(Map<String, String> filters) {
        List<Filter<JobData>> jobDataFilters = new ArrayList<>();
        for (Map.Entry<String, String> entry : filters.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            String operator = "eq";

            if (key.contains("[") && key.contains("]")) {
                String[] parts = key.split("\\[|\\]");
                key = parts[0];
                operator = parts[1];
            }
            if (filterableFields.contains(key)) {
                JobDataFilter filter = new JobDataFilter();
                filter.setField(key);
                filter.setOperator(operator);
                filter.setValue(value);
                jobDataFilters.add(filter);
            }
        }
        return jobDataFilters.stream()
                .map(Filter::buildPredicate)
                .reduce(Predicate::and)
                .orElse(jobData -> true);
    }

    public Comparator<JobData> getComparator(String[] sorts) {
        List<Comparator<JobData>> comparators = new ArrayList<>();
        if (sorts[0].contains(",")) {
            // will sort more than 2 fields
            // sortOrder="field, direction"
            for (String sort : sorts) {
                String[] _sort = sort.split(",");
                Comparator<JobData> comparator = getComparator(_sort[0], _sort[1]);
                if (comparator != null) {
                    comparators.add(comparator);
                }
            }
        } else {
            // sorts=[field, direction]
            Comparator<JobData> comparator = getComparator(sorts[0], sorts[1]);
            if (comparator != null) {
                comparators.add(comparator);
            }
        }
        return comparators.stream().reduce((c1, c2) -> 0, Comparator::thenComparing);
    }

    private Comparator<JobData> getComparator(String field, String dir) {
        if (!JobDataField.FIELD_TO_PROPERTY_MAP.containsKey(field)) return null;
        Comparator<JobData> comparator = Comparator.comparing(jobData -> (Comparable) ReflectionUtils.getFieldValue(jobData, field));
        return dir.contains("desc") ? comparator.reversed() : comparator;
    }

}
