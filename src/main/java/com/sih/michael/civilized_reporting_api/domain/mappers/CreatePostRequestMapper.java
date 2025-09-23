package com.sih.michael.civilized_reporting_api.domain.mappers;

import com.sih.michael.civilized_reporting_api.domain.CreatePostRequest;
import com.sih.michael.civilized_reporting_api.domain.dtos.CreatePostRequestDTO;

public interface CreatePostRequestMapper {
    CreatePostRequest fromDTO(CreatePostRequestDTO dto);
    CreatePostRequestDTO toDTO(CreatePostRequest request);
}

