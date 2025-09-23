package com.sih.michael.civilized_reporting_api.services;

import com.sih.michael.civilized_reporting_api.domain.entities.Tag;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public interface TagService {

    List<Tag> getAllTags();

    Tag createTag(Tag tag);

    void deleteTag(Integer id);

    Tag findTagById(Integer id);

    List<Tag> getTagByIds(Set<Integer> ids);
}
