package com.sih.michael.civilized_reporting_api.controllers;

import com.sih.michael.civilized_reporting_api.domain.dtos.TagDTO;
import com.sih.michael.civilized_reporting_api.domain.entities.Tag;
import com.sih.michael.civilized_reporting_api.domain.mappers.TagMapper;
import com.sih.michael.civilized_reporting_api.services.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/tags")
public class TagController {
    private final TagMapper tagMapper;
    private final TagService tagService;
    @GetMapping
    public List<TagDTO> showAllTags(){
        return tagService.getAllTags().stream().map(tagMapper::toDTO).toList();
    }

    @PostMapping
    public ResponseEntity<TagDTO> createNewTag(@RequestBody TagDTO tagDTO){
        return new ResponseEntity<>(
                tagMapper.toDTO(
                        tagService.createTag(tagMapper.fromDTO(tagDTO))
                ), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Integer id){
        tagService.deleteTag(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
