package com.springframework.jobdata.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Nay Myo Htet on 4/8/2023.
 */
@AllArgsConstructor
public enum ApiStatus {
    SUCCESS("success"),

    FAIL("fail"),

    ERROR("error");

    @Getter
    private String status;

    @Override
    public String toString() {
        return this.status;
    }

}
