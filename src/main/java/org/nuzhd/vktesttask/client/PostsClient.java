package org.nuzhd.vktesttask.client;

import org.nuzhd.vktesttask.dto.post.PostCreateRequest;
import org.nuzhd.vktesttask.dto.post.PostPatchRequest;
import org.nuzhd.vktesttask.dto.post.PostUpdateRequest;
import org.nuzhd.vktesttask.entity.Album;
import org.nuzhd.vktesttask.entity.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "postsClient", url = "https://jsonplaceholder.typicode.com/posts")
public interface PostsClient {

    @GetMapping
    List<Post> getAllPosts();

    @GetMapping("/{postId}")
    Post getPostById(@PathVariable("postId") Long postId);

    @PostMapping
    Post createPost(PostCreateRequest postCreateRequest);

    @PutMapping("/{postId}")
    Post updatePost(@PathVariable("postId") Long postId, PostUpdateRequest postUpdateRequest);

    @PatchMapping("/{postId}")
    Post patchPost(@PathVariable("postId") Long postId, PostPatchRequest postPatchRequest);

    @DeleteMapping("/{postId}")
    void deletePost(@PathVariable("postId") Long postId);

}