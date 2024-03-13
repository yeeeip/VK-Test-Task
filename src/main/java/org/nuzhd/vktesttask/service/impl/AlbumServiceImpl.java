package org.nuzhd.vktesttask.service.impl;

import lombok.RequiredArgsConstructor;
import org.nuzhd.vktesttask.client.AlbumsClient;
import org.nuzhd.vktesttask.dto.album.AlbumCreateRequest;
import org.nuzhd.vktesttask.dto.album.AlbumPatchRequest;
import org.nuzhd.vktesttask.dto.album.AlbumUpdateRequest;
import org.nuzhd.vktesttask.entity.Album;
import org.nuzhd.vktesttask.service.AlbumService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumsClient albumsClient;

    @Override
    @Cacheable("albums")
    public List<Album> getAllAlbums() {
        return albumsClient.getAllAlbums();
    }

    @Override
    @Cacheable("albums")
    public Album getAlbumById(Long albumId) {
        return albumsClient.getAlbumById(albumId);
    }

    @Override
    public Album createAlbum(AlbumCreateRequest albumCreateRequest) {
        return albumsClient.createAlbum(albumCreateRequest);
    }

    @Override
    @CachePut(value = "albums", key = "#albumId")
    public Album updateAlbum(Long albumId, AlbumUpdateRequest albumUpdateRequest) {
        return albumsClient.updateAlbum(albumId, albumUpdateRequest);
    }

    @Override
    @CachePut(value = "albums", key = "#albumId")
    public Album patchAlbum(Long albumId, AlbumPatchRequest albumPatchRequest) {
        return albumsClient.patchAlbum(albumId, albumPatchRequest);
    }

    @Override
    @CacheEvict("albums")
    public void deleteAlbum(Long albumId) {
        albumsClient.deleteAlbum(albumId);
    }
}
