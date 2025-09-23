package com.sih.michael.civilized_reporting_api.services.impl;

import com.sih.michael.civilized_reporting_api.domain.CreatePostRequest;
import com.sih.michael.civilized_reporting_api.domain.entities.*;
import com.sih.michael.civilized_reporting_api.repositories.PostRepository;
import com.sih.michael.civilized_reporting_api.services.DepartmentService;
import com.sih.michael.civilized_reporting_api.services.PostService;
import com.sih.michael.civilized_reporting_api.services.TagService;
import jakarta.persistence.EntityNotFoundException;
import jdk.jfr.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final DepartmentService departmentService;
    private final TagService tagService;

    @Transactional(readOnly = true)
    @Override
    public List<Post> findAllPosts(Integer departmentId, Integer tagId) {
        if(departmentId != null && tagId != null){
            Tag tag = tagService.findTagById(tagId);
            Department department = departmentService.findDepartmentById(departmentId);
            return postRepository.findAllByStatusAndDepartmentAndTagsContaining(Status.PUBLISHED,department,tag);
        }
        if (tagId!=null){
            Tag tag = tagService.findTagById(tagId);
            return postRepository.findAllByStatusAndTags(Status.PUBLISHED,tag);
        }
        if (departmentId!=null){
            Department department = departmentService.findDepartmentById(departmentId);
            return postRepository.findAllByStatusAndDepartment(Status.PUBLISHED,department);
        }
        return postRepository.findAllByStatus(Status.PUBLISHED);
    }

    @Override
    public List<Post> findAllDrafts(User user) {
        return postRepository.findAllByUserAndStatus(user,Status.DRAFT);
    }

    @Transactional
    @Override
    public Post createPost(User user, CreatePostRequest createPostRequest) {
        Post post = new Post();
        post.setTitle(createPostRequest.getTitle());
        post.setDescription(createPostRequest.getDescription());
        post.setUser(user);
        post.setStatus(createPostRequest.getStatus());
        post.setLat(createPostRequest.getLat());
        post.setLon(createPostRequest.getLon());
        post.setVotes(0);

        Department department =departmentService.findDepartmentById(createPostRequest.getDepartmentId());
        post.setDepartment(department);
        Set<Integer> tagIds = createPostRequest.getTagIds();
        List<Tag> tags = tagService.getTagByIds(tagIds);
        post.setTags(new HashSet<>(tags));
        return postRepository.save(post);

    }

    @Override
    public Post findPostById(UUID id) {
        return postRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("User does not exist!")
        );
    }

    @Override
    public Post findById(UUID postId) {
        return null;
    }

}
