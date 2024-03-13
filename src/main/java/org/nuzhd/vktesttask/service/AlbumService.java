package org.nuzhd.vktesttask.service;

import org.nuzhd.vktesttask.dto.album.AlbumCreateRequest;
import org.nuzhd.vktesttask.dto.album.AlbumPatchRequest;
import org.nuzhd.vktesttask.dto.album.AlbumUpdateRequest;
import org.nuzhd.vktesttask.dto.post.PostCreateRequest;
import org.nuzhd.vktesttask.dto.post.PostPatchRequest;
import org.nuzhd.vktesttask.dto.post.PostUpdateRequest;
import org.nuzhd.vktesttask.entity.Album;
import org.nuzhd.vktesttask.entity.Post;

import java.util.List;

public interface AlbumService {

    List<Album> getAllAlbums();

    Album getAlbumById(Long albumId);

    Album createAlbum(AlbumCreateRequest albumCreateRequest);

    Album updateAlbum(Long albumId, AlbumUpdateRequest albumUpdateRequest);

    Album patchAlbum(Long albumId, AlbumPatchRequest albumPatchRequest);

    void deleteAlbum(Long albumId);

}
