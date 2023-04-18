package com.flab.toyboardproject.application;

import com.flab.toyboardproject.domain.Status;
import com.flab.toyboardproject.domain.member.Member;
import com.flab.toyboardproject.domain.member.MemberFind;
import com.flab.toyboardproject.domain.post.Post;
import com.flab.toyboardproject.domain.post.PostCreate;
import com.flab.toyboardproject.domain.post.PostFind;
import com.flab.toyboardproject.dto.request.PostSaveRequest;
import com.flab.toyboardproject.dto.request.PostUpdateRequest;
import com.flab.toyboardproject.dto.response.PostInfoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PostServiceImpl implements PostService {
    private final PostCreate postCreate;
    private final PostFind postFind;
    private final MemberFind memberFind;

    public PostServiceImpl(PostCreate postCreate, PostFind postFind, MemberFind memberFind) {
        this.postCreate = postCreate;
        this.postFind = postFind;
        this.memberFind = memberFind;
    }

    @Override
    public void save(PostSaveRequest postSaveRequest, String loginId) {
        Member member = memberFind.getMemberInfo(loginId);
        if (Objects.isNull(member)) {
            throw new IllegalArgumentException("해당 회원이 존재하지 않습니다.");
        }

        Post post = postSaveRequest.toEntity(member.getId());
        postCreate.save(post);
    }

    @Override
    public List<PostInfoResponse> getPosts() {
        return postFind.getPosts();
    }

    @Override
    public PostInfoResponse getPostInfo(Long postId) {
        return postFind.getPostInfo(postId);
    }

    @Override
    public void modify(Long postId, PostUpdateRequest postUpdateRequest) {
        Post post = postFind.getPost(postId);
        if (Objects.isNull(post)) {
            throw new IllegalArgumentException("해당 게시물이 없습니다.");
        }

        postCreate.updatePost(postId, postUpdateRequest.getTitle(), postUpdateRequest.getContent());
    }

    @Override
    public void delete(Long postId) {
        Post post = postFind.getPost(postId);
        if (Objects.isNull(post)) {
            throw new IllegalArgumentException("해당 게시물이 없습니다.");
        }

        postCreate.updatePostStatus(postId, Status.INACTIVE);
    }
}
