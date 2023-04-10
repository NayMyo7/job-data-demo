package com.springframework.jobdata.util;

import com.springframework.jobdata.type.Gender;

import java.lang.reflect.Field;
import java.time.LocalDateTime;

/**
 * Created by Nay Myo Htet on 4/10/2023.
 */
public class ReflectionUtils {

    public static Object getFieldValue(Object object, String fieldName) {
        try {
            Field field = object.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(object);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static Object getFieldValue(Object object, String field, Object value) {
        try {
            Field fieldName = object.getClass().getDeclaredField(field);
            fieldName.setAccessible(true);
            Object fieldValue = fieldName.get(object);
            if (value != null && !value.getClass().equals(fieldName.getType())) {
                // Convert the value to the same type as the field
                fieldValue = convertValueToFieldType(fieldValue, fieldName.getType());
            }
            return fieldValue;
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException("Invalid field: " + field, e);
        }
    }

    public static Object convertValueToFieldType(Object value, Class<?> fieldType) {
        if (String.class.equals(fieldType)) {
            return String.valueOf(value);
        } else if (Integer.class.equals(fieldType)) {
            return Integer.parseInt(String.valueOf(value));
        } else if (LocalDateTime.class.equals(fieldType)) {
            return LocalDateTime.parse(String.valueOf(value));
        } else if (Gender.class.equals(fieldType)) {
            return Gender.fromString(String.valueOf(value));
        } else {
            throw new UnsupportedOperationException("Unsupported field type: " + fieldType);
        }
    }

}
