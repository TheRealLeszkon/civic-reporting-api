package com.sih.michael.civilized_reporting_api.domain.mappers.impl;

import com.sih.michael.civilized_reporting_api.domain.dtos.CommentDTO;
import com.sih.michael.civilized_reporting_api.domain.entities.Comment;
import com.sih.michael.civilized_reporting_api.domain.entities.Post;
import com.sih.michael.civilized_reporting_api.domain.entities.User;
import com.sih.michael.civilized_reporting_api.domain.mappers.CommentMapper;
import org.springframework.stereotype.Component;

@Component
public class CommentMapperImpl implements CommentMapper {

    @Override
    public CommentDTO toDTO(Comment comment) {
        if (comment == null) return null;

        return CommentDTO.builder()
                .id(comment.getId())
                .text(comment.getText())
                .votes((comment.getVotes()!=null)?comment.getVotes():0)
                .build();
    }

    @Override
    public Comment fromDTO(CommentDTO commentDTO, Post post, User user) {
        if (commentDTO == null) return null;

        return Comment.builder()
                .id(commentDTO.getId())
                .text(commentDTO.getText())
                .votes((commentDTO.getVotes()!=null)?commentDTO.getVotes():0)
                .build();
    }
}
