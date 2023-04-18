package com.flab.toyboardproject.infra;

import com.flab.toyboardproject.domain.Status;
import com.flab.toyboardproject.domain.post.Post;
import com.flab.toyboardproject.domain.post.PostCreate;
import com.flab.toyboardproject.mapper.PostMapper;
import org.springframework.stereotype.Repository;

@Repository
public class PostCreateAdapter implements PostCreate {
    private final PostMapper postMapper;

    public PostCreateAdapter(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public void save(Post post) {
        postMapper.save(post);
    }

    @Override
    public void updatePost(Long postId, String title, String content) {
        postMapper.updatePost(postId, title, content);
    }

    @Override
    public void updatePostStatus(Long postId, Status status) {
        postMapper.updatePostStatus(postId, status);
    }
}
