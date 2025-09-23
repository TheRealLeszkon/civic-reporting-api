package com.sih.michael.civilized_reporting_api.domain.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateDepartmentRequest {
    @NotBlank(message = "The Department Name is Required!")
    @Size(min = 2,max=50,message = "Department name must be between {min} and {max} characters")
    @Pattern(regexp = "[\\w\\s-]+$",message = "A department can only contain letters, numbers, spaces and Hyphens")
    private String name;
}
