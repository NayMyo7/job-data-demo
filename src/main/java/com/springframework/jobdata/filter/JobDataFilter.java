package com.springframework.jobdata.filter;

import com.springframework.jobdata.model.JobData;
import com.springframework.jobdata.type.Operator;
import com.springframework.jobdata.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.function.Predicate;

/**
 * Created by Nay Myo Htet on 4/9/2023.
 */
public class JobDataFilter implements Filter<JobData> {

    private String field;
    private Operator operator;
    private Object value;

    @Override
    public Predicate<JobData> buildPredicate() {
        if (field == null || operator == null || value == null) {
            return null;
        }

        return jobData -> {
            Object fieldValue = ReflectionUtils.getFieldValue(jobData, field, value);

            switch (operator) {
                case EQUAL:
                    return isNotNull(fieldValue) && fieldValue.equals(value);
                case LIKE:
                    return isNotNull(fieldValue) && fieldValue.toString().contains(value.toString());
                case GREATER_THAN:
                    return isNotNull(fieldValue) && ((Comparable) fieldValue).compareTo(value) > 0;
                case GREATER_THAN_EQUAL:
                    return isNotNull(fieldValue) && ((Comparable) fieldValue).compareTo(value) >= 0;
                case LESS_THAN:
                    return isNotNull(fieldValue) && ((Comparable) fieldValue).compareTo(value) < 0;
                case LESS_THAN_EQUAL:
                    return isNotNull(fieldValue) && ((Comparable) fieldValue).compareTo(value) <= 0;
                default:
                    return false;
            }
        };
    }

    private boolean isNotNull(Object obj) {
        return obj != null;
    }

    @Override
    public void setField(String field) {
        this.field = field;
    }

    @Override
    public void setOperator(String operator) {
        this.operator = Operator.fromString(operator);
    }

    @Override
    public void setValue(String value) {
        // Get the field type and convert the value to the same type
        try {
            Field field = JobData.class.getDeclaredField(this.field);
            field.setAccessible(true);
            Class<?> fieldType = field.getType();
            this.value = ReflectionUtils.convertValueToFieldType(value, fieldType);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Invalid field: " + this.field, e);
        }
    }
}
