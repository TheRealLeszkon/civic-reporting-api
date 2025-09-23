package com.sih.michael.civilized_reporting_api.domain.mappers.impl;

import com.sih.michael.civilized_reporting_api.domain.CreatePostRequest;
import com.sih.michael.civilized_reporting_api.domain.dtos.CreatePostRequestDTO;
import com.sih.michael.civilized_reporting_api.domain.mappers.CreatePostRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class CreatePostRequestMapperImpl implements CreatePostRequestMapper {

    @Override
    public CreatePostRequest fromDTO(CreatePostRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        return CreatePostRequest.builder()
                .title(dto.getTitle())
                .description(dto.getDescription())
                .departmentId(dto.getDepartmentId())
                .tagIds(dto.getTagIds())
                .status(dto.getStatus())
                .lat(dto.getLat())
                .lon(dto.getLon())
                .build();
    }

    @Override
    public CreatePostRequestDTO toDTO(CreatePostRequest request) {
        if (request == null) {
            return null;
        }
        return CreatePostRequestDTO.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .departmentId(request.getDepartmentId())
                .tagIds(request.getTagIds())
                .status(request.getStatus())
                .lat(request.getLat())
                .lon(request.getLon())
                .build();
    }
}

