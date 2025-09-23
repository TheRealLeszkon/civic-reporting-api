package com.sih.michael.civilized_reporting_api.controllers;

import com.sih.michael.civilized_reporting_api.domain.CreatePostRequest;
import com.sih.michael.civilized_reporting_api.domain.dtos.CreatePostRequestDTO;
import com.sih.michael.civilized_reporting_api.domain.dtos.PostDTO;
import com.sih.michael.civilized_reporting_api.domain.entities.Post;
import com.sih.michael.civilized_reporting_api.domain.entities.User;
import com.sih.michael.civilized_reporting_api.domain.mappers.CreatePostRequestMapper;
import com.sih.michael.civilized_reporting_api.domain.mappers.PostMapper;
import com.sih.michael.civilized_reporting_api.services.PostService;
import com.sih.michael.civilized_reporting_api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1/posts")
@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostMapper postMapper;
    private final PostService postService;
    private final UserService userService;
    private final CreatePostRequestMapper postRequestMapper;

    @GetMapping
    public List<PostDTO> showAllPosts(
            @RequestParam(required = false) Integer departmentId,
            @RequestParam(required = false) Integer tagId
    ){
        return postService.findAllPosts(departmentId,tagId).stream().map(postMapper::toDTO).toList();
    }

    @GetMapping("/drafts")
    public List<PostDTO> getDrafts(@RequestAttribute UUID userId){
        User loggedInUser = userService.findUserById(userId);
        return postService.findAllDrafts(loggedInUser).stream().map(postMapper::toDTO).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDTO> getAPost(@PathVariable UUID id){
        return new ResponseEntity<>(
                postMapper.toDTO(postService.findPostById(id))
                ,HttpStatus.OK
        );

    }


    @PostMapping
    public ResponseEntity<PostDTO> createNewPost(@RequestBody CreatePostRequestDTO createPostRequestDTO,@RequestAttribute(name = "userId") UUID usrId){
        User loggedInUser = userService.findUserById(usrId);
        Post createdPost = postService.createPost(
                loggedInUser,postRequestMapper.fromDTO(createPostRequestDTO)
        );
        return new ResponseEntity<>(
                postMapper.toDTO(createdPost),
                HttpStatus.CREATED
        );
    }
}
