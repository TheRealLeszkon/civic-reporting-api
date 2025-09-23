package com.sih.michael.civilized_reporting_api.domain.dtos;

import com.sih.michael.civilized_reporting_api.domain.entities.Post;
import com.sih.michael.civilized_reporting_api.domain.entities.User;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {
    private UUID id;
    private String text;
    private Integer votes;
    private String post;
    private String user;

}
