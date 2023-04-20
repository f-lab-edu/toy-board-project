package com.flab.toyboardproject.dto.request;

import com.flab.toyboardproject.domain.post.Post;
import com.flab.toyboardproject.domain.Status;

public class PostSaveRequest {
    private String title;
    private String content;

    public PostSaveRequest(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Post toEntity(Long memberId) {
        return new Post(memberId, this.title, this.content, Status.ACTIVE);
    }
}
