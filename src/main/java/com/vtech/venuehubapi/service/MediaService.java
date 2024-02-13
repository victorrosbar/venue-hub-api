package com.vtech.venuehubapi.service;

import com.vtech.venuehubapi.converter.MediaConverter;
import com.vtech.venuehubapi.dto.MediaDTO;
import com.vtech.venuehubapi.repository.MediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Transactional
    public ResponseEntity<MediaDTO> creates(MediaDTO media){
        mediaRepository.save(MediaConverter.toModel(media));
        return ResponseEntity.ok(media);
    }

}
