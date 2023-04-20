package com.flab.toyboardproject.domain.post;

import com.flab.toyboardproject.domain.Status;

public interface PostCreate {
    void save(Post post);

    void updatePost(Long postId, String title, String content);

    void updatePostStatus(Long postId, Status status);
}
