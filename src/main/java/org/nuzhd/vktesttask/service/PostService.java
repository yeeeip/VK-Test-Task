package org.nuzhd.vktesttask.service;

import org.nuzhd.vktesttask.dto.post.PostCreateRequest;
import org.nuzhd.vktesttask.dto.post.PostPatchRequest;
import org.nuzhd.vktesttask.dto.post.PostUpdateRequest;
import org.nuzhd.vktesttask.entity.Post;

import java.util.List;

public interface PostService {

    List<Post> getAllPosts();

    Post getPostById(Long postId);

    Post createPost(PostCreateRequest postCreateRequest);

    Post updatePost(Long postId, PostUpdateRequest postUpdateRequest);

    Post patchPost(Long postId, PostPatchRequest postPatchRequest);

    void deletePost(Long postId);
}
