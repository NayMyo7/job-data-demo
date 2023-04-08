package com.springframework.jobdata.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.springframework.jobdata.deserializer.SalaryDeserializer;
import com.springframework.jobdata.type.Gender;

import java.time.LocalDateTime;

/**
 * Created by Nay Myo Htet on 4/8/2023.
 */
public class JobData {
    @JsonProperty("Timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "M/d/yyyy H:mm:ss")
    private LocalDateTime timestamp; //3/21/2016 12:58:52

    @JsonProperty("Employer")
    private String employer;

    @JsonProperty("Location")
    private String location;

    @JsonProperty("Job Title")
    private String jobTitle;

    @JsonProperty("Years at Employer")
    private String yearsAtEmployer; //0, 1.5, <1, 10+ years, 7.5 years

    @JsonProperty("Years of Experience")
    private String yearsAtExperience; //1 of employment, 0 (Just graduated), 10+ years, 2.5, 13

    @JsonProperty("Salary")
    @JsonDeserialize(using = SalaryDeserializer.class) // // Remove any non-numeric characters from the salary string
    private Integer salary; //122000, 65,000, 135k, $24/hr, 75,000 EUR, j

    @JsonProperty("Signing Bonus")
    private String signingBonus; //5000, 0, 25K $, 30k + 100 RSUs, â‚¬0, 2 rare pepes, LOL

    @JsonProperty("Annual Bonus")
    private String annualBonus; //$50.00, 5,000, 40000, 15000 (Just for first 4 months as a hire), 2 - 3%

    @JsonProperty("Annual Stock Value/Bonus")
    private String annualStockValueBonus; //5000 shares, 60,000 (theoretically $1 each now), Part of Annual Bonus, 35k USD

    @JsonProperty("Gender")
    private Gender gender;

    @JsonProperty("Additional Comments")
    private String additionalComments;

}
