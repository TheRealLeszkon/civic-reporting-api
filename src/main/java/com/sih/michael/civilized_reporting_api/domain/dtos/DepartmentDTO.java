package com.sih.michael.civilized_reporting_api.domain.dtos;

import com.sih.michael.civilized_reporting_api.domain.entities.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {
    private Integer id;
    private String name;
    private List<PostDTO> posts;
    private Integer postCount;
}
