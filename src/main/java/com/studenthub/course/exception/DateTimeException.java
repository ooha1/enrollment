package com.studenthub.course.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class DateTimeException {

    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<?> handleDateParseException(DateTimeParseException ex) {
        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", Instant.now().toString());
        response.put("status", "400");
        response.put("error", "Invalid date format");
        response.put("details", ex.getMessage());

        return ResponseEntity.badRequest().body(response);
    }
}
