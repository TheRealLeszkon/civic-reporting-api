package com.sih.michael.civilized_reporting_api.services.impl;

import com.sih.michael.civilized_reporting_api.domain.entities.Comment;
import com.sih.michael.civilized_reporting_api.domain.entities.Post;
import com.sih.michael.civilized_reporting_api.repositories.CommentRepository;
import com.sih.michael.civilized_reporting_api.services.CommentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    @Override
    public Comment create(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> findByPost(Post post) {
        return commentRepository.findByPost(post);
    }

    @Override
    public void delete(UUID commentId, UUID userId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new EntityNotFoundException("Comment not found"));

        // Optional: only allow the comment owner to delete
        if (!comment.getUser().getId().equals(userId)) {
            throw new IllegalStateException("Unauthorized to delete this comment");
        }

        commentRepository.delete(comment);
    }
}
