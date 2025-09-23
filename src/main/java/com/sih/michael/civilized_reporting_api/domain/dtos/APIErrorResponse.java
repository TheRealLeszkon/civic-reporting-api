package com.sih.michael.civilized_reporting_api.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.FieldError;

import java.lang.reflect.Field;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class APIErrorResponse {
    private int status;
    private  String message;
    private List<FieldError> errors;
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class FieldError{
        private String field;
        private String message;

    }
}
