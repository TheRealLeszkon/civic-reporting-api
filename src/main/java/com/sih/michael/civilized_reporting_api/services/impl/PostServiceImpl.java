package com.sih.michael.civilized_reporting_api.services.impl;

import com.sih.michael.civilized_reporting_api.domain.entities.*;
import com.sih.michael.civilized_reporting_api.repositories.PostRepository;
import com.sih.michael.civilized_reporting_api.services.PostService;
import com.sih.michael.civilized_reporting_api.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserService userService;
//    private final DepartmentService departmentService;
//    private final TagService tagService;

//    @Transactional(readOnly = true)
//    @Override
//    public List<Post> findAllPosts(Integer departmentId, Integer tagId) {
//        if(departmentId != null && tagId != null){
//            Tag tag = tagService.findTagById(tagId);
//            Department department = departmentService.findDepartmentById(departmentId);
//            return postRepository.findAllByStatusAndDepartmentAndTagsContaining(Status.PUBLISHED,department,tag);
//        }
//        if (tagId!=null){
//            Tag tag = tagService.findTagById(tagId);
//            return postRepository.findAllByStatusAndTags(Status.PUBLISHED,tag);
//        }
//        if (departmentId!=null){
//            Department department = departmentService.findDepartmentById(departmentId);
//            return postRepository.findAllByStatusAndDepartment(Status.PUBLISHED,department);
//        }
//        return postRepository.findAllByStatus(Status.PUBLISHED);
//    }

    @Override // TODO Make A find By Completion status later for Easier Search
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public List<Post> findAllDrafts(User user) {
        return postRepository.findAllByUser(user);
    }


    @Transactional
    @Override
    public Post createPost(User user,Post post) {
        //User user = post.getUser();//
        post.setUser(user);
        return postRepository.save(post);
    }

    @Override
    public Post findPostById(String id) {
        return postRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User does not exist!")
        );
    }

    @Override
    public Post findById(String postId) {
        return null;
    }

}
