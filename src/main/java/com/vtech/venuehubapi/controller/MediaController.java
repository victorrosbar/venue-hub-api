package com.vtech.venuehubapi.controller;

import com.vtech.venuehubapi.dto.MediaDTO;
import com.vtech.venuehubapi.resource.MediaResource;
import com.vtech.venuehubapi.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MediaController implements MediaResource {

    @Autowired
    private MediaService service;

    @Override
    public ResponseEntity<MediaDTO> creates(MediaDTO media) {

        return service.creates(media);
    }

}
