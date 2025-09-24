package com.sih.michael.civilized_reporting_api.domain.mappers.impl;

import com.sih.michael.civilized_reporting_api.domain.dtos.LocationDTO;
import com.sih.michael.civilized_reporting_api.domain.dtos.PostDTO;
import com.sih.michael.civilized_reporting_api.domain.entities.Post;
import com.sih.michael.civilized_reporting_api.domain.entities.Status;
import com.sih.michael.civilized_reporting_api.domain.mappers.PostMapper;
import com.sih.michael.civilized_reporting_api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostMapperImpl implements PostMapper {

    private final UserService userService;
    @Override
    public PostDTO toDTO(Post post) {
        return PostDTO.builder()
                .id(post.getId())
                .title(post.getTitle())
                .description(post.getDescription())
                .status(post.getStatus())
                .authorId(post.getUser().getId())
                .authorUsername(post.getUser().getUsername())
                .authorAvatar(post.getAuthorAvatar())
//                .tags(post.getTags().stream().map(Tag::getName).toList())
                .imageUrl(post.getImageUrl())
                .location(new LocationDTO(post.getLat(),post.getLon()))
                .createdAt(post.getCreatedAt())
                .upvotes(post.getUpvotes())
                .reposts(post.getReposts())
                .resolvedImageUrl(post.getResolvedImageUrl())
                .build();

    }

    @Override
    public Post fromDTO(PostDTO postDTO) {
        return Post.builder()
                .id(postDTO.getId())
                .title(postDTO.getTitle())
                .description(postDTO.getDescription())
                .status(postDTO.getStatus())
                .pubStatus(Status.PUBLISHED)
                .authorAvatar(postDTO.getAuthorAvatar())
//                .user(userService.findUserById(postDTO.getAuthorId()))
                .lat(postDTO.getLocation().getLat())
                .lon(postDTO.getLocation().getLng())
                .imageUrl(postDTO.getImageUrl())
                .upvotes(postDTO.getUpvotes())
                .reposts(postDTO.getReposts())
                .createdAt(postDTO.getCreatedAt())
                .resolvedImageUrl(postDTO.getResolvedImageUrl())
                .build();
    }
}
