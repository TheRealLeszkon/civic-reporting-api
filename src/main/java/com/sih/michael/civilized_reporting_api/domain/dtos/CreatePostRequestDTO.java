package com.sih.michael.civilized_reporting_api.domain.dtos;

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
public class CreatePostRequestDTO {
    @NotBlank(message = "Title is required!")
    //@Size(min = 3,max = 200,message = "Title must be within size {min} and {max}")
    private String title;
    @NotBlank(message = "Description is required!")
    //@Size(min = 10,max = 5000,message = "Title must be within size {min} and {max}")
    private String description;
    @NotBlank(message = "Department Id is required!")
    private Integer departmentId;

//@Size(max = 10,message = "Maximum {max} tags allowed")
    @Builder.Default
    private Set<Integer> tagIds = new HashSet<>();
    @NotNull(message = "Status is required!")
    private Status status;


    private BigDecimal lat;
    private BigDecimal lon;



}
