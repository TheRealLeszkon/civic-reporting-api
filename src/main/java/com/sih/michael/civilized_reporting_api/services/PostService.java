package com.sih.michael.civilized_reporting_api.services;

import com.sih.michael.civilized_reporting_api.domain.CreatePostRequest;
import com.sih.michael.civilized_reporting_api.domain.entities.Post;
import com.sih.michael.civilized_reporting_api.domain.entities.User;
import org.springframework.security.core.parameters.P;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public interface PostService {
    List<Post> findAllPosts(Integer departmentId,Integer tagId);
    List<Post> findAllDrafts(User user);

    Post createPost(User user, CreatePostRequest createPostRequest);


    Post findPostById(UUID id);

    Post findById(UUID postId);
}
