package com.springframework.jobdata.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

/**
 * Created by Nay Myo Htet on 4/8/2023.
 */
public class SalaryDeserializer extends JsonDeserializer<Integer> {

    @Override
    public Integer deserialize(JsonParser parser, DeserializationContext ctx) throws IOException, JsonProcessingException {
        String salaryString = parser.getText();
        try {
            return parseSalary(salaryString);
        } catch (NumberFormatException ex) {
            //throw new JsonParseException(parser, "Invalid salary value: " + salaryString);
            return 0;
        }
    }

    private Integer parseSalary(String salaryString) throws NumberFormatException {
        // Remove any non-numeric characters from the salary string
        String strippedSalary = salaryString.replaceAll("[^0-9]", "");
        return Integer.parseInt(strippedSalary);
    }
}
