package com.sih.michael.civilized_reporting_api.services;

import com.sih.michael.civilized_reporting_api.domain.entities.Comment;
import com.sih.michael.civilized_reporting_api.domain.entities.Post;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    Comment create(Comment comment);

    List<Comment> findByPost(Post post);

    void delete(UUID commentId, UUID userId);
}
