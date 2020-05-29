package io.jctiru.springbootmicroservicessandboxalbumservice.ui.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.jctiru.springbootmicroservicessandboxalbumservice.io.entity.AlbumEntity;
import io.jctiru.springbootmicroservicessandboxalbumservice.service.AlbumService;
import io.jctiru.springbootmicroservicessandboxalbumservice.ui.model.response.AlbumResponseModel;

@RestController
public class AlbumController {

	@Autowired
	private AlbumService albumService;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("/users/{userId}/albums")
	public List<AlbumResponseModel> getUserAlbums(@PathVariable String userId) {
		List<AlbumResponseModel> returnValue = new ArrayList<>();
		List<AlbumEntity> albumEntities = albumService.getAlbums(userId);

		if (albumEntities == null || albumEntities.isEmpty()) {
			return returnValue;
		}

		Type listType = new TypeToken<List<AlbumResponseModel>>() {
		}.getType();

		returnValue = new ModelMapper().map(albumEntities, listType);
		logger.info("Returning {} albums", returnValue.size());

		return returnValue;
	}

}
