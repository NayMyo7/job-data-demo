package com.springframework.jobdata.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nay Myo Htet on 4/10/2023.
 */
public class JobDataField {
    public static final Map<String, String> FIELD_TO_PROPERTY_MAP;

    static {
        Map<String, String> map = new HashMap<>();
        map.put("timestamp", "Timestamp");
        map.put("employer", "Employer");
        map.put("location", "Location");
        map.put("jobTitle", "Job Title");
        map.put("yearsAtEmployer", "Years At Employer");
        map.put("yearsOfExperience", "Years Of Experience");
        map.put("salary", "Salary");
        map.put("signingBonus", "Signing Bonus");
        map.put("annualBonus", "Annual Bonus");
        map.put("annualStockValueBonus", "Annual Stock Value/Bonus");
        map.put("gender", "Gender");
        map.put("additionalComments", "Additional Comments");
        FIELD_TO_PROPERTY_MAP = Collections.unmodifiableMap(map);
    }

}
