//package com.sih.michael.civilized_reporting_api.services.impl;
//
//import com.sih.michael.civilized_reporting_api.domain.entities.Tag;
//import com.sih.michael.civilized_reporting_api.repositories.TagRepository;
//import com.sih.michael.civilized_reporting_api.services.TagService;
//import jakarta.persistence.EntityNotFoundException;
//import jakarta.transaction.Transactional;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.Set;
//
//@Service
//@RequiredArgsConstructor
//public class TagServiceImpl implements TagService {
//    private final TagRepository tagRepository;
//
//
//    @Override
//    public List<Tag> getAllTags() {
//        return tagRepository.findAllWithOptimization();
//    }
//
//    @Override
//    public Tag createTag(Tag tag) {
//        if(tagRepository.existsByNameIgnoreCase(tag.getName()))
//            throw new IllegalArgumentException("Tag by that name already exists : "+tag.getName());
//        return tagRepository.save(tag);
//    }
//
//    @Transactional
//    @Override
//    public void deleteTag(Integer id) {
////        Optional<Tag> tag =tagRepository.findById(id);
////        if(tag.isPresent()){
////            if (!tag.get().getPosts().isEmpty()){
////                throw new IllegalStateException("This tag cant be deleted I has posts associated with it :"+tag.get().getName());
////            }
////            tagRepository.deleteById(id);
////        }
//
//    }
//
//    @Override
//    public Tag findTagById(Integer id) {
//        return tagRepository.findById(id)
//                .orElseThrow(() ->new EntityNotFoundException("No Department by that name exists!"));
//    }
//
//    @Override
//    public List<Tag> getTagByIds(Set<Integer> ids) {
//        List<Tag> foundTags =  tagRepository.findAllById(ids);
//        if(foundTags.size() != ids.size()){
//            throw new EntityNotFoundException("Not All Tags Specified exist!");
//        }
//        return foundTags;
//    }
//}
