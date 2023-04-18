package com.flab.toyboardproject.dto.response;

import com.flab.toyboardproject.domain.Status;

public class PostInfoResponse {
    private String userName;
    private String title;
    private String content;
    private Status status;

    public PostInfoResponse(String userName, String title, String content, Status status) {
        this.userName = userName;
        this.title = title;
        this.content = content;
        this.status = status;
    }

    public String getUserName() {
        return userName;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Status getStatus() {
        return status;
    }
}
