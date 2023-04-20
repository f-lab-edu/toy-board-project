package com.flab.toyboardproject.controller;

import com.flab.toyboardproject.application.PostService;
import com.flab.toyboardproject.dto.request.PostSaveRequest;
import com.flab.toyboardproject.dto.request.PostUpdateRequest;
import com.flab.toyboardproject.dto.response.PostInfoResponse;
import com.flab.toyboardproject.global.auth.context.Authentication;
import com.flab.toyboardproject.global.auth.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/api/posts")
    public void save(@RequestBody PostSaveRequest postSaveRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loginId = (String) authentication.getPrincipal();
        postService.save(postSaveRequest, loginId);
    }

    @GetMapping("/api/posts")
    public List<PostInfoResponse> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/api/posts/{postId}")
    public PostInfoResponse getPostInfo(@PathVariable Long postId) {
        return postService.getPostInfo(postId);
    }

    @PutMapping("/api/posts/{postId}")
    public void modify(@PathVariable Long postId, @RequestBody PostUpdateRequest postUpdateRequest) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loginId = (String) authentication.getPrincipal();
        postService.modify(postId, loginId, postUpdateRequest);
    }

    @DeleteMapping("/api/posts/{postId}")
    public void delete(@PathVariable Long postId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loginId = (String) authentication.getPrincipal();
        postService.delete(postId, loginId);
    }
}
