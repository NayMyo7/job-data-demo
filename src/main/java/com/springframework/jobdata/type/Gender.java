package com.springframework.jobdata.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Nay Myo Htet on 4/8/2023.
 */
@AllArgsConstructor
public enum Gender {

    MALE("Male"),

    FEMALE("Female");

    @Getter
    @JsonValue
    private String gender;

    @Override
    public String toString() {
        return this.gender;
    }

    @JsonCreator
    public static Gender fromString(String source) {
        if (source == null) return null;

        return Stream.of(Gender.values()).filter(e -> e.getGender().equalsIgnoreCase(source)).findFirst()
                .orElse(null);
    }

    public static List<String> toStringList() {
        return Stream.of(Gender.values())
                .map(Gender::getGender)
                .collect(Collectors.toList());
    }
}
