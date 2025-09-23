package com.sih.michael.civilized_reporting_api.repositories;

import com.sih.michael.civilized_reporting_api.domain.entities.Comment;
import com.sih.michael.civilized_reporting_api.domain.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CommentRepository extends JpaRepository<Comment, UUID> {
    List<Comment> findByPost(Post post);
}
