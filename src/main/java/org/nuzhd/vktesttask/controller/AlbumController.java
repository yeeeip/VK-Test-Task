package org.nuzhd.vktesttask.controller;

import lombok.RequiredArgsConstructor;
import org.nuzhd.vktesttask.dto.album.AlbumCreateRequest;
import org.nuzhd.vktesttask.dto.album.AlbumPatchRequest;
import org.nuzhd.vktesttask.dto.album.AlbumUpdateRequest;
import org.nuzhd.vktesttask.dto.post.PostCreateRequest;
import org.nuzhd.vktesttask.dto.post.PostPatchRequest;
import org.nuzhd.vktesttask.dto.post.PostUpdateRequest;
import org.nuzhd.vktesttask.entity.Album;
import org.nuzhd.vktesttask.entity.Post;
import org.nuzhd.vktesttask.service.AlbumService;
import org.nuzhd.vktesttask.service.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/albums")
public class AlbumController {

    private final AlbumService albumService;

    @GetMapping
    public ResponseEntity<List<Album>> getAllPosts() {
        List<Album> albums = albumService.getAllAlbums();

        return ResponseEntity
                .ok(albums);
    }

    @GetMapping("/{albumId}")
    public ResponseEntity<Album> getAlbumById(@PathVariable("albumId") Long albumId) {
        Album album = albumService.getAlbumById(albumId);

        return ResponseEntity
                .ok(album);
    }

    @PostMapping
    public ResponseEntity<Album> createAlbum(@RequestBody AlbumCreateRequest albumCreateRequest) {
        Album createdAlbum = albumService.createAlbum(albumCreateRequest);

        return ResponseEntity
                .ok(createdAlbum);
    }

    @PutMapping("/{albumId}")
    public ResponseEntity<Album> updateAlbum(@PathVariable("albumId") Long albumId, @RequestBody AlbumUpdateRequest albumUpdateRequest) {
        Album updatedAlbum = albumService.updateAlbum(albumId, albumUpdateRequest);

        return ResponseEntity
                .ok(updatedAlbum);
    }

    @PatchMapping("/{albumId}")
    public ResponseEntity<Album> patchAlbum(@PathVariable("albumId") Long albumId, @RequestBody AlbumPatchRequest albumPatchRequest) {
        Album patchedAlbum = albumService.patchAlbum(albumId, albumPatchRequest);

        return ResponseEntity
                .ok(patchedAlbum);
    }

    @DeleteMapping("/{albumId}")
    public ResponseEntity<Void> deletePost(@PathVariable("albumId") Long albumId) {
        albumService.deleteAlbum(albumId);

        return ResponseEntity
                .noContent()
                .build();
    }
}
