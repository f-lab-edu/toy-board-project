package com.flab.toyboardproject.domain.post;

import com.flab.toyboardproject.dto.response.PostInfoResponse;

import java.util.List;

public interface PostFind {
    List<PostInfoResponse> getPosts();

    PostInfoResponse getPostInfo(Long postId);

    Post getPost(Long postId);
}
