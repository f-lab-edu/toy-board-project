package com.flab.toyboardproject.domain.post;

import com.flab.toyboardproject.domain.Status;
import org.springframework.util.Assert;

import java.time.LocalDateTime;

public class Post {
    private Long id;
    private Long memberId;
    private String title;
    private String content;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Post(Long memberId, String title, String content, Status status) {
        Assert.notNull(memberId, "게시글 작성자 정보가 없습니다.");
        Assert.notNull(title, "게시글 제목은 필수 입니다.");
        Assert.notNull(content, "게시글 내용은 필수 입니다.");
        Assert.notNull(status, "게시글 상태를 알 수가 없습니다.");

        this.memberId = memberId;
        this.title = title;
        this.content = content;
        this.status = status;
    }
}
