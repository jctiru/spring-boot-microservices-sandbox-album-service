package io.jctiru.springbootmicroservicessandboxalbumservice.service;

import java.util.List;

import io.jctiru.springbootmicroservicessandboxalbumservice.io.entity.AlbumEntity;

public interface AlbumService {

	List<AlbumEntity> getAlbums(String userId);

}
