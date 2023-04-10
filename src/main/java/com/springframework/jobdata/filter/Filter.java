package com.springframework.jobdata.filter;

import java.util.function.Predicate;

/**
 * Created by Nay Myo Htet on 4/9/2023.
 */
public interface Filter<T> {
    Predicate<T> buildPredicate();

    void setField(String field);

    void setOperator(String operator);

    void setValue(String value);
}
