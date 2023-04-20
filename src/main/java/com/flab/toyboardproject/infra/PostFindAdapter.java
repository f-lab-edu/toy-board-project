package com.flab.toyboardproject.infra;

import com.flab.toyboardproject.domain.post.Post;
import com.flab.toyboardproject.domain.post.PostFind;
import com.flab.toyboardproject.dto.response.PostInfoResponse;
import com.flab.toyboardproject.mapper.PostMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostFindAdapter implements PostFind {
    private final PostMapper postMapper;

    public PostFindAdapter(PostMapper postMapper) {
        this.postMapper = postMapper;
    }

    @Override
    public List<PostInfoResponse> getPosts() {
        return postMapper.getPosts();
    }

    @Override
    public PostInfoResponse getPostInfo(Long postId) {
        return postMapper.getPostInfo(postId);
    }

    @Override
    public Post getPost(Long postId) {
        return postMapper.getPost(postId);
    }
}
