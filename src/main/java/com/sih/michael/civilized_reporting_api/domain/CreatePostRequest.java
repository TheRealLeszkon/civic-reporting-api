package com.sih.michael.civilized_reporting_api.domain;

import com.sih.michael.civilized_reporting_api.domain.entities.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatePostRequest {

    private String title;
    private String description;

    private Integer departmentId;

    @Builder.Default
    private Set<Integer> tagIds = new HashSet<>();

    private Status status;


    private BigDecimal lat;
    private BigDecimal lon;
}
