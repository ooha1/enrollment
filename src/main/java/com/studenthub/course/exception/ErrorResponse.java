package com.studenthub.course.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private LocalDateTime timeStamp;
    private String message;
    private List<String> details;
}
