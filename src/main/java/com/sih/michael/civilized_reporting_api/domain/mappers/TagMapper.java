package com.sih.michael.civilized_reporting_api.domain.mappers;

import com.sih.michael.civilized_reporting_api.domain.dtos.TagDTO;

import com.sih.michael.civilized_reporting_api.domain.entities.Tag;
import org.springframework.stereotype.Component;


public interface TagMapper {
    Tag fromDTO(TagDTO tagDTO);
    TagDTO toDTO(Tag tag);
}
