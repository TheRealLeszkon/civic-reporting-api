package com.sih.michael.civilized_reporting_api.domain.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateTagRequest {
    @NotEmpty(message = "At least one tag name is required!")
    @Size(max = 10,message = "Maximum {max} tags are allowed.")

    private Set<
            @Size(min = 2,max=50,message = "Department name must be between {min} and {max} characters")
            @Pattern(regexp = "[\\w\\s-]+$",message = "A department can only contain letters, numbers, spaces and Hyphens")
            String> names;
}
