package org.nuzhd.vktesttask.controller;

import lombok.RequiredArgsConstructor;
import org.nuzhd.vktesttask.dto.post.PostCreateRequest;
import org.nuzhd.vktesttask.dto.post.PostPatchRequest;
import org.nuzhd.vktesttask.dto.post.PostUpdateRequest;
import org.nuzhd.vktesttask.entity.Post;
import org.nuzhd.vktesttask.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    private final PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();

        return ResponseEntity
                .ok(posts);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPostById(@PathVariable("postId") Long postId) {
        Post post = postService.getPostById(postId);

        return ResponseEntity
                .ok(post);
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostCreateRequest postCreateRequest) {
        Post createdPost = postService.createPost(postCreateRequest);

        return ResponseEntity
                .ok(createdPost);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable("postId") Long postId, @RequestBody PostUpdateRequest postUpdateRequest) {
        Post updatedPost = postService.updatePost(postId, postUpdateRequest);

        return ResponseEntity
                .ok(updatedPost);
    }

    @PatchMapping("/{postId}")
    public ResponseEntity<Post> patchPost(@PathVariable("postId") Long postId, @RequestBody PostPatchRequest postPatchRequest) {
        Post patchedPost = postService.patchPost(postId, postPatchRequest);

        return ResponseEntity
                .ok(patchedPost);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable("postId") Long postId) {
        postService.deletePost(postId);

        return ResponseEntity
                .noContent()
                .build();
    }
}
