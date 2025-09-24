package com.sih.michael.civilized_reporting_api.domain.mappers.impl;

import com.sih.michael.civilized_reporting_api.domain.dtos.TagDTO;
import com.sih.michael.civilized_reporting_api.domain.entities.Tag;
import com.sih.michael.civilized_reporting_api.domain.mappers.TagMapper;
import org.springframework.stereotype.Component;

@Component
public class TagMapperImpl implements TagMapper {

    @Override
    public Tag fromDTO(TagDTO tagDTO) {
        return Tag.builder()
                .id(tagDTO.getId())
                .name(tagDTO.getName())
                .build();
    }

    @Override
    public TagDTO toDTO(Tag tag) {
        return TagDTO.builder()
                .id(tag.getId())
                .name(tag.getName())
//                .postCount((tag.getPosts()!= null)?tag.getPosts().size():0)
                .build();
    }
}
