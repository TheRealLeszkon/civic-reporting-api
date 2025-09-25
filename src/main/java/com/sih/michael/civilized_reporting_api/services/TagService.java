package com.sih.michael.civilized_reporting_api.services;

import com.sih.michael.civilized_reporting_api.domain.entities.Tag;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public interface TagService {

    List<Tag> getAllTags();

    Tag createTags(Set<Tag> tags);

    void deleteTag(Integer id);


    List<Tag> getTagByIds(Set<Integer> ids);
}
