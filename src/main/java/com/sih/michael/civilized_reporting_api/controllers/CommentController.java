//package com.sih.michael.civilized_reporting_api.controllers;
//
//import com.sih.michael.civilized_reporting_api.domain.dtos.CommentDTO;
//import com.sih.michael.civilized_reporting_api.domain.entities.Comment;
//import com.sih.michael.civilized_reporting_api.domain.entities.Post;
//import com.sih.michael.civilized_reporting_api.domain.entities.User;
//import com.sih.michael.civilized_reporting_api.domain.mappers.CommentMapper;
//import com.sih.michael.civilized_reporting_api.services.CommentService;
//import com.sih.michael.civilized_reporting_api.services.PostService;
//import com.sih.michael.civilized_reporting_api.services.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("/api/v1/posts/{postId}/comments")
//@RequiredArgsConstructor
//public class CommentController {
//
//    private final CommentService commentService;
//    private final PostService postService;
//    private final UserService userService;
//    private final CommentMapper commentMapper;
//
//    @GetMapping
//    public List<CommentDTO> getComments(@PathVariable String postId) {
//        Post post = postService.findById(postId);
//        return commentService.findByPost(post).stream()
//                .map(commentMapper::toDTO)
//                .toList();
//    }
//
//    @PostMapping
//    public ResponseEntity<CommentDTO> createComment(
//            @PathVariable String postId,
//            @RequestBody CommentDTO commentDTO,
//            @RequestAttribute String userId
//    ) {
//        Post post = postService.findPostById(postId);
//        User user = userService.findUserById(userId);
//
////        Comment comment = commentMapper.fromDTO(commentDTO, post, user);
////        Comment saved = commentService.create(comment);
////        comment.setUser(user);
////        post.getComments().add(saved);
//
//        return new ResponseEntity<>(commentMapper.toDTO(saved), HttpStatus.CREATED);
//    }
//
//    @DeleteMapping("/{commentId}")
//    public ResponseEntity<Void> deleteComment(
//            @PathVariable UUID postId,
//            @PathVariable UUID commentId,
//            @RequestAttribute UUID userId
//    ) {
//        commentService.delete(commentId, userId);
//        return ResponseEntity.noContent().build();
//    }
//}
