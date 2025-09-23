package com.sih.michael.civilized_reporting_api.domain.mappers;

import com.sih.michael.civilized_reporting_api.domain.dtos.PostDTO;
import com.sih.michael.civilized_reporting_api.domain.entities.Post;

public interface PostMapper {
    PostDTO toDTO(Post post);
    Post fromDTO(PostDTO postDTO);
}
