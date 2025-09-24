package com.sih.michael.civilized_reporting_api.domain.dtos;

import com.sih.michael.civilized_reporting_api.domain.entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private String  id;
    private String title;
    private String description;

    // Flattened user info for the frontend
    private String authorId;
    private String authorUsername;
    private String authorAvatar;

    // Tags simplified as string array
    private List<String> tags;

    private String imageUrl;
    private LocationDTO location;

    private CompletionStatus status;
    private Instant createdAt;

    private Integer upvotes;
    private Integer reposts;

//    private List<IssueUpdateDTO> updates;

    private String resolvedImageUrl;
}
