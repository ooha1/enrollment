package com.studenthub.course.exception;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {
    private LocalDateTime timeStamp;
    private String message;
    private List<String> details;

    public ErrorResponse(LocalDateTime timeStamp, String message, List<String> details) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.details = details;
    }

}
