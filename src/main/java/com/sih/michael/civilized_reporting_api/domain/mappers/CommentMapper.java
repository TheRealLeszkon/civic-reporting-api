package com.sih.michael.civilized_reporting_api.domain.mappers;

import com.sih.michael.civilized_reporting_api.domain.dtos.CommentDTO;
import com.sih.michael.civilized_reporting_api.domain.entities.Comment;
import com.sih.michael.civilized_reporting_api.domain.entities.Post;
import com.sih.michael.civilized_reporting_api.domain.entities.User;
import org.springframework.stereotype.Component;


public interface CommentMapper {
    CommentDTO toDTO(Comment comment);
    Comment fromDTO(CommentDTO commentDTO, Post post, User user);

}
