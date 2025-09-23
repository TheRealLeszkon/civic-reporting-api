package com.sih.michael.civilized_reporting_api.domain.mappers.impl;

import com.sih.michael.civilized_reporting_api.domain.dtos.PostDTO;
import com.sih.michael.civilized_reporting_api.domain.dtos.PosterDTO;
import com.sih.michael.civilized_reporting_api.domain.entities.Post;
import com.sih.michael.civilized_reporting_api.domain.entities.User;
import com.sih.michael.civilized_reporting_api.domain.mappers.DepartmentMapper;
import com.sih.michael.civilized_reporting_api.domain.mappers.PostMapper;
import com.sih.michael.civilized_reporting_api.domain.mappers.TagMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PostMapperImpl implements PostMapper {

    private final TagMapper tagMapper;
    private final DepartmentMapper departmentMapper;
    @Override
    public PostDTO toDTO(Post post) {
        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .status(post.getStatus())
                .completionStatus(post.getCompletionStatus())
                .comments(post.getComments())
                .department(
                        departmentMapper.toDTO(post.getDepartment())
                )
                .tags(
                        post.getTags().stream().map(tagMapper::toDTO).collect(Collectors.toSet())
                )
                .votes(post.getVotes())
                .lat(post.getLat())
                .lon(post.getLon())
                .updatedAt(post.getUpdatedAt())
                .build();
    }

    @Override
    public Post fromDTO(PostDTO postDTO) {
        return Post.builder()
                .id(postDTO.getId())
                .title(postDTO.getTitle())
                .description(postDTO.getDescription())
                .status(postDTO.getStatus())
                .completionStatus(postDTO.getCompletionStatus())
                .comments(postDTO.getComments())
                .department(
                        departmentMapper.fromDTO(postDTO.getDepartment())
                )
                .tags(
                        postDTO.getTags().stream().map(tagMapper::fromDTO).collect(Collectors.toSet())
                )
                .votes(postDTO.getVotes())
                .lat(postDTO.getLat())
                .lon(postDTO.getLon())
                .updatedAt(postDTO.getUpdatedAt())
                .build();
    }
}
