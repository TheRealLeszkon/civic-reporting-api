package com.sih.michael.civilized_reporting_api.services;

import com.sih.michael.civilized_reporting_api.domain.entities.Post;
import com.sih.michael.civilized_reporting_api.domain.entities.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface PostService {
//    List<Post> findAllPosts(Integer departmentId,Integer tagId);
    List<Post> findAllPosts();
    List<Post> findAllDrafts(User user);

    Post createPost(User user, Post Post);

    Post findPostById(String id);

    Post findById(String postId);
}
