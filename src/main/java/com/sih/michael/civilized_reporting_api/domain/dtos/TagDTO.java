package com.sih.michael.civilized_reporting_api.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TagDTO {
    private Integer id;
    private String name;
    private Integer postCount;
}
