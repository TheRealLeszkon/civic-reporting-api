package com.sih.michael.civilized_reporting_api.domain.dtos;

import com.sih.michael.civilized_reporting_api.domain.entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private UUID id;
    private String title;
    private String description;
    private PosterDTO poster;
    private DepartmentDTO department;
    private Set<TagDTO> tags;
    private Status status;
    private CompletionStatus completionStatus;
    private List<Comment> comments;
    private Integer votes;
    private BigDecimal lat;
    private BigDecimal lon;
    private LocalDateTime updatedAt;
}
