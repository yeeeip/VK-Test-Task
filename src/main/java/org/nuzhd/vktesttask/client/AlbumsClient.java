package org.nuzhd.vktesttask.client;

import org.nuzhd.vktesttask.dto.album.AlbumCreateRequest;
import org.nuzhd.vktesttask.dto.album.AlbumPatchRequest;
import org.nuzhd.vktesttask.dto.album.AlbumUpdateRequest;
import org.nuzhd.vktesttask.entity.Album;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "albumsClient", url = "https://jsonplaceholder.typicode.com/albums")
public interface AlbumsClient {
    @GetMapping
    List<Album> getAllAlbums();

    @GetMapping("/{albumId}")
    Album getAlbumById(@PathVariable("albumId") Long albumId);

    @PostMapping
    Album createAlbum(AlbumCreateRequest albumCreateRequest);

    @PutMapping("/{albumId}")
    Album updateAlbum(@PathVariable("albumId") Long albumId, AlbumUpdateRequest albumUpdateRequest);

    @PatchMapping("/{albumId}")
    Album patchAlbum(@PathVariable("albumId") Long albumId, AlbumPatchRequest albumPatchRequest);

    @DeleteMapping("/{albumId}")
    void deleteAlbum(@PathVariable("albumId") Long albumId);
}
