package com.flab.toyboardproject.application;

import com.flab.toyboardproject.dto.request.PostSaveRequest;
import com.flab.toyboardproject.dto.request.PostUpdateRequest;
import com.flab.toyboardproject.dto.response.PostInfoResponse;

import java.util.List;

public interface PostService {
    void save(PostSaveRequest postSaveRequest, String loginId);

    List<PostInfoResponse> getPosts();

    PostInfoResponse getPostInfo(Long postId);

    void modify(Long postId, PostUpdateRequest postUpdateRequest);

    void delete(Long postId);
}
