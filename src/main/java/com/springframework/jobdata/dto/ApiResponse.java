package com.springframework.jobdata.dto;

import com.springframework.jobdata.type.ApiStatus;
import lombok.Builder;
import lombok.Data;

/**
 * Created by Nay Myo Htet on 4/8/2023.
 */
@Data
@Builder
public class ApiResponse<T> {
    @Builder.Default
    private String status = ApiStatus.SUCCESS.toString();

    private String message;

    private T data;
}
