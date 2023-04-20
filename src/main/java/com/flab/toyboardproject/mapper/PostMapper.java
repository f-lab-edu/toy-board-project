package com.flab.toyboardproject.mapper;

import com.flab.toyboardproject.domain.post.Post;
import com.flab.toyboardproject.domain.Status;
import com.flab.toyboardproject.dto.response.PostInfoResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    void save(Post post);

    List<PostInfoResponse> getPosts();

    PostInfoResponse getPostInfo(Long postId);

    Post getPost(Long postId);

    void updatePost(Long postId, String title, String content);

    void updatePostStatus(Long postId, Status status);
}
