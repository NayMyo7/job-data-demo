package com.springframework.jobdata.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

/**
 * Created by Nay Myo Htet on 4/9/2023.
 */
@AllArgsConstructor
public enum Operator {
    GREATER_THAN("gt"),
    LESS_THAN("lt"),
    GREATER_THAN_EQUAL("gte"),
    LESS_THAN_EQUAL("lte"),
    NOT_EQUAL("ne"),
    EQUAL("eq"),
    LIKE("like");

    @Getter
    private String operation;

    @Override
    public String toString() {
        return this.operation;
    }

    public static Operator fromString(String source) {
        if (source == null) return null;

        return Stream.of(Operator.values()).filter(e -> e.getOperation().equalsIgnoreCase(source)).findFirst()
                .orElse(null);
    }
}
