package org.nuzhd.vktesttask.service.impl;

import lombok.RequiredArgsConstructor;
import org.nuzhd.vktesttask.client.PostsClient;
import org.nuzhd.vktesttask.dto.post.PostCreateRequest;
import org.nuzhd.vktesttask.dto.post.PostPatchRequest;
import org.nuzhd.vktesttask.dto.post.PostUpdateRequest;
import org.nuzhd.vktesttask.entity.Post;
import org.nuzhd.vktesttask.service.PostService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostsClient client;

    @Override
    @Cacheable("posts")
    public List<Post> getAllPosts() {
        return client.getAllPosts();
    }

    @Override
    @Cacheable("posts")
    public Post getPostById(Long postId) {
        return client.getPostById(postId);
    }

    @Override
    public Post createPost(PostCreateRequest postCreateRequest) {
        return client.createPost(postCreateRequest);
    }

    @Override
    @CachePut(value = "posts", key = "#postId")
    public Post updatePost(Long postId, PostUpdateRequest postUpdateRequest) {
        return client.updatePost(postId, postUpdateRequest);
    }

    @Override
    @CachePut(value="posts", key = "#postId")
    public Post patchPost(Long postId, PostPatchRequest postPatchRequest) {
        return client.patchPost(postId, postPatchRequest);
    }

    @Override
    @CacheEvict("posts")
    public void deletePost(Long postId) {
        client.deletePost(postId);
    }
}
