package com.springframework.jobdata.controller;

import com.springframework.jobdata.config.Messages;
import com.springframework.jobdata.dto.ApiResponse;
import com.springframework.jobdata.type.ApiStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Nay Myo Htet on 4/8/2023.
 */
@RestController
@Slf4j
public class BaseController<T> {

    @Autowired
    Messages messages;

    /**
     * Return 200 OK response with status, message and data.</br>
     * <p>
     * {@link ApiStatus} is always success by default.
     *
     * @param message to give information about response.
     * @param data    the list of generic response data.
     * @return {@link ApiResponse}
     * @see ApiResponse
     */
    protected ResponseEntity<ApiResponse<List<T>>> okResponse(String message, List<T> data) {

        log.info(HttpStatus.OK.toString(), ApiStatus.SUCCESS.toString(), message, data);

        ApiResponse<List<T>> responses = ApiResponse.<List<T>>builder()
                .message(message)
                .data(data)
                .build();

        return ResponseEntity.ok(responses);
    }
}
